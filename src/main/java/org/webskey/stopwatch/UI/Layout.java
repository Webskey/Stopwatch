package org.webskey.stopwatch.UI;

import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JComponent;

public class Layout extends GroupLayout{

	public Layout(Container c,JComponent... arg) {		
		super(c);
		setAutoCreateContainerGaps(true);
		setAutoCreateGaps(true);
		// arg[3] = timeLabel
		arg[3].setFont(new Font("", Font.BOLD, 25));
		//arg[8] = labelTotalTime
		arg[8].setFont(new Font("", Font.BOLD, 20));
		setHorizontalGroup(createParallelGroup()
				.addComponent(arg[0])
				.addComponent(arg[1])
				.addComponent(arg[2])
				.addComponent(arg[3])
			.addGroup(createSequentialGroup()
				.addComponent(arg[4])
				.addComponent(arg[5])
				.addComponent(arg[6]))
				.addComponent(arg[7]) 
				.addComponent(arg[10])
				.addComponent(arg[9])
				.addGroup(createSequentialGroup()
				.addGap(5, 5, 5)
				.addComponent(arg[8]))
				);

		setVerticalGroup(createSequentialGroup()
				.addComponent(arg[0])
				.addComponent(arg[1],PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addComponent(arg[2])
				.addComponent(arg[3])
				 .addGroup(createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(arg[4])
				.addComponent(arg[5])
				.addComponent(arg[6]))
					.addGap(20,20,20)
				.addComponent(arg[7],200,200,200) 
				.addComponent(arg[10])
				.addComponent(arg[9])
				.addComponent(arg[8])
				);
	}
}