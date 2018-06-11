package boundary.rest_interface;

import exceptions.DALException;

public interface IWeightREST {

	/**
	 * Initiate a connection to a weight
	 * @param ip
	 * @param port
	 * @return 
	 * @throws DALException
	 */
	public void doConnection(String ip, int port) throws DALException;
	
	
}
