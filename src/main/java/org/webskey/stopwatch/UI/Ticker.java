package org.webskey.stopwatch.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import org.webskey.stopwatch.time.TimeCounter;

public class Ticker implements ActionListener{

	private JLabel timeLabel;
	private JLabel totalDayTime;
	private TimeCounter timeCounter;

	public Ticker(JLabel timeLabel,JLabel totalDayTime) {
		this.timeLabel=timeLabel;
		this.totalDayTime=totalDayTime;
		timeCounter = new TimeCounter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timeLabel.setText(timeCounter.doTiming(timeLabel.getText()));
		totalDayTime.setText(timeCounter.doTiming(totalDayTime.getText()));
	}
}