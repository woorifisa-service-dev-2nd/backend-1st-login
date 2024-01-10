package dev.project;

public class UserInformation {
	private String userID = "";
	private String userPW = "";
	private String userName = "";
	private String userPhone = "";
	
	public UserInformation(String userID, String userPW, String userName, String userPhone) {
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public String getUserID() {
		return userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}
	
	public String getInfoToString() {
		return String.format("%s %s %s %s" , userID, userPW, userName, userPhone);
	}
	public String getInfoToTable() {
		return String.format("%s | %s | %s | %s" , userID, userPW, userName, userPhone);
	}

}