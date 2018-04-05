package org.webskey.stopwatch.UI;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.webskey.stopwatch.sql.Dao;
import org.webskey.stopwatch.sql.Model;
import org.webskey.stopwatch.time.TimeFormatParser;

public class TableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private static String data[][]={};
	private static String column[]={"Activity","Time"}; 
	private Dao dao;
	private TimeFormatParser timeFormatParser;

	public TableModel() {
		super(data,column);
		dao = new Dao();
		timeFormatParser = new TimeFormatParser();
		
		List<Model> modelList = dao.getTableRows();
		String[] row = new String[2];
		for (Model model : modelList) {
			row[0] = model.getActivity();
			row[1] = timeFormatParser.getTimex(model.getHours(), model.getMinutes(), model.getSeconds());
			addRow(row);
		} 
	}
}
