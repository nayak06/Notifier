package com.notifier.note;

public class note_bin {
	
	private String notename;
	private String startdate;
	private String status;
	private String description;
	private String enddate;
	private int slno;
	private String remind_date;
	private String tag;
	
	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getNotename() {
		return notename;
	}

	public void setNotename(String notename) {
		this.notename = notename;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getRemind_date() {
		return remind_date;
	}

	public void setRemind_date(String remind_date) {
		this.remind_date = remind_date;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public note_bin(String notename, String startdate, String status, String description, String enddate, int slno,
			String remind_date, String tag) {
		super();
		this.notename = notename;
		this.startdate = startdate;
		this.status = status;
		this.description = description;
		this.enddate = enddate;
		this.slno = slno;
		this.remind_date = remind_date;
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "note_bin [notename=" + notename + ", startdate=" + startdate + ", status=" + status + ", description="
				+ description + ", enddate=" + enddate + ", slno=" + slno + ", remind_date=" + remind_date + ", tag="
				+ tag + "]";
	}

	

	
	
	

}
