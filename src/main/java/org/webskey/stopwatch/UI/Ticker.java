package org.webskey.stopwatch.UI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import org.webskey.stopwatch.SysTray;
import org.webskey.stopwatch.time.TimeCounter;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Ticker implements ActionListener{

	@Inject @Named("timeLabel")
	private JLabel timeLabel;
	
	@Inject @Named("totalDayTime")
	private JLabel totalDayTime;

	@Inject
	private SysTray sysTray;
	
	private TimeCounter timeCounter;
	
	public Ticker() {
		this.timeCounter = new TimeCounter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timeLabel.setText(timeCounter.doTiming(timeLabel.getText()));
		
		String totalTime = totalDayTime.getText();
		String totalTimeIncremented = timeCounter.doTiming(totalTime);
		
		if(totalTimeIncremented.matches(".+:[03]0:00")) {
			sysTray.displayTrayMessage(totalTimeIncremented);
			Toolkit.getDefaultToolkit().beep();
		}
		
		sysTray.setToolTip(totalTimeIncremented);
		
		totalDayTime.setText(totalTimeIncremented);
	}
}