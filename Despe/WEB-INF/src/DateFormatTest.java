import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

/*
 * Created on 21 janv. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author ncuvelie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DateFormatTest {

	public static void main(String[] args) {
		Locale locale =Locale.FRANCE;
		DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		DateFormat dfMedium = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		DateFormat dfLong = DateFormat.getDateInstance(DateFormat.LONG, locale);
		DateFormat dfFull = DateFormat.getDateInstance(DateFormat.FULL, locale);

		String date = "1 janvier 1970";
		try {
			System.out.println("SHORT: "+dfShort.parse(date));
		} catch (ParseException e) {
			System.out.println("SHORT failled");
		}
		try {
			System.out.println("MEDIUM: "+dfMedium.parse(date));
		} catch (ParseException e1) {
			System.out.println("MEDIUM failled");
		}
		try {
			System.out.println("LONG: "+dfLong.parse(date));
		} catch (ParseException e2) {
			System.out.println("LONG failled");
		}
		try {
			System.out.println("FULL: "+dfFull.parse(date));
		} catch (ParseException e3) {
			System.out.println("FULL failled");
		}
	}
}
