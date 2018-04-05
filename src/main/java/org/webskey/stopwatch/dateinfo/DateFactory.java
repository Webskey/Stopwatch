package org.webskey.stopwatch.dateinfo;

public class DateFactory {

	private DateBuilder dateBuilder;

	public String getTime(String buttonText) {
		switch (buttonText) {
		case "Today":
			dateBuilder = new DateBuilder(new TodayDate());
			break;
		case "This week":
			dateBuilder = new DateBuilder(new ThisWeekDate());
			break;
		default:
			dateBuilder = new DateBuilder(new TotalDate());
		}		
		return dateBuilder.getTimeInfo();
	}
}