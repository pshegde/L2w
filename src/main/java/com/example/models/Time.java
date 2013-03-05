package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.TimeZone;

@XmlRootElement
public class Time {

    private String timezone;
    private  int year;
    private  int month;
    private  int day;
    private  int hour;
    private  int minute;
    private  int second;
    public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	private String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time() {
        this(TimeZone.getDefault());
    }

    public Time(TimeZone timezone) {
        final Calendar now = Calendar.getInstance(timezone);

        this.timezone = now.getTimeZone().getDisplayName();
        this.year = now.get(Calendar.YEAR);
        this.month = now.get(Calendar.MONTH) + 1;
        this.day = now.get(Calendar.DATE);
        this.hour = now.get(Calendar.HOUR);
        this.minute = now.get(Calendar.MINUTE);
        this.second = now.get(Calendar.SECOND);
    }

    public String getTimezone() {
        return timezone;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
