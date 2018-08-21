package org.webskey.stopwatch;

import org.webskey.stopwatch.UI.*;;

public class Main {
	public static void main(String args[]) {

		SplashScreen sw = new SplashScreen();
		//  EventQueue.invokeLater(() -> {
		MainWindow mainWindow = new MainWindow();
		if(mainWindow.isVisible())
			sw.setVisible(false);
		//    });
	}
}