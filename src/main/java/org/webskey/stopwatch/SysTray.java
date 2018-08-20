package org.webskey.stopwatch;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class SysTray {

	private TrayIcon trayIcon;

	public void addSystemTray(MainWindow mainWindow) {
		if (!SystemTray.isSupported())
			return;

		SystemTray systemTray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/icon.png"));
		/*
		PopupMenu popup = new PopupMenu();
		MenuItem cutMenuItem = new MenuItem("Cut");
		cutMenuItem.addActionListener(e ->{
			System.out.println("CUT");
		});

		popup.add(cutMenuItem);
		 */
		trayIcon = new TrayIcon(image, "Stopwatch");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("Stopwatch");
		trayIcon.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {	
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
					mainWindow.setVisible(true);
					mainWindow.toFront();
					mainWindow.setExtendedState(JFrame.NORMAL);
				}
			}
		});

		try {
			systemTray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void displayTray(String time) {	
		trayIcon.displayMessage("Stopwatch", "Time spent today:\n" + time, MessageType.INFO);
		Toolkit.getDefaultToolkit().beep();
	}

}
