package org.webskey.stopwatch.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonReset extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel timeLabel;

	public ButtonReset(JLabel timeLabel) {
		super("Reset Timer");
		this.timeLabel=timeLabel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timeLabel.setText("00:00:00");
	}
}