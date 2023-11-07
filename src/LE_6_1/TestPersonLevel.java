package LE_6_1;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		Calendar calendar = Calendar.getInstance();
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + " " + month + " " + day + " " );
	}
	
	public MyDate(long elapsedTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(elapsedTime);
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setDate(long elapsedTime) {
		long totalMilliseconds = elapsedTime;
		long totalSecond = totalMilliseconds / 1000;
		long currentSecond = totalSecond % 60;
		long totalMinutes = totalSecond / 60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 60;
		
		int yearsSince1970 = (int) (totalHours / 8760);
//		years = 1970 + yearsSince1970;
		
	}
}

public class TestPersonLevel {
	public static void main(String[] args) {
		MyDate myDate = new MyDate();
	}
}
