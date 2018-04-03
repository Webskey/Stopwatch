package org.webskey.stopwatch.UI;

import java.awt.Font;

import javax.swing.JLabel;

import org.webskey.stopwatch.dateInfo.DateService;
import org.webskey.stopwatch.dateInfo.TodayDate;

public class LabelTotalTime extends JLabel {

	private static final long serialVersionUID = 1L;

	public LabelTotalTime() {
		DateService dateService = new DateService(new TodayDate());
		setText(dateService.getTimeInfo());
		setFont(new Font("", Font.BOLD, 15));
	}
}