package org.webskey.stopwatch;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public Menu() {

		JMenu fileMenu = new JMenu("File");
		JMenu viewMenu = new JMenu("View");
		JMenu toolsMenu = new JMenu("Tools");
		JMenu helpMenu = new JMenu("Help");

		JMenuItem aboutMi = new JMenuItem("About");
		helpMenu.add(aboutMi);

		add(fileMenu);
		add(viewMenu);
		add(toolsMenu);
		add(Box.createHorizontalGlue());
		add(helpMenu);
	}
}