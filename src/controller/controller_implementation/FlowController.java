package controller.controller_implementation;

import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class FlowController
{
	
	ProductBatchController pbc;
	UserController user;
	RecipeComponentController rcc;
	CommodityBatchController cbc;
	WeightTranslation weight;
	
	int state = 1;
	int userID = 0;
	double tara = 0;
	int productBatchID = 0;
	int goBack = 0;
	int commodityBatchID = 0;
	
	public FlowController(ProductBatchController pbc, UserController user, RecipeComponentController rcc, CommodityBatchController cbc, WeightTranslation weight) throws DALException
	{
		this.pbc = pbc;
		this.user = user;
		this.rcc = rcc;
		this.cbc = cbc;
		this.weight = weight;
	}
	
	public void weightFlow() throws DALException
	{
		while(state < 9)
		{
			switch(state)
			{
			case 1:
				welcome();
				break;
			case 2:
				enterOprID(0);
				break;
			case 3:
				welcomeAnswer();
				break;
			case 4:
				enterPBID();
				break;
			case 5:
				taraWeight();
				break;
			case 6:
				enterCBID();
				break;
			case 7:
				weightCommodities();
				break;
			case 8:
				finish();
				break;
			default:
				break;
		}
	}
	
}
	
	public void welcome() throws DALException
	{
		System.out.println("State: " + state);
		weight.getInputWithMsg("Tryk ok for fortsaet", "0 for at gaa tilbage", "");
		state += 1;
	}
	
	public void enterOprID(int user) throws DALException
	{		
		System.out.println("State: " + state);
		try {
			if (user==0) {
				userID = Integer.parseInt(weight.getInputWithMsg("Indtast operatoer nummer", "", ""));
			}
			else
			{
				userID = Integer.parseInt(weight.getInputWithMsg("Indtast operatoer nummer", "Bruger-id " + user + "findes ikke", ""));
			}
			
			System.out.println("USER ID: " + userID);
			
			if(userID == goBack)
				state -= 1;
			else state += 1;
		} catch (NumberFormatException e) {
			throw new DALException(e.getMessage());
		} catch (DALException e) {
			String eMsg = e.getMessage();
			System.out.println(eMsg);
			int a = Integer.parseInt(eMsg);
			enterOprID(a);
		}
	}
	
	public void welcomeAnswer() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		String choiceString = weight.getInputWithMsg("Velkommen", user.getUser(userID).getName(), "");
		if (choiceString == "")
			System.out.println("Welcome: " + user.getUser(userID).getName());
		else
		{
			int choiceInt = Integer.parseInt(choiceString);
			if(choiceInt == goBack)
				state -= 1;
			
		}
		state += 1;		
	}
	
	public void enterPBID() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		productBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast productBatchID", "", ""));
		System.out.println("PRODUCTBATCH ID = " + productBatchID);
		
		pbc.getProductBatch(productBatchID).setStatus(1);
		
		if (productBatchID == goBack)
		{
			state -= 1;
			pbc.getProductBatch(productBatchID).setStatus(0);
		}
		
		else state += 1;		
	}
	
	public void taraWeight() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		tara = Double.parseDouble(weight.getInputWithMsg("Placer beholder paa vaegt", "", ""));
		System.out.println("TARA = " + tara);
		
		if((int) tara == goBack)
			state -= 1;
		else state += 1;		
	}
	
	public void enterCBID() throws NumberFormatException, DALException
	{
		commodityBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast raavare batch ID", "", ""));
		System.out.println("CommodityBatch ID: " + commodityBatchID);
		
		if (commodityBatchID == goBack)
			state -= 1;
		else state += 1;
	}
	
	public void weightCommodities() throws DALException
	{
		System.out.println("State: " + state);
		int recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
		System.out.println("RecipeID: " + recipeID);
		double comWeight = 0;
		
		for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++)
		{
			int choice = Integer.parseInt(weight.getInputWithMsg("Vej: " + rcc.getRecipeComponent(recipeID).get(i), "", rcc.getRecipeComponent(recipeID).get(i).getNon_netto() + "g"));
			System.out.println("Weight: " + rcc.getRecipeComponent(recipeID).get(i) + " netto: " + rcc.getRecipeComponent(recipeID).get(i).getNon_netto());
			
			if(choice == goBack)
				break;
			double max = rcc.getRecipeComponent(recipeID).get(i).getNon_netto() + rcc.getRecipeComponent(recipeID).get(i).getTolerance();
			double min = rcc.getRecipeComponent(recipeID).get(i).getNon_netto() - rcc.getRecipeComponent(recipeID).get(i).getTolerance();
			
			while(weight.getWeight() > min && weight.getWeight() < max)
			{
				comWeight = weight.getWeight();
				System.out.println("comWeight: " + comWeight);
				cbc.getCommodityBatch(commodityBatchID).setAmount(comWeight);
				
				double temp = tara + comWeight;
				double temp2 = tara + rcc.getRecipeComponent(recipeID).get(i).getNon_netto();
				System.out.println("Temp: " + temp + " temp2: " + temp2);
			}
		}
		state += 1;
	}
	
	public void finish() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		int choice = Integer.parseInt(weight.getInputWithMsg("Faerdig?", "", ""));
		if(choice == goBack)
			state -= 1;
		else
		{
			pbc.getProductBatch(productBatchID).setStatus(2);
			state += 1;
		}		
	}

}