package com.notifier.dashboard;

public class remindNotificationBin {
	private String notename;
	private String reminddate;
	@Override
	public String toString() {
		return "remindNotificationBin [notename=" + notename + ", reminddate=" + reminddate + "]";
	}
	public String getNotename() {
		return notename;
	}
	public void setNotename(String notename) {
		this.notename = notename;
	}
	public String getReminddate() {
		return reminddate;
	}
	public void setReminddate(String reminddate) {
		this.reminddate = reminddate;
	}
	public remindNotificationBin(String notename, String reminddate) {
		super();
		this.notename = notename;
		this.reminddate = reminddate;
	}
	

}
