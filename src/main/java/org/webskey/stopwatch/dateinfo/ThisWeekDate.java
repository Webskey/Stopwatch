package org.webskey.stopwatch.dateinfo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ThisWeekDate implements DateInfo{

	private GregorianCalendar gcalendar = new GregorianCalendar();
	
	@Override
	public String setDate() {
		String todayDate = gcalendar.get(Calendar.DATE)+"."+(gcalendar.get(Calendar.MONTH)+1)+"."+gcalendar.get(Calendar.YEAR);
		int dayOfWeek = gcalendar.get(Calendar.WEEK_OF_YEAR);
		int i = dayOfWeek;
		while(i==dayOfWeek){
			gcalendar.add(Calendar.DATE, -1);
			i = gcalendar.get(Calendar.WEEK_OF_YEAR);
			if(i!=dayOfWeek)
				continue;
			String addDay ="' or DateInfo LIKE '"+ (gcalendar.get(Calendar.DATE))+"."+(gcalendar.get(Calendar.MONTH)+1)+"."+gcalendar.get(Calendar.YEAR);
			todayDate+=addDay;
		}
		return todayDate;
	}
}