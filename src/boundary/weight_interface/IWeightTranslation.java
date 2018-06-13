package boundary.weight_interface;

import exceptions.WeightException;

public interface IWeightTranslation {
	
	/**
	 * Shows message on weight, can only show 6 char's
	 * @param recvMessage that is shown on weight.
	 * @throws WeightException if the Weight returns an error
	 */
	public void showMsg(String recvMessage) throws WeightException;

	/**
	 * Removes a normal message on weight.
	 * @param message that is shown on weight, send "" in param to clear text.
	 * @throws WeightException
	 */
	public void removeMsg() throws WeightException;

	/**
	 * Shows a long message, can only show 30 char's
	 * @param message the message that is printed on the weight.
	 * @throws WeightException if the Weight returns an error
	 */
	public void showLongMsg(String recvMessage) throws WeightException;

	/**
	 * Removes a long message
	 * @throws WeightException if the Weight returns an error
	 */
	public void removeLongMsg() throws WeightException;

	/**
	 * Shows a message on the display where the weighter must send a message back.
	 * @param promtMessage Promt string (max. 24 characters)
	 * @param defaultNumber Text/Value to be displayed as default, and to be overwritten by user input. (max. 24 characters)
	 * @param unit Unit (max. 7 characters)
	 * @return int message
	 * @throws WeightException if the Weight returns an error
	 */
	public int getInputWithMsg(String promtMessage, int defaultNumber, String unit) throws WeightException;


	/**
	 * Removes the displayed message on the weight.
	 * @throws WeightException if the Weight returns an error
	 */
	public void removeInputWithMsg() throws WeightException;

	/**
	 * Will take the current weight load of the weight and pull it into a double.
	 * @return weight Weight in the form of a double
	 * @throws WeightException if the Weight returns an error
	 */
	public double getWeight() throws WeightException;

	/**
	 * Will set the tara weight on the weight to what's currently the weights' load.
	 * @return weight Weight in the form of a double
	 * @throws WeightException if the Weight returns an error
	 */
	public double getTaraWeight() throws WeightException;

	/**
	 * Remove the tara weight from the weight.
	 * @throws WeightException if the Weight returns an error
	 */
	public void removeTaraWeight() throws WeightException;

	/**
	 * Shows the normal weight-mode on the display
	 * @throws WeightException if the Weight returns an error
	 */
	public void showWeight() throws WeightException;

	/**
	 * Clearing all that can be cleared, removeMsg() + removeLongMsg() + removeInputWithMsg() + showWeightDisplay()
	 * @throws WeightException if the Weight returns an error
	 */
	public void clearDisplayAndShowWeight() throws WeightException;

	/**
	 * Closes all open objects
	 * @throws WeightException if the Weight returns an error
	 */
	public void closeAllLeaks() throws WeightException;
	
	
}
