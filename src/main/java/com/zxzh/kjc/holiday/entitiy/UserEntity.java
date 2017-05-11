package com.zxzh.kjc.holiday.entitiy;

import java.sql.Timestamp;
import java.util.Date;

public class UserEntity {
	private int userId;
	private String userName;
	private String realName;
	private String telNumber;
	private int idCard;
	private int departmentId;
	private String sex;
	private Timestamp hireDate;
	private int isMarry;
	private int isaLive;
	private int age;
	private String passWord;
	private int roleId;
	private int location;

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public int getIdcard() {
		return idCard;
	}

	public void setIdcard(int idcard) {
		this.idCard = idcard;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}

	public int getIsMarry() {
		return isMarry;
	}

	public void setIsMarry(int isMarry) {
		this.isMarry = isMarry;
	}

	public int getIsaLive() {
		return isaLive;
	}

	public void setIsaLive(int isaLive) {
		this.isaLive = isaLive;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
