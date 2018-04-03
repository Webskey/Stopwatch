package org.webskey.stopwatch.UI;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.webskey.stopwatch.dateInfo.DateService;
import org.webskey.stopwatch.dateInfo.ThisWeekDate;
import org.webskey.stopwatch.dateInfo.TodayDate;
import org.webskey.stopwatch.dateInfo.TotalDate;

public class RadioButton extends JPanel implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JLabel totalTimeLabel;

	public RadioButton(JLabel totalTimeLabel) {

		this.totalTimeLabel=totalTimeLabel;

		ButtonGroup group = new ButtonGroup();

		JRadioButton rb1 = new JRadioButton("Today",true);
		JRadioButton rb2 = new JRadioButton("This week");
		JRadioButton rb3 = new JRadioButton("Total");

		group.add(rb1);
		group.add(rb2);
		group.add(rb3);

		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(rb1);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(rb2);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(rb3);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		int sel = e.getStateChange();

		if (sel == ItemEvent.SELECTED) {

			JRadioButton button = (JRadioButton) e.getSource();
			DateService dateService;

			switch (button.getText()) {
			case "Today":
				dateService = new DateService(new TodayDate());
				break;
			case "This week":
				dateService = new DateService(new ThisWeekDate());
				break;
			default:
				dateService = new DateService(new TotalDate());
			}

			totalTimeLabel.setText(dateService.getTimeInfo());
		}
	}
}