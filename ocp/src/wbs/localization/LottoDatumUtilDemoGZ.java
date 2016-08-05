package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LottoDatumUtilDemoGZ {

	public static void main(String[] args) {

		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"EEE', der 'dd. MMMM yyyy, HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat(
				"EEE', der 'dd. MMMM yyyy");

		List<GregorianCalendar> abgabeDaten = new ArrayList<>();
		Date naechsterZiehungstag;
		
		GregorianCalendar dienstag = new GregorianCalendar(2016, Calendar.AUGUST, 2);
		dienstag.set(Calendar.HOUR_OF_DAY, 21);
		
		GregorianCalendar mittwochVor18 = new GregorianCalendar(2016, Calendar.AUGUST, 3);
		mittwochVor18.set(Calendar.HOUR_OF_DAY, 17);
		
		GregorianCalendar mittwochNach18 = new GregorianCalendar(2016, Calendar.AUGUST, 3);
		mittwochNach18.set(Calendar.HOUR_OF_DAY, 20);
		
		GregorianCalendar mittwochExakt18 = new GregorianCalendar(2016, Calendar.AUGUST, 3);
		mittwochExakt18.set(Calendar.HOUR_OF_DAY, 18);
		
		GregorianCalendar donnerstag = new GregorianCalendar(2016, Calendar.AUGUST, 4);
		donnerstag.set(Calendar.HOUR_OF_DAY, 20);
		
		GregorianCalendar samstagVor19 = new GregorianCalendar(2016, Calendar.AUGUST, 6);
		samstagVor19.set(Calendar.HOUR_OF_DAY, 14);
		
		GregorianCalendar samstagExakt19 = new GregorianCalendar(2016, Calendar.AUGUST, 6);
		samstagExakt19.set(Calendar.HOUR_OF_DAY, 19);
		
		GregorianCalendar samstagNach19 = new GregorianCalendar(2016, Calendar.AUGUST, 6);
		samstagNach19.set(Calendar.HOUR_OF_DAY, 20);
		
		GregorianCalendar sonntag = new GregorianCalendar(2016, Calendar.AUGUST, 7);
		sonntag.set(Calendar.HOUR_OF_DAY, 14);
		
		abgabeDaten.add(dienstag);
		abgabeDaten.add(mittwochVor18);
		abgabeDaten.add(mittwochExakt18);
		abgabeDaten.add(mittwochNach18);
		abgabeDaten.add(donnerstag);
		abgabeDaten.add(samstagVor19);
		abgabeDaten.add(samstagExakt19);
		abgabeDaten.add(samstagNach19);
		abgabeDaten.add(sonntag);
		
		System.out.println("--- nur mittwoch ---");
		for(GregorianCalendar abgabeDatum : abgabeDaten) {
			naechsterZiehungstag = LottoDatumUtilBB.ersterZiehungsTag(abgabeDatum.getTime(), true,
					false, 18, 19);
			System.out.println(sdf1.format(abgabeDatum.getTime()) + " -> " + sdf2.format(naechsterZiehungstag));
		}
		
		System.out.println("--- nur samstag ---");
		for(GregorianCalendar abgabeDatum : abgabeDaten) {
			naechsterZiehungstag = LottoDatumUtilBB.ersterZiehungsTag(abgabeDatum.getTime(), false,
					true, 18, 19);
			System.out.println(sdf1.format(abgabeDatum.getTime()) + " -> " + sdf2.format(naechsterZiehungstag));
		}
		
		System.out.println("--- mittwoch und samstag ---");
		for(GregorianCalendar abgabeDatum : abgabeDaten) {
			naechsterZiehungstag = LottoDatumUtilBB.ersterZiehungsTag(abgabeDatum.getTime(), true,
					true, 18, 19);
			System.out.println(sdf1.format(abgabeDatum.getTime()) + " -> " + sdf2.format(naechsterZiehungstag));
		}
	}
}
