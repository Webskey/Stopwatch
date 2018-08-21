package org.webskey.stopwatch;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class SysTray {

	private static TrayIcon trayIcon;

	public static TrayIcon getTrayIcon() {
		return trayIcon;
	}

	public TrayIcon getTray() {
		return trayIcon;
	}

	public void addSystemTray(JFrame jFrame) {
		if (!SystemTray.isSupported())
			return;

		SystemTray systemTray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/icon.png"));

		PopupMenu popup = new PopupMenu();

		MenuItem startPauseItem = new MenuItem("Start/Pause");
		popup.add(startPauseItem);

		MenuItem exitItem = new MenuItem("Exit");
		exitItem.addActionListener(e -> {
			jFrame.setVisible(true);
			jFrame.setExtendedState(JFrame.NORMAL);
			jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
		});
		popup.add(exitItem);

		trayIcon = new TrayIcon(image, "Stopwatch", popup);
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("Stopwatch");
		trayIcon.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {	
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
					if(jFrame.isVisible())
						jFrame.setVisible(false);
					else {
						jFrame.setVisible(true);
						jFrame.setExtendedState(JFrame.NORMAL);
					}
				}
			}
		});

		try {
			systemTray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void displayTrayMessage(String time) {	
		trayIcon.displayMessage("Stopwatch", "Time spent today:\n" + time, MessageType.INFO);
		Toolkit.getDefaultToolkit().beep();
	}
}
