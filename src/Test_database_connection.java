import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class Test_database_connection {

	public static void main(String[] args) {
		UserDTO user = new UserDTO(0, "Sebastian", "S", 1);
		UserDAO ud = new UserDAO();
		
		try {
			ud.createUser(user);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

}
