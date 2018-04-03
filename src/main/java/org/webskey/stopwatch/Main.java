package org.webskey.stopwatch;

import org.webskey.stopwatch.UI.*;;

public class Main {
	public static void main(String args[]) {

		SplashScreen sw = new SplashScreen();
		//  EventQueue.invokeLater(() -> {
		MainWindow ex = new MainWindow();
		if(ex.isVisible())
			sw.setVisible(false);
		//    });
	}
}