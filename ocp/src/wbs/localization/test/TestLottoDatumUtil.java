package wbs.localization.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wbs.localization.LottoDatumUtilBB;

public class TestLottoDatumUtil {

	//Calendar cal = new GregorianCalendar(2016, 7, 10, 18, 0, 0);
	Calendar cal = Calendar.getInstance();
	Calendar calNachTest = Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("EEE dd.MM.yyy HH.mm");

	// Abgabe:
	int abgabeTag;
	int abgabeMonat;
	int abgabeJahr;
	int abgabeZeit;

	boolean isMittwoch = true;
	boolean isSamstag = true;
	int abgabeSchlussMittwoch = 18;
	int abgabeSchlussSamstag = 18;
	int laufzeit = 3;

	Date abgabeDatum;

	@Before
	public void setUp() throws Exception {
		cal = new GregorianCalendar(2016, 7, 10, 18, 0, 0);

		// Abgabe:
		abgabeTag = 10;
		abgabeMonat = 7;
		abgabeJahr = 2016;
		abgabeZeit = 18;

		isMittwoch = true;
		isSamstag = true;
		abgabeSchlussMittwoch = 18;
		abgabeSchlussSamstag = 18;
		laufzeit = 3;

		cal.set(Calendar.YEAR, abgabeJahr);
		cal.set(Calendar.MONTH, abgabeMonat);
		cal.set(Calendar.DAY_OF_MONTH, abgabeTag);
		cal.set(Calendar.HOUR_OF_DAY, abgabeZeit);

	}

	private void methodeAufrufen() {
		abgabeDatum = cal.getTime();
		System.out.println("AbgabeDatum: " +sdf.format(abgabeDatum));
		Date ersterZiehungsTag = LottoDatumUtilBB.ersterZiehungsTag(
				abgabeDatum, isMittwoch, isSamstag, abgabeSchlussMittwoch,
				abgabeSchlussSamstag);
		calNachTest.setTime(ersterZiehungsTag);
		System.out.println(sdf.format(ersterZiehungsTag));
	}

	@Test
	public void testErsterZiehungsTag_Abgabe_Sa_vor_Schluss_Spielt_Sa_Und_Mi() {
		cal.getTime();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.getTime();
		cal.set(Calendar.HOUR_OF_DAY, abgabeSchlussSamstag-1);
		methodeAufrufen();
		assertEquals(calNachTest.get(Calendar.DAY_OF_WEEK), Calendar.SATURDAY);
	}

	@Test
	public void testErsterZiehungsTag_Abgabe_Sa_am_Schluss_Spielt_Sa_Und_Mi() {
		cal.getTime();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.getTime();
		cal.set(Calendar.HOUR_OF_DAY, abgabeSchlussSamstag);
		methodeAufrufen();
		assertEquals(calNachTest.get(Calendar.DAY_OF_WEEK), Calendar.WEDNESDAY);
	}
	@Test
	public void testErsterZiehungsTag_Abgabe_Sa_nach_Schluss_Spielt_Sa_Und_Mi() {
		cal.getTime();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.getTime();
		cal.set(Calendar.HOUR_OF_DAY, abgabeSchlussSamstag+1);
		methodeAufrufen();
		assertEquals(calNachTest.get(Calendar.DAY_OF_WEEK), Calendar.WEDNESDAY);
	}

	@Test
	public void testErsterZiehungsTag_Abgabe_Sa_am_Schluss_Spielt_Sa() {
		cal.getTime();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.getTime();
		cal.set(Calendar.HOUR_OF_DAY, abgabeSchlussSamstag);
		isMittwoch = false;
		isSamstag = true;
		
		methodeAufrufen();
		assertEquals(calNachTest.get(Calendar.DAY_OF_WEEK), Calendar.SATURDAY);
	}
}
