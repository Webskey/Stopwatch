package org.webskey.stopwatch.UI;

import java.awt.Font;

import javax.swing.JLabel;

import org.webskey.stopwatch.dateinfo.DateBuilder;
import org.webskey.stopwatch.dateinfo.TodayDate;

public class LabelTotalTime extends JLabel {

	private static final long serialVersionUID = 1L;

	public LabelTotalTime() {
		DateBuilder dateBuilder = new DateBuilder(new TodayDate());
		setText(dateBuilder.getTimeInfo());
	}
}