package org.webskey.stopwatch.dateInfo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodayDate implements DateInfo {

	private GregorianCalendar gcalendar = new GregorianCalendar();
	
	@Override
	public String setDate() {
		return gcalendar.get(Calendar.DATE)+"."+(gcalendar.get(Calendar.MONTH)+1)+"."+gcalendar.get(Calendar.YEAR);
	}
}