package org.webskey.stopwatch.sql;

public class Model {
	private String activity;
	private Integer hours;
	private Integer minutes;
	private Integer seconds;
	private String dateInfo;

	public void setActivity (String activity ) {
		this.activity=activity;
	}
	public String getActivity() {
		return activity;
	}
	public void setHours(Integer hours) {
		this.hours=hours;
	}
	public Integer getHours() {
		return hours;
	}
	public void setMinutes(Integer minutes) {
		this.minutes=minutes;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setSeconds(Integer seconds) {
		this.seconds=seconds;
	}
	public Integer getSeconds() {
		return seconds;
	}
	public void setDateInfo(String dateInfo) {
		this.dateInfo=dateInfo;
	}
	public String getDateInfo() {
		return dateInfo;
	}
}