package com.zxzh.kjc.holiday.entitiy.pojo;

import java.sql.Date;

/**
 * @author zqy
 *
 */
public class RecordListPojo {
	private String vocationName;
	private Date startTime;
	private Date endTime;
	private String approvalName;
	private int interval;
	private String status;
	public String getVocationName() {
		return vocationName;
	}
	public void setVocationName(String vocationName) {
		this.vocationName = vocationName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getApprovalName() {
		return approvalName;
	}
	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
