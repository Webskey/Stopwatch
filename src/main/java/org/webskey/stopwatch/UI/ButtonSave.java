package org.webskey.stopwatch.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.webskey.stopwatch.TableModel;
import org.webskey.stopwatch.sql.Dao;

public class ButtonSave extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel activityLabel;
	private JLabel timeLabel;
	private JTable table;
	private JTextField textField;

	public ButtonSave(JLabel activityLabel, JLabel timeLabel, JTable table, JTextField textField) {
		super("Save");
		this.activityLabel=activityLabel;
		this.timeLabel= timeLabel;
		this.table=table;
		this.textField=textField;

		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int hours = Integer.valueOf(timeLabel.getText().substring(0, 2));
		int minutes = Integer.valueOf(timeLabel.getText().substring(3, 5));
		int seconds = Integer.valueOf(timeLabel.getText().substring(6, 8));
		String activity = activityLabel.getText();

		if(textField.getText().isEmpty())
			JOptionPane.showMessageDialog(getParent(), "Activity field is empty.","Error", JOptionPane.ERROR_MESSAGE);
		else {
			Dao dao= new Dao();
			dao.update(activity,hours,minutes,seconds);
			timeLabel.setText("00:00:00");
			activityLabel.setText(" ");
			textField.setText("");
			table.setModel(new TableModel());
			JOptionPane.showMessageDialog(getParent(), "Activity saved.", "Done", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}