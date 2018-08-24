package org.webskey.stopwatch.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import org.webskey.stopwatch.SysTray;

import com.google.inject.Inject;

public class ButtonStart extends JButton implements ActionListener{

	private static final long serialVersionUID = -6665171712231629837L;
	private Timer timer;
	
	@Inject
	SysTray sysTray;

	public ButtonStart() {
		super("Start");
		addActionListener(this);
	}
	
	public void setTimer(Timer timer) {
		this.timer=timer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(timer.isRunning()) {
			timer.stop();
			this.setText("Start");
			sysTray.setTrayIcon("/icon.png");
		} 
		else {
			this.setText("Pause");
			timer.start();
			sysTray.setTrayIcon("/gif.gif");
		}
	}
}