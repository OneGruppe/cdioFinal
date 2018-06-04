package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ICommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAO implements ICommodityBatchDAO {
	private Connector con;

	public CommodityBatchDAO() throws DALException{
		try {
			con = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new DALException();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#createCommodityBatch(data.dto.CommodityBatchDTO)
	 */
	@Override
	public void createCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException {
		con.doUpdate("INSERT INTO commodityBatch VALUES" +
				"(" + commodityBatch.getCbid() + 
				"," + commodityBatch.getCommodityID() +
				"," + commodityBatch.getAmount() + ")"
				);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#updateCommodityBatch(data.dto.CommodityBatchDTO)
	 */
	@Override
	public void updateCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException {
		con.doUpdate("UPDATE commodityBatch WHERE " +
				"commodityBatchID='" + commodityBatch.getCbid() + "'" + 
				" SET commodityID='" + commodityBatch.getCommodityID() + "'" +
				", amount='" + commodityBatch.getAmount() + "')"
				);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#deleteCommodityBatch(int)
	 */
	@Override
	public void deleteCommodityBatch(int combatchID) throws DALException {
		con.doUpdate("DELETE commodityBatch WHERE"
				+ "commodityBatchID='" + combatchID );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showCommodityBatch(int)
	 */
	@Override
	public CommodityBatchDTO showCommodityBatch(int combatchID) throws DALException {
		int cID = 0;
		double amount = 0;

		ResultSet rs = con.doQuery("SELECT * FROM commodityBatchID "
				+ "WHERE commodityBatchID='" + combatchID + "'");
		
		try {
			if(!rs.first()) {
				throw new DALException();
			}
			while (rs.next()) {
				cID = rs.getInt("commodityID");
				amount = rs.getDouble("amount");
			}
		} catch (SQLException e) {
			throw new DALException();
		}
		return new CommodityBatchDTO(combatchID, cID, amount); 
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showAllCommodityBatches()
	 */
	@Override
	public List<CommodityBatchDTO> showAllCommodityBatches() throws DALException {
		int cbID = 0, cID = 0;
		double amount = 0;
		
		List<CommodityBatchDTO> comBatchList = null;
		ResultSet rs = con.doQuery("SELECT * FROM commodityBatchID");

		try {
			if(!rs.first()) {
				throw new DALException();
			}
			while(rs.next()) {
				cbID = rs.getInt("commodityBatchID");
				cID = rs.getInt("commodityID");
				amount = rs.getDouble("amount");
				comBatchList.add(new CommodityBatchDTO(cbID, cID, amount));
			}
		} catch (SQLException e) {
			throw new DALException();
		}
		return comBatchList;
	}

}
