//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvManager.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import fr.umlv.desperados.database.DatabaseRequestor;

/** 
 * Provides an implementation of the RdvManager interface, using an relational 
 * database.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseRdvManager implements RdvManager {

	/**
	 * The unique instance of DatabaseRdvManager.
	 */
	private static DatabaseRdvManager theInstance = null;
	/**
	 * The DatabaseRequestor of this manager.
	 */
	private DatabaseRequestor requestor;

	/**
	 * Private default constructor.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @roseuid 3FE5EB7D0081
	 */
	private DatabaseRdvManager(DatabaseRequestor requestor) {
		this.requestor = requestor;
	}

	/**
	 * Instance getter.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @return the unique instance of DatabaseRdvManager.
	 * @roseuid 3FF302030359
	 */
	public static synchronized DatabaseRdvManager getInstance(DatabaseRequestor requestor) {
		if (theInstance == null)
			theInstance = new DatabaseRdvManager(requestor);

		return theInstance;
	}

	/**
	 * @param rdv
	 * @roseuid 3FF869CD00E6
	 */
	public void addRdv(Rdv rdv) {
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		java.util.Date date = rdv.getDate();
		String formatedDate = dtf.format(date);
//		String requete="UPDATE TABLE Etudiant SET DATE_DE_RDV=TO_DATE('"+ formatedDate+ "','DD/MM/YY HH24:MI') WHERE ID_ETU="	+ Integer.parseInt(rdv.getStudentId();
		//add the rdv date in the student table
		try {
			requestor.executeQuery(
				"UPDATE Etudiant SET DATE_DE_RDV=TO_DATE('"
					+ formatedDate
					+ "','DD/MM/YY HH24:MI') WHERE ID_ETU="
					+ Integer.parseInt(rdv.getStudentId()));

			//if the student is Ravel : descrease the available rdv
			if (rdv.getRavel())
				requestor.executeQuery(
					"UPDATE Rdv_Dispo SET NB_RAV_DSP=NB_RAV_DSP-1 WHERE DATE_RDV=TO_DATE('"
						+ formatedDate
						+ "','DD/MM/YY HH24:MI') ");

			else
				//if the student is a  not: Ravel descrease the available rdv for the not Ravel

				requestor.executeQuery(
					"UPDATE Rdv_Dispo SET NB_ETU_DSP=NB_ETU_DSP-1 WHERE DATE_RDV=TO_DATE('"
						+ formatedDate
						+ "','DD/MM/YY HH24:MI') ");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param ravel
	 * @return java.util.Date[]
	 * @roseuid 3FF869CD00FB
	 */
	public Date[] getFreeDays(boolean ravel) {
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date[] freeDate = null;
		int i = 0;
		try {
		if (ravel)
		
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV FROM rdv_dispo  WHERE NB_RAV_DSP>0 ORDER BY DATE_RDV");
	
		else
			rs =
				requestor.doQuery(
					"SELECT DATE_RDV FROM rdv_dispo WHERE NB_ETU_DSP>0 ORDER BY DATE_RDV");

		ArrayList listTmp = new ArrayList();

//		rs.first();
//		Date dateTmp = rs.getDate("DATE_RDV");
//		System.out.println("date :"+dateTmp);
//		Date date;
//		listTmp.add(dateTmp);
//		//we use DO WHILE because the cursor is already on the first row
//		while (rs.next()){
//			date = rs.getDate("DATE_RDV");
//			Calendar cal = new GregorianCalendar();
//			Calendar calTmp = new GregorianCalendar();
//	
//			cal.setTime(date);
//			calTmp.setTime(dateTmp);
//			if (cal.get(Calendar.DATE) == calTmp.get(Calendar.DATE)
//				&& cal.get(Calendar.MONTH) == calTmp.get(Calendar.MONTH))
//				listTmp.add(date);
//
//			dateTmp = date;
//
//		} 
//		
//		System.out.println("listTmp :"+listTmp);
//		
//		
//		//freeDate = (java.sql.Date[])listTmp.toArray();
//		
//		int size = listTmp.size();
//		Iterator it = listTmp.iterator();
//		
//		freeDate = new Date[size];
//		for(int cpt = 0; it.hasNext();++cpt ){
//			freeDate[cpt] = (java.util.Date)it.next();
//			System.out.println("jour :"+freeDate[cpt].getDate());
//		}
		rs.last();
		freeDate =new Date[rs.getRow()];
		rs.first();
		
		do{
	
		//	Date date = new Date;
			Calendar cal = new GregorianCalendar();
		
			long longDate=(rs.getTimestamp("DATE_RDV")).getTime();
			Date date=new Date(longDate);
			freeDate[i]=date;
			System.out.println("date :"+freeDate[i]);
			cal.setTime(date);
			
			i++;			
		}
		while( rs.next() );
			
		
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return freeDate;

	}

	/**
	 * @param day
	 * @param ravel
	 * @return java.util.Date[]
	 * @roseuid 3FF869CD0119
	 */
	public Date[] getFreeHours(java.util.Date day, boolean ravel) {
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		String formatedDate = dtf.format(day);
		Date[] freeHours = null;
		int i = 0;
		try {
			if (ravel)
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV FROM rdv_dispo WHERE TO_DATE(DATE_RDV,'DD/MM/YY')="
							+ formatedDate
							+ "  AND NB_RAV_DSP>0");

			else
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV FROM rdv_dispo WHERE TO_DATE(DATE_RDV,'DD/MM/YY')="
							+ formatedDate
							+ " AND NB_ETU_DSP>0");
			rs.last();
			freeHours = new Date[rs.getRow()];
			rs.first();

			//we use DO WHILE because the cursor is already on the first row
			do {

				freeHours[i] = rs.getDate("DATE_RDV");

				i++;
			} while (rs.next());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return freeHours;
	}

	/**
	 * @param studentId
	 * @return fr.umlv.desperados.planning.Rdv
	 * @roseuid 3FF869CD0141
	 */
	public Rdv getRdv(int studentId) {
		ResultSet rs = null;
		Rdv rdv =null;
		try {
			rs =
				requestor.doQuery(
					"SELECT DATE_DE_RDV, NOM_PATRONYMIQUE, PRENOM1,ANNEE_BAC FROM Etudiant WHERE ID_ETU="
						+ studentId);
	
		rs.next();
		boolean isRavel = false;
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(System.currentTimeMillis());
		
		int currentYear = rs.getInt("ANNEE_BAC");
		if (currentYear == cal.get(Calendar.YEAR))
			isRavel = true;
			
		long longDate=(rs.getTimestamp("DATE_DE_RDV")).getTime();
	    Date date=new Date(longDate);
	    
		rdv =
			new Rdv(
				date,
				String.valueOf(studentId),
				rs.getString("NOM_PATRONYMIQUE"),
				rs.getString("PRENOM1"),
				isRavel);
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return rdv;
	}

	/**
	 * @param date
	 * @param ravel
	 * @return boolean
	 * @roseuid 3FF869CD015F
	 */
	public boolean isDateFree(java.util.Date date, boolean ravel)	 {

		boolean isFree = false;
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		String formatedDate = dtf.format(date);
		try {
		if (ravel) {
			
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV from Rdv_Dispo WHERE DATE_RDV=TO_DATE('"
							+ formatedDate
							+ "','DD/MM/YY HH24:MI') AND NB_RAV_DSP>0");
		
			if (rs.next())
				isFree = true;
		} else {
			rs =
				requestor.doQuery(
					"SELECT DATE_RDV from Rdv_Dispo WHERE DATE_RDV=TO_DATE('"
						+ formatedDate
						+ "','DD/MM/YY HH24:MI') AND NB_ETU_DSP>0");
			if (rs.next())
				isFree = true;
		}
		} catch (SQLException e) {
					// TODO Bloc catch auto-généré
					e.printStackTrace();
				}
		return isFree;
	}

	/**
	 * @param day
	 * @return java.util.List
	 * @roseuid 3FF869CD0191
	 */
	public List listRdv(java.util.Date day) {
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		String formatedDate = dtf.format(day);
		Rdv[] rdvList = null;
		try {
			rs =
				requestor.doQuery(
					"SELECT RDV_DATE, NOM_PATRONYMIQUE, PRENOM1,ANNEE_BAC,ETU_ID FROM Etudiant WHERE TO_DATE(DATE_DE_RDV,'DD/MM/YY')="
						+ formatedDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null)
			return (List) (new DatabaseRdvList(rs));

		return (List) (new ArrayList());

	}

	/**
	 * @param rdv
	 * @roseuid 3FF869CD01AF
	 */
	public void removeRdv(Rdv rdv) {
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		java.util.Date date = rdv.getDate();
		String formatedDate = dtf.format(date);
		try {
			requestor.executeQuery(
				"UPDATE Etudiant SET DATE_DE_RDV=NULL WHERE ID_ETU="
					+ Integer.parseInt(rdv.getStudentId()));
	

		if (rdv.getRavel())
			requestor.executeQuery(
				"UPDATE Rdv_Dispo SET NB_RAV_DSP=NB_RAV_DSP+1 WHERE DATE_RDV=TO_DATE('"
					+ formatedDate
					+ "','DD/MM/YY HH24:MI') ");
		else
			requestor.executeQuery(
				"UPDATE Rdv_Dispo SET NB_ETU_DSP=NB_ETU_DSP+1 WHERE DATE_RDV=TO_DATE('"
					+ formatedDate
					+ "','DD/MM/YY HH24:MI') ");
		} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/* (non-Javadoc)
	 * @see fr.umlv.desperados.planning.RdvManager#confRdv(java.util.Date, int, int)
	 */
	public void confRdv(Date date, int nbRavMax, int nbEtuMax) { 
		DateFormat dtf =
				DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
				String formatedDate = dtf.format(date);
		try {
			requestor.executeQuery("INSERT INTO Rdv_Dispo VALUES(TO_DATE('"+formatedDate+"','DD/MM/YY HH24:MI'),"+nbRavMax+","+nbEtuMax+","+nbRavMax+","+nbEtuMax+")");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.desperados.planning.RdvManager#giveRdVNumber(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String giveRdVNumber(String dateStart, String dateEnd, String diplomaId) {
		ResultSet rs = null;
		String reqSql = "";
		String numberOfRdV = "";
		
		// Add the year to the date : DD/MM/YYYY
		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		dateStart = dateStart + "/" + year;
		dateEnd = dateEnd + "/" + year + " 23:59:59";
		
		if(diplomaId == "")
			reqSql = "SELECT COUNT(ID_ETU) FROM ETUDIANT WHERE "
				+ "DATE_DE_RDV >= to_date('"+dateStart+"', 'DD/MM/YYYY') "
				+ "and DATE_DE_RDV <= to_date('"+dateEnd+"', 'DD/MM/YYYY HH24:MI:SS')";
		else 
			reqSql = "SELECT COUNT(ID_ETU) FROM ETUDIANT WHERE "
		+ "DATE_DE_RDV >= to_date('"+dateStart+"', 'DD/MM/YYYY') "
		+ "and DATE_DE_RDV <= to_date('"+dateEnd+"', 'DD/MM/YYYY HH24:MI:SS') "
				+ "and (ID_DIP_MLV = "+diplomaId+")";
		
		try {
			rs = requestor.doQuery(reqSql);
				
			rs.first(); 
			numberOfRdV = rs.getString(1);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numberOfRdV;
	}
}