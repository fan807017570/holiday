package com.zxzh.kjc.holiday.entitiy;

import java.sql.Timestamp;

public class EnvacationEntity {
	private int userId;
	private int vocationId;
	private int term;
	private Timestamp ownYear;
	private int balanceTime;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVocationId() {
		return vocationId;
	}

	public void setVocationId(int vocationId) {
		this.vocationId = vocationId;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public Timestamp getOwnYear() {
		return ownYear;
	}

	public void setOwnYear(Timestamp ownYear) {
		this.ownYear = ownYear;
	}

	public int getBalanceTime() {
		return balanceTime;
	}

	public void setBalanceTime(int balanceTime) {
		this.balanceTime = balanceTime;
	}
}
