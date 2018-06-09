package controller.controller_interface;

import exceptions.DALException;

public interface IWeightController {

	/**
	 * Controls the methods that makes up the weight flow.
	 * @throws DALException
	 */
	public void weightFlow() throws DALException;

	/**
	 * Shows the welcome message to the user
	 * @throws DALException
	 */
	public void welcome() throws DALException;

	/**
	 * Method to accept the users ID
	 * @throws DALException
	 */
	public void enterOprID() throws DALException;

	/**
	 * Welcomes the user with his name
	 * @throws DALException
	 */
	public void welcomeAnswer() throws DALException;

	/**
	 * Accepts the productBatchID from the user
	 * @throws DALException
	 */
	public void enterPBID() throws DALException;

	/**
	 * taras the weight and saves it in a double
	 * @throws DALException
	 */
	public void taraWeight() throws DALException;

	/**
	 * Accepts the commodityBatchID from the user
	 * @throws DALException
	 */
	public void enterCBID() throws DALException;

	/**
	 * Guides the user to weight each commodity within non netto and toleance
	 * @throws DALException
	 */
	public void weightCommodities() throws DALException;

	/**
	 * Asks the user if he is finished.
	 * @throws DALException
	 */
	public void finish() throws DALException;


}
