//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvList.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import fr.umlv.desperados.database.DatabaseAbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Rdv.
 */
final class DatabaseRdvList extends DatabaseAbstractList {

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a Rdv list.
	 * @roseuid 3FE5EA5B0156
	 */
	DatabaseRdvList(ResultSet rs) {
		super(rs);
	}

	/**
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869CC017B
	 */
	public Object get(int i) {
		Rdv rdv = null;
		synchronized (rs) {
			try {
				rs.absolute(i);

				String id = String.valueOf(rs.getString("ID_ETU"));
				String name = rs.getString("NOM_PATRONYMIQUE");
				String firstName = rs.getString("PRENOM1");

				java.util.Date dateBac = rs.getDate("ANNEE_BAC");
				Calendar calBac = new GregorianCalendar();
				calBac.setTime(dateBac);

				java.util.Date dateRdv = rs.getDate("DATE_DE_RDV");
				Calendar calRdv = new GregorianCalendar();
				calRdv.setTime(dateRdv);

				boolean isRavel = (calBac.get(Calendar.YEAR) == calRdv.get(Calendar.YEAR));

				rdv = new Rdv(dateRdv, id, name, firstName, isRavel);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rdv;
	}

	/**
	 * @return int
	 * @roseuid 3FF869CC018F
	 */
	/* (non-Javadoc)
	* @see fr.umlv.desperados.database.DatabaseAbstractList#iterator()
	*/
	public Iterator iterator() {
		return new DatabaseRdvListIterator(rs);
	}

	public ListIterator listIterator(int index) {
		return new DatabaseRdvListIterator(rs, index);
	}

	/* (non-Javadoc)
	 * @see fr.umlv.desperados.util.XMLable#toXML()
	 */
	public String toXML() {
		String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		s += "<agenda><day>";
		DateFormat datef = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRENCH);
		String sDate = datef.format(new Date());
		s += "<date>" + sDate.substring(0,8) + "</date>";
		s += "<rdv><beginHour></beginHour><studentsName>";
		for(Iterator it = iterator(); it.hasNext();) {
			Rdv rdv = (Rdv)it.next();
			datef = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRENCH);
			String date = datef.format(rdv.getDate());
			System.out.println("Heure de rdv "+date);
			//s += "<beginHour>"+ date.substring(8,14) +"</beginHour>";
			if(date.equals(sDate)) {
				s += rdv.getName() + " " +rdv.getFirstname() + " - ";
				sDate = date;
			}
		
			else {
				s += "</studentsName></rdv>";
				s += "<rdv><beginHour>"+date+"</beginHour>";
				s += "<studentsName>"+rdv.getName() +" "+rdv.getFirstname() + " - ";
			}			
		}
		s += "</studentsName></rdv></day></agenda>";
		return s;
	}
}