package boundary.rest_interface;

import javax.ws.rs.FormParam;

import exceptions.DALException;

public interface IWeightREST {

	/**
	 * Initiate a connection to a weight
	 * @param chooseWeight
	 * @return
	 * @throws DALException
	 */
	public String doConnection(@FormParam("chooseWeight") int chooseWeight) throws DALException;


}
