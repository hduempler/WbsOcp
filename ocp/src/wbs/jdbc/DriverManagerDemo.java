package wbs.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DriverManagerDemo {
/*
 * Wir ermitteln, welche Treiber dem DriverManager bekannt sind
 * und geben für jeden dieser Treiber den voll qualifizierten
 * Klassennamen aus
 * 
 */
	public static void main(String[] args) {
		 Enumeration<Driver> drivers = DriverManager.getDrivers();
		 
		 while(drivers.hasMoreElements()) {
			 System.out.println(drivers.nextElement().getClass().getName());
		 }

	}

}
