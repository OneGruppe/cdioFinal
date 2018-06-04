package Test;
import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class Test_database_connection {

	public static void main(String[] args) {
		UserDTO user = new UserDTO(0, "Niklaes The Beast", "NB", 1);
		UserDAO ud;
		try {
			ud = new UserDAO();
			ud.createUser(user);
			System.out.println("Created user");
			ud.setUserState(9, 0);
			System.out.println("User " +ud.showUser(9)+ " is now inactive");
		} catch (DALException e1) {
			System.out.println(e1.getMessage());
		}
	}

}
