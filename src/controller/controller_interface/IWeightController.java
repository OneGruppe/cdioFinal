package controller.controller_interface;

import exceptions.DALException;
import exceptions.WeightException;

public interface IWeightController {

	/**
	 * Controls the methods that makes up the weight flow.
	 * @throws DALException when database communication fails
	 * @throws WeightException when the weight returns an error
	 */
	public void weightFlow() throws DALException, WeightException;

	/**
	 * Method to accept the users ID
	 * @throws DALException when database communication fails
	 */
	public void enterOprID() throws DALException;

	/**
	 * Welcomes the user with his name
	 * @throws DALException when database communication fails
	 * @throws WeightException 
	 */
	public void welcomeAnswer() throws WeightException;

	/**
	 * Accepts the productBatchID from the user
	 * @throws DALException when database communication fails
	 * @throws WeightException when the weight returns an error
	 */
	public void enterPBID() throws DALException, WeightException;

	/**
	 * taras the weight and saves it in a double
	 * @throws DALException when database communication fails
	 * @throws WeightException when the weight returns an error
	 */
	public void taraWeight() throws DALException, WeightException;

	/**
	 * Guides the user to weight each commodity within non netto and toleance
	 * @throws DALException when database communication fails
	 * @throws WeightException when the weight returns an error
	 */
	public void weightCommodities() throws DALException, WeightException;

	/**
	 * Asks the user if he is finished.
	 * @throws DALException when database communication fails
	 * @throws WeightException when the weight returns an error
	 */
	public void finish() throws DALException, WeightException;
	
	
}
