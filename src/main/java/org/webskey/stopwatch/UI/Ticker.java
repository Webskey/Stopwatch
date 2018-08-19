package org.webskey.stopwatch.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import org.webskey.stopwatch.SysTray;
import org.webskey.stopwatch.time.TimeCounter;

public class Ticker implements ActionListener{

	private JLabel timeLabel;
	private JLabel totalDayTime;
	private TimeCounter timeCounter;
	private SysTray sysTray;

	public Ticker(JLabel timeLabel,JLabel totalDayTime) {
		this.timeLabel = timeLabel;
		this.totalDayTime = totalDayTime;
		this.timeCounter = new TimeCounter();
		this.sysTray = new SysTray();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timeLabel.setText(timeCounter.doTiming(timeLabel.getText()));
		
		String totalTime = totalDayTime.getText();
		String totalTimeIncremented = timeCounter.doTiming(totalTime);
		
		if(totalTimeIncremented.matches(".+:[03]0:00")) {
			 sysTray.displayTray(totalTimeIncremented);
		}
		
		totalDayTime.setText(totalTimeIncremented);
	}
}