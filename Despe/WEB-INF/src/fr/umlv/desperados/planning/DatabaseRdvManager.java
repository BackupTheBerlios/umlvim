//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\G�NIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvManager.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

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
	public boolean addRdv(Rdv rdv) {
		boolean res = true;
		DateFormat dtf =
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		java.util.Date date = rdv.getDate();
		String formatedDate = dtf.format(date);
		String reqSql;
		ResultSet rs = null;
		int nbRdvDispo;
//		String requete="UPDATE TABLE Etudiant SET DATE_DE_RDV=TO_DATE('"+ formatedDate+ "','DD/MM/YY HH24:MI') WHERE ID_ETU="	+ Integer.parseInt(rdv.getStudentId();
		//add the rdv date in the student table
		try {
			// if the student is Ravel : descrease the available rdv
			if (rdv.getRavel()) {
				reqSql = "select DATE_RDV, NB_RAV_DSP from RDV_DISPO where DATE_RDV=to_date('"
					+ formatedDate
					+ "','DD/MM/YY HH24:MI')"; // for update of NB_RAV_DSP"; //Ne marche pas � cause du driver Oracle
				rs = requestor.doQuery(reqSql);
				
				rs.first();
				nbRdvDispo = rs.getInt(2);
				
				// if the place is always free, we allot it to the student
				if(nbRdvDispo > 0) {	
					requestor.executeQuery(
						"UPDATE Rdv_Dispo SET NB_RAV_DSP=NB_RAV_DSP-1 WHERE DATE_RDV=TO_DATE('"
							+ formatedDate
							+ "','DD/MM/YY HH24:MI') ");
					
					requestor.executeQuery(
						"UPDATE Etudiant SET DATE_DE_RDV=TO_DATE('"
							+ formatedDate
							+ "','DD/MM/YY HH24:MI') WHERE ID_ETU="
							+ Integer.parseInt(rdv.getStudentId()));
				}
				else
					res = false;
			}

			// if the student is a not Ravel, descrease the available rdv for the not Ravel
			else {
				reqSql = "select DATE_RDV, NB_ETU_DSP from RDV_DISPO where DATE_RDV=to_date('"
					+ formatedDate
					+ "','DD/MM/YY HH24:MI')"; // for update of NB_ETU_DSP"; //Ne marche pas � cause du driver Oracle
				rs = requestor.doQuery(reqSql);
				
				rs.first();
				nbRdvDispo = rs.getInt(2);
				
				// if the place is always free, we allot it to the student
				if(nbRdvDispo > 0) {	
					requestor.executeQuery(
						"UPDATE Rdv_Dispo SET NB_ETU_DSP=NB_ETU_DSP-1 WHERE DATE_RDV=TO_DATE('"
							+ formatedDate
							+ "','DD/MM/YY HH24:MI') ");
				
					requestor.executeQuery(
						"UPDATE Etudiant SET DATE_DE_RDV=TO_DATE('"
							+ formatedDate
							+ "','DD/MM/YY HH24:MI') WHERE ID_ETU="
							+ Integer.parseInt(rdv.getStudentId()));
				}
				else
					res = false;
			}
			
			requestor.executeQuery("commit");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	/**
	 * @param ravel
	 * @return java.util.Date[]
	 * @roseuid 3FF869CD00FB
	 */
	public String[] getFreeDays(boolean ravel) {
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateInstance(DateFormat.SHORT);
		String[] freeDate = null;
		int i = 0;
	
		try {
		if (ravel)
			
					rs =
						requestor.doQuery(
							"SELECT date_rdv FROM rdv_dispo  WHERE NB_RAV_DSP>0 order by date_rdv");
		
	
		else
			rs =
				requestor.doQuery(
					"SELECT date_rdv from rdv_dispo WHERE NB_ETU_DSP>0 order by date_rdv");

		ArrayList listTmp = new ArrayList();

		rs.first();
		Date dateTmp = rs.getDate("DATE_RDV");
	
		Date date;
		listTmp.add(dateTmp);
	
		while (rs.next()){
			date = rs.getDate("DATE_RDV");
			Calendar cal = new GregorianCalendar();
			Calendar calTmp = new GregorianCalendar();
	
			cal.setTime(date);
			calTmp.setTime(dateTmp);
			if (cal.get(Calendar.DATE) != calTmp.get(Calendar.DATE)
				|| cal.get(Calendar.MONTH) != calTmp.get(Calendar.MONTH))
				listTmp.add(date);

			dateTmp = date;
	

		} 

		int size = listTmp.size();
		Iterator it = listTmp.iterator();
		
		freeDate = new String[size];
		for(int cpt = 0; it.hasNext();++cpt ){
			freeDate[cpt] = dtf.format((java.util.Date)it.next());
			}
			
		} catch (SQLException e) {
					// TODO Bloc catch auto-g�n�r�
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
	public String[] getFreeHours(java.util.Date day, boolean ravel) {
		ResultSet rs = null;
		DateFormat dtf =
			DateFormat.getDateInstance(DateFormat.SHORT);
		String formatedDate = dtf.format(day);
		
		DateFormat dtfHour =
				DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT, Locale.FRANCE);
	
		String[] freeHours = null;
		int i = 0;
		try {
			if (ravel)
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV FROM rdv_dispo WHERE TO_DATE(DATE_RDV,'DD/MM/YY')='"
							+ formatedDate
							+ "'  AND NB_RAV_DSP>0 ORDER BY DATE_RDV");

			else
				rs =
					requestor.doQuery(
						"SELECT DATE_RDV FROM rdv_dispo WHERE TO_DATE(DATE_RDV,'DD/MM/YY')='"
							+ formatedDate
							+ "' AND NB_ETU_DSP>0 ORDER BY DATE_RDV");
			rs.last();
			freeHours = new String[rs.getRow()];
			rs.first();

			//we use DO WHILE because the cursor is already on the first row
			do {
				freeHours[i] = dtfHour.format(rs.getTimestamp("DATE_RDV"));

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
						+ studentId+"  AND DATE_DE_RDV IS NOT NULL ");
						
		if(rs.next())
		{
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
		
			return rdv;
		}
		} catch (SQLException e) {
						e.printStackTrace();
		}
		return null;
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
					// TODO Bloc catch auto-g�n�r�
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
			DateFormat.getDateInstance(DateFormat.SHORT);
		String formatedDate = dtf.format(day);
		Rdv[] rdvList = null;
		try {
			rs =
				requestor.doQuery(
					"SELECT DATE_DE_RDV, NOM_PATRONYMIQUE, PRENOM1, ANNEE_BAC, ID_ETU FROM Etudiant WHERE TO_DATE(DATE_DE_RDV,'DD/MM/YY')='"
						+ formatedDate
						+ "' ORDER BY DATE_DE_RDV");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null)
			return (List) (new DatabaseRdvList(rs));
		return null;
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
		
		// For search on every day of the period
		dateEnd += " 23:59:59";
		
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
	
	public boolean isConfigure(Date date)
	{
		boolean isConfigure=false; 
		DateFormat dtf =
				DateFormat.getDateInstance(DateFormat.SHORT);
		String formatedDate = dtf.format(date);
	
		String rq="SELECT * from rdv_dispo where TO_CHAR(DATE_RDV,'DD/MM/YY')='"+formatedDate+"'";
		ResultSet rs = null;
		try {
			rs=requestor.doQuery(rq);
		} catch (SQLException e) {
			// TODO Bloc catch auto-g�n�r�
			e.printStackTrace();
		}
		try {
			isConfigure = rs.next();
		} catch (SQLException e1) {
			// TODO Bloc catch auto-g�n�r�
			e1.printStackTrace();
		}
	return isConfigure;
	}
	
	public void removeConf(Date date)
	{
		DateFormat dtf =DateFormat.getDateInstance(DateFormat.SHORT);
		String formatedDate = dtf.format(date);
		String rq="DELETE FROM rdv_dispo where TO_CHAR(DATE_RDV,'DD/MM/YY')='"+formatedDate+"'";
		try {
			requestor.executeQuery(rq);
		} catch (SQLException e) {
			// TODO Bloc catch auto-g�n�r�
			e.printStackTrace();
		}
	}
	
}