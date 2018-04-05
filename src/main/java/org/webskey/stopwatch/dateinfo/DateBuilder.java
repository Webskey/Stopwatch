package org.webskey.stopwatch.dateinfo;

import org.webskey.stopwatch.sql.Dao;
import org.webskey.stopwatch.sql.Model;
import org.webskey.stopwatch.time.TimeFormatParser;

public class DateBuilder {

	private DateInfo dateInfo;
	private Dao dao;
	private TimeFormatParser timeFormatParser;
	private Model model;

	public DateBuilder(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
		dao = new Dao();
		timeFormatParser = new TimeFormatParser();

	}

	public String getTimeInfo() {		
		model = dao.getTime(dateInfo.setDate());
		return timeFormatParser.getTimex(model.getHours(), model.getMinutes(), model.getSeconds());
	}
}