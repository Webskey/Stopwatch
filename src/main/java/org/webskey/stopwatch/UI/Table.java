package org.webskey.stopwatch.UI;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JTextField activityTextField;

	public Table(DefaultTableModel tableModel,JTextField activityTextField) {
		super(tableModel);
		this.activityTextField=activityTextField;

		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			String Data = null;  
			int[] row = getSelectedRows();
			for (int i = 0; i < row.length; i++) {  
				Data = (String) getValueAt(row[i], 0); 
			}
			activityTextField.setText(Data);
			repaint();
		}
	}
}
