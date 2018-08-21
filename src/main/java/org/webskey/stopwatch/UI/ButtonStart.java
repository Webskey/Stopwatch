package org.webskey.stopwatch.UI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import org.webskey.stopwatch.SysTray;

public class ButtonStart extends JButton implements ActionListener{

	private static final long serialVersionUID = -6665171712231629837L;
	private Timer timer;

	public ButtonStart(Timer timer) {
		super("Start");
		this.timer=timer;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(timer.isRunning()) {
			timer.stop();
			this.setText("Start");
			SysTray.getTrayIcon().setImage(Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/icon.png")));
		} 
		else {
			this.setText("Pause");
			timer.start();
			SysTray.getTrayIcon().setImage(Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/gif.gif")));
		}
	}
}