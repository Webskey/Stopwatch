package org.webskey.stopwatch;

public class TimeCounter{
	
	private TimeFormatParser timeFormatParser;
	
	public TimeCounter() {
		timeFormatParser = new TimeFormatParser();
	}
	
	public String doTiming(String timeLabel) {
		int hours = Integer.valueOf(timeLabel.substring(0, timeLabel.length()-6));
		int minutes = Integer.valueOf(timeLabel.substring(timeLabel.length()-5, timeLabel.length()-3));
		int seconds = Integer.valueOf(timeLabel.substring(timeLabel.length()-2, timeLabel.length()));
		seconds++;
		return timeFormatParser.getTimex(hours, minutes, seconds);
	}
}
