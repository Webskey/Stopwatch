package org.webskey.stopwatch.sql;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Dao{

	private JdbcTemplate jdbcTemplate;

	public Dao() {
		this.jdbcTemplate=Connector.INSTANCE.getJdbcTemplate();
	}

	public void update(String activity, int hours, int minutes, int seconds) {
		GregorianCalendar gcalendar = new GregorianCalendar();
		String date = gcalendar.get(Calendar.DATE)+"."+(gcalendar.get(Calendar.MONTH)+1)+"."+gcalendar.get(Calendar.YEAR);
		String sql = "INSERT INTO test3 VALUES(null,'"+activity+"',"+hours+","+minutes+","+seconds+",'"+date+"')";
		jdbcTemplate.update(sql);
	}

	public List<Model> getTableRows(){
		String sql = "SELECT  Activity,"
				+ " SUM(hours) as Hours,SUM(minutes) as Minutes ,SUM(seconds) as Seconds"
				+ " FROM test3 group by Activity order by SUM(hours) desc, SUM(minutes) desc,SUM(seconds) desc;";
		List<Model> model = jdbcTemplate.query(sql, new Mapper());
		return model;
	}
	
	public Model getTime(String date) {
		String sql = "select Activity, SUM(Hours) as Hours, SUM(Minutes) as Minutes, SUM(Seconds) as Seconds from test3 where DateInfo like '"+date+"';";
		Model model = jdbcTemplate.queryForObject(sql, new Mapper());
		return model;
	}
}