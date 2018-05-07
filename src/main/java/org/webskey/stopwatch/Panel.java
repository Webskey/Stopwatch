package org.webskey.stopwatch;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import org.webskey.stopwatch.UI.ButtonReset;
import org.webskey.stopwatch.UI.ButtonSave;
import org.webskey.stopwatch.UI.ButtonStart;
import org.webskey.stopwatch.UI.LabelTotalTime;
import org.webskey.stopwatch.UI.Layout;
import org.webskey.stopwatch.UI.RadioButtonTime;
import org.webskey.stopwatch.UI.Table;
import org.webskey.stopwatch.UI.TableModel;
import org.webskey.stopwatch.UI.TextField;
import org.webskey.stopwatch.UI.Ticker;

public class Panel extends JPanel{

	private static final long serialVersionUID = -1l;

	public Panel()  {

		JLabel activityInfoLabel = new JLabel("Activity:");
		JLabel activityLabel = new JLabel(" ") ;
		JLabel timeInfoLabel = new JLabel("Time:");
		JLabel totalTimeinfoLabel = new JLabel("Total time of:");

		TextField activityTextField = new TextField(15,activityLabel);
		JLabel timeLabel = new JLabel();
		timeLabel.setText("00:00:00");

		DefaultTableModel tableModel = new TableModel();
		Table table=new Table(tableModel,activityTextField);
		JScrollPane jtable=new JScrollPane(table);

		JLabel totalDayTime = new LabelTotalTime();

		Timer  timer = new Timer(1000,new Ticker(timeLabel,totalDayTime));
		JButton buttonStart= new ButtonStart(timer);

		JButton buttonReset = new ButtonReset(timeLabel);

		JButton buttonSave= new ButtonSave(activityLabel,timeLabel,table,activityTextField);

		JPanel radio = new RadioButtonTime(totalDayTime);

		Layout layout = new Layout(this, activityInfoLabel,activityTextField,timeInfoLabel,
				timeLabel,buttonStart,buttonReset,buttonSave,jtable,totalDayTime,radio,totalTimeinfoLabel);

		setLayout(layout);

	}
}