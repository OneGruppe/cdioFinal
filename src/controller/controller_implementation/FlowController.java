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
	
	public void initializeObjectsAndStartFlow(ProductBatchController pbc, UserController user, RecipeComponentController rcc, CommodityBatchController cbc, WeightTranslation weight) throws DALException
	{
		this.pbc = pbc;
		this.user = user;
		this.rcc = rcc;
		this.cbc = cbc;
		this.weight = new WeightTranslation("", 8001);
		
		weightFlow();
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
				enterOprID();
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
		weight.removeMsg();
		weight.getInputWithMsg("Tryk -> for at fortsaette", "0 for at gaa tilbage", "&3");
		state += 1;
	}
	
	public void enterOprID() throws NumberFormatException, DALException
	{		
		System.out.println("State: " + state);
		userID = Integer.parseInt(weight.getInputWithMsg("Indtast operatoer nummer", "", "&3"));
		
		System.out.println("USER ID: " + userID);
		
		if(userID == goBack)
			state -= 1;
		else state += 1;
	}
	
	public void welcomeAnswer() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		int choice = Integer.parseInt(weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), "", "&3")); 
		
		System.out.println("Welcome: " + user.getUser(userID).getName());
		
		if(choice == goBack)
			state -= 1;
		else state += 1;		
	}
	
	public void enterPBID() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		productBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast productBatchID", "", "&3"));
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
		tara = Double.parseDouble(weight.getInputWithMsg("Placer beholder paa vaegt", "", "&3"));
		System.out.println("TARA = " + tara);
		
		if((int) tara == goBack)
			state -= 1;
		else state += 1;		
	}
	
	public void enterCBID() throws NumberFormatException, DALException
	{
		commodityBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast raavare batch ID", "", "&3"));
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
		int choice = Integer.parseInt(weight.getInputWithMsg("Faerdig?", "", "&3"));
		if(choice == goBack)
			state -= 1;
		else
		{
			pbc.getProductBatch(productBatchID).setStatus(2);
			state += 1;
		}		
	}

}