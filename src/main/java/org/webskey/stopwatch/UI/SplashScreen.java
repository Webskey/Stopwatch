package org.webskey.stopwatch.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow{

	private static final long serialVersionUID = 1L;

	public SplashScreen(){
		JLabel l = new JLabel(new ImageIcon(this.getClass().getResource("/loading.gif")));
		getContentPane().add(l, BorderLayout.CENTER);
		pack();
		Dimension screenSize =
				Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = l.getPreferredSize();
		setLocation(screenSize.width/2 - (labelSize.width/2),
				screenSize.height/2 - (labelSize.height/2));
		setVisible(true);
		screenSize = null;
		labelSize = null;
	}
}