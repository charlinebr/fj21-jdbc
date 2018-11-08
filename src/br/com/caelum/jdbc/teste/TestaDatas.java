package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestaDatas {
public static void main(String[] args) {
	long currentTimeMillis = System.currentTimeMillis();
	Calendar cl = new GregorianCalendar();
	cl.getFirstDayOfWeek();
	
	Calendar instance = Calendar.getInstance();
	Date d = new Date();

	System.out.println(currentTimeMillis);
	System.out.println(instance);
	System.out.println(d.getTime());
}
}
