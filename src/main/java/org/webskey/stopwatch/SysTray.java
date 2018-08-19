package org.webskey.stopwatch;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class SysTray {

	private TrayIcon trayIcon;

	public void addSystemTray() {
		if (!SystemTray.isSupported())
			return;

		SystemTray systemTray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/icon.png"));

		trayIcon = new TrayIcon(image, "Stopwatch");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("Stopwatch");
		
		try {
			systemTray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void displayTray(String time) {	
		trayIcon.displayMessage("Stopwatch", "Time spent today:\n" + time, MessageType.INFO);
	}

}
