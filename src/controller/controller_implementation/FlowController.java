package controller.controller_implementation;

import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class FlowController
{
	WeightTranslation weight = new WeightTranslation("169.254.2.3");
	UserController user = new UserController();

	public void weightFlow() throws DALException
	{
		int state = 1;
		int userID = 0;
		int tara = 0;
		int productBatchID = 0;

		ProductBatchController pbc = new ProductBatchController();

		switch(state)
		{
		case 1:
		{
			weight.removeMsg();
			weight.getInputWithMsg("Tryk temp for at fortsaette, temp2 for at gaa tilbage");
			state +=1;
		}
		case 2:
		{
			System.out.println("-----------------------");
			System.out.println("TRIES TO GET USERID");
			userID = weight.getInputWithMsg("Indtast operatoer nummer");
			System.out.println("USER ID: " + userID);
			System.out.println("-----------------------");

			if(userID != temp2)
			{
				state += 1;
			}
			else state -= 1;
		}
		case 3:
		{
			int choice = weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName()); 

			System.out.println("-----------------------");
			System.out.println("Welcome: " + user.getUser(userID).getName());
			System.out.println("-----------------------");

			if(choice = temp)
				state += 1;
			else state -= 1;
		}
		case 4:
		{
			System.out.println("-----------------------");
			System.out.println("GETS PRODUCTBATCHID");
			productBatchID = weight.getInputWithMsg("Indtast productBatchID");
			System.out.println("PRODUCTBATCH ID = " + productBatchID);
			System.out.println("-----------------------");

			if (productBatchID != temp2)
				state += 1;
			else state -= 1;
		}
		case 5:
		{
			System.out.println("-----------------------");
			System.out.println("GETS TARA");
			tara = weight.getInputWithMsg("Placer beholder på vaegt");
			System.out.println("TARA = " + tara);
			System.out.println("-----------------------");

			if(tara != temp2)
				state += 1;
			else state -= 1;
		}
		case 6:
		{
			weight.getInputWithMsg("Vej: " + pbc.getProductBatch(productBatchID));
		}
		}
	}
}