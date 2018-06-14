package controller.controller_interface;

public interface IWeightController {

	/**
	 * Controls the methods that makes up the weight flow.
	 */
	public void weightFlow();

	/**
	 * Method to accept the users ID
	 */
	public void enterOprID();

	/**
	 * Welcomes the user with his name
	 */
	public void welcomeAnswer();

	/**
	 * Accepts the productBatchID from the user
	 */
	public void enterPBID();

	/**
	 * taras the weight and saves it in a double
	 */
	public void taraWeight();

	/**
	 * Guides the user to weight each commodity within non netto and toleance
	 */
	public void weightCommodities();

	/**
	 * Asks the user if he is finished.
	 */
	public void finish();


}
