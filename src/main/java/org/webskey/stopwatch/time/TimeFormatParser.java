package org.webskey.stopwatch.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatParser {

	public String getTimex(int hours, int minutes, int seconds) {

		int time = hours*3600 + minutes*60 + seconds;
		String amountOfSeconds = String.valueOf(time);
		DateFormat secondsFormat = new SimpleDateFormat("ssssssssss"); 
		DateFormat finalFormat = new SimpleDateFormat("DD:HH:mm:ss");
		Date startDate;

		try {
			startDate = secondsFormat.parse(amountOfSeconds);
			String totalTimeString = finalFormat.format(startDate);
			
			System.out.println(totalTimeString);

			int daysIntoHours = Integer.valueOf(totalTimeString.substring(0, 2))*24-24;
			int totalHours = Integer.valueOf(totalTimeString.substring(3, 5))+daysIntoHours;
			String totalHoursString = String.valueOf(totalHours);

			if(totalHours<10)
				totalHoursString = "0" + totalHoursString;
			String finalTimeString = totalTimeString.substring(3);

			return finalTimeString.replaceFirst(totalTimeString.substring(3, 5), totalHoursString);

		} catch (ParseException ex) { 
			System.out.println("Unparseable using " ); 
		}
		return "";
	}
}
