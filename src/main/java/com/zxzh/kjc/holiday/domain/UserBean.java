package com.zxzh.kjc.holiday.domain;

public class UserBean {
	private String userName;
	private String passwd;
	private int userId;
	private int flag = 0;

	/*public UserBean(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
	}

	public UserBean(int id, String userName, String passwd, int flag) {
		this.userName = userName;
		this.passwd = passwd;
		this.userId = id;
		this.flag = flag;
	}
*/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
