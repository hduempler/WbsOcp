package wbs.localization;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LottoDatumUtilBB {

	/*
	 * Wir schreiben die Methode ersterZiehungsTag(). Sie berechnet das Datum,
	 * an dem ein eingereichter Lottoschein zum 1. Mal an einer Ziehung
	 * teilnimmt.
	 */

	// z.B. abgabeSchlussMittwoch: 18 (18 Uhr)
	// z.B. abgabeSchlussSamstag: 19 (19 Uhr)
	public static Date ersterZiehungsTag(Date abgabeDatum, boolean isMittwoch,
			boolean isSamstag, int abgabeSchlussMittwoch,
			int abgabeSchlussSamstag) {
		if (!(isMittwoch || isSamstag)) {
			throw new IllegalArgumentException(
					"Mindestens ein Ziehungstag (Mittwoch oder Samstag) muss angegeben werden");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(abgabeDatum);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int drawDay;
		int endHour;
		int plus = 7;
		int diff;

		if (isMittwoch) {
			drawDay = Calendar.WEDNESDAY;
			diff = (drawDay - weekDay + 7) % 7;
			endHour = abgabeSchlussMittwoch;
			if (isSamstag) {
				if (weekDay == Calendar.WEDNESDAY) {
					plus = 3;
				} else {
					plus = 4;
				}
				diff = ((drawDay - weekDay + 7) % 7) % drawDay;

			}
		} else {
			// nur Samstag
			drawDay = Calendar.SATURDAY;
			diff = (drawDay - weekDay + 7) % 7;
			endHour = abgabeSchlussSamstag;
		}

		if (diff == 0) {
			if (hour >= endHour) {
				diff = plus;
			}
		}
		cal.add(Calendar.DAY_OF_WEEK, diff);
		return cal.getTime();
	}

	// liefert alle Ziehungstage, an denen ein Lottoschein mit gegebenem
	// Abgabedatum teilnimmt
	public static List<Date> ziehungsTage(Date abgabeDatum, boolean isMittwoch,
			boolean isSamstag, int abgabeSchlussMittwoch,
			int abgabeSchlussSamstag, int laufzeit) {
		if (!(isMittwoch || isSamstag)) {
			throw new IllegalArgumentException(
					"Mindestens ein Ziehungstag (Mittwoch oder Samstag) muss angegeben werden");
		}
		if (isMittwoch && isSamstag) {
			laufzeit*=2;
		}
		List<Date> dateList = new ArrayList<>();
		Date date = ersterZiehungsTag(abgabeDatum, isMittwoch, isSamstag,
				abgabeSchlussMittwoch, abgabeSchlussSamstag);
		dateList.add(date);
		while (--laufzeit > 0) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_WEEK, 1);
			date = cal.getTime();
			date = ersterZiehungsTag(date, isMittwoch, isSamstag,
					abgabeSchlussMittwoch, abgabeSchlussSamstag);
			dateList.add(date);
		}
		return dateList;
	}
	
	// von Gerald Fischer:
	
	private static Date ziehungsTag(Date abgabeDatum, int ziehungsTag, int abgabeSchluss) {
		Calendar calAD = Calendar.getInstance();
		calAD.setTime(abgabeDatum);

		Calendar calAD18 = Calendar.getInstance();
		calAD18.set(calAD.get(Calendar.YEAR), calAD.get(Calendar.MONTH), calAD.get(Calendar.DAY_OF_MONTH),
				abgabeSchluss, 0, 0);
		calAD18.set(Calendar.MILLISECOND, 0);

		Calendar calRes = Calendar.getInstance();
		calRes.set(calAD.get(Calendar.YEAR), calAD.get(Calendar.MONTH), calAD.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		calRes.set(Calendar.DAY_OF_WEEK, ziehungsTag);
		
		if (((calAD.get(Calendar.DAY_OF_WEEK) == ziehungsTag) && (calAD.compareTo(calAD18) >= 0))
				|| (calAD.compareTo(calRes) > 0)) {
			calRes.add(Calendar.WEEK_OF_YEAR, 1);
		}
		return calRes.getTime();
	}
}
