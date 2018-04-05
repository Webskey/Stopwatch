package org.webskey.stopwatch.UI;

import java.awt.Font;

import javax.swing.JLabel;

import org.webskey.stopwatch.dateInfo.DateBuilder;
import org.webskey.stopwatch.dateInfo.TodayDate;

public class LabelTotalTime extends JLabel {

	private static final long serialVersionUID = 1L;

	public LabelTotalTime() {
		DateBuilder dateBuilder = new DateBuilder(new TodayDate());
		setText(dateBuilder.getTimeInfo());
		setFont(new Font("", Font.BOLD, 15));
	}
}