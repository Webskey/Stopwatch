package org.webskey.stopwatch.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper<Model> {
	
	public Model mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Model model = new Model();
		model.setActivity(resultSet.getString("Activity"));
		model.setHours(resultSet.getInt("Hours"));
		model.setMinutes(resultSet.getInt("Minutes"));
		model.setSeconds(resultSet.getInt("Seconds"));
		//model.setDateInfo(rs.getString("DateInfo"));

		return model;
	}
}