package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LottoDatumUtilBBDemo {

	public static void main(String[] args) {

		Calendar cal = new GregorianCalendar(2016, 7, 0, 18, 0, 0);
		int start = 1;
		boolean isMittwoch = true;
		boolean isSamstag = true;
		int aSchlussMi = 18;
		int aSchlussSa = 19;
		int aSchluss = aSchlussMi;
		for (int i = start; i < start + 7; i++) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			SimpleDateFormat df1 = new SimpleDateFormat("EEE dd.MM.yyyy, HH:mm");
			SimpleDateFormat df2 = new SimpleDateFormat("EE dd.MM.yyyy");
			cal.set(Calendar.HOUR_OF_DAY, aSchluss - 1);
			Date zd = LottoDatumUtilBB.ersterZiehungsTag(cal.getTime(), isMittwoch, isSamstag,
					aSchlussMi, aSchlussSa);
			System.out.println(df1.format(cal.getTime()) + " -> "
					+ df2.format(zd));
			cal.set(Calendar.HOUR_OF_DAY, aSchluss);
			zd = LottoDatumUtilBB.ersterZiehungsTag(cal.getTime(), isMittwoch, isSamstag,
					aSchlussMi, aSchlussSa);
			System.out.println(df1.format(cal.getTime()) + " -> "
					+ df2.format(zd));
			cal.set(Calendar.HOUR_OF_DAY, aSchluss + 1);
			zd = LottoDatumUtilBB.ersterZiehungsTag(cal.getTime(), isMittwoch, isSamstag,
					aSchlussMi, aSchlussSa);
			System.out.println(df1.format(cal.getTime()) + " -> "
					+ df2.format(zd));

		}

	}

}
