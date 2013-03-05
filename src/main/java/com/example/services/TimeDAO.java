package com.example.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.example.models.Time;

public class TimeDAO {
	 public Time findAll() {
	        List<Time> list = new ArrayList<Time>();
	        Connection c = null;
	    	String sql = "SELECT * from time";
	        
	        try {
	            c = ConnectionHelper.getConnection();
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                list.add(processSummaryRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list.get(0);
	    }
	 
	 protected Time processSummaryRow(ResultSet rs) throws SQLException {
	    	Time time = new Time();
	    	 final Calendar now = Calendar.getInstance(TimeZone.getDefault());
	    	 time.setName(rs.getString(0));
	         time.setTimezone(now.getTimeZone().getDisplayName());
	         time.setYear( now.get(Calendar.YEAR));
	         time.setMonth(now.get(Calendar.MONTH) + 1);
	         time.setDay(now.get(Calendar.DATE));
	         time.setHour(now.get(Calendar.HOUR));
	         time.setMinute(now.get(Calendar.MINUTE));
	         time.setSecond(now.get(Calendar.SECOND));
	    	return time;
	    }
}
