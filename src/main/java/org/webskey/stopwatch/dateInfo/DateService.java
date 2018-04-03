package org.webskey.stopwatch.dateInfo;

import org.webskey.stopwatch.TimeFormatParser;
import org.webskey.stopwatch.sql.Dao;
import org.webskey.stopwatch.sql.Model;

public class DateService {

	private DateInfo dateInfo;
	private Dao dao;
	private TimeFormatParser timeFormatParser;
	private Model model;

	public DateService(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	public String getTimeInfo() {
		dao = new Dao();
		model = dao.getTime(dateInfo.setDate());
		timeFormatParser = new TimeFormatParser();

		return timeFormatParser.getTimex(model.getHours(), model.getMinutes(), model.getSeconds());
	}
}