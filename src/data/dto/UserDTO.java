package data.dto;

public class UserDTO
{
	private int userID;
	private String userName;
	private String userIni;
	private int active;
	
	/**
	 * Constuctor for a UserDTO with parameters
	 * @param userID ID of the user
	 * @param userName The name of the user
	 * @param userIni The initials of the user
	 */
	public UserDTO(int userID, String userName, String userIni, int active) {
		this.userID = userID;
		this.userName = userName;
		this.userIni = userIni;
		this.active = active;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIni() {
		return userIni;
	}
	public void setUserIni(String userIni) {
		this.userIni = userIni;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDTO [userID=" + userID + ", userName=" + userName + ", userIni=" + userIni + "]";
	}
	
	
	
}
