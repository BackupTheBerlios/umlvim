package fr.umlv.desperados.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import fr.umlv.desperados.database.DatabaseRequestor;

/**
 * Provides an implementation of the StudentManager interface, using an relational 
 * database.
 * It contains a cache system, which prevents to instanciate Student several times.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseInformationListManager {

	public final static String PREVIOUS_YEAR_SITUATION = "precYearSitType";
	public final static String WORKED_SHARED = "workedShare";
	public final static String FINANCIAL_AID = "financialAssistance";
	public final static String SOCIAL_ECONOMIC_CATEGORY = "socialEconomicCategory";
	public final static String MLV_DIPLOMA = "MLVDiploma";
	public final static String FAMILIAL_SITUATION = "famSituation";
	public final static String BAC_PRE_95 = "bacPre95";
	public final static String BAC_POST_95 = "baccalaureat";
	public final static String HANDICAP = "handicap";
	public final static String LODGING_TYPE = "lodgingType";
	public final static String INSCRIPTION_MODE = "inscriptionMode";	
	public final static String INSCRIPTION_TYPE = "inscriptionType";
	public final static String PAYMENT_CENTER = "centerPayment";
	public final static String INTERNATIONAL_EXCHANGE_TYPE = "internationalExchangeType";
	public final static String MUTUAL_COMPANY = "mutualInsuranceCompany";	
	public final static String SOCIAL_SECURITY_AFF = "socialSecurityAff";
	public final static String SOCIAL_SECURITY_NON_AFF = "socialSecurityNonAff";
	public final static String LAST_DIPLOMA_TYPE = "lastDiplomaType";
	public final static String BAC_MENTION = "bacMention";
	public final static String BAC_ESTABLISHMENT_TYPE = "baccalaureatEstablishmentType";
	public final static String LAST_ESTAB_TYPE = "establishment_type";
	public final static String COMP_ESTAB_TYPE = "compEstablishment_type";
	public final static String MILITARY_SITUATION = "militarySituation";
	public final static String PAYMENT_MODE = "paymentMode";
	public final static String PURSE = "purse";
	public final static String FRENCH_CITY = "frenchCity";
	public final static String FRENCH_ZIP = "frenchZip";
	public final static String FRENCH_DEP = "frenchDep";
	public final static String FOREIGN_COUNTRY = "foreignCountry";

	private HashMap allTheMap;

	/**
	 * The unique instance of the DatabaseUserManager.
	 */
	private static DatabaseInformationListManager theInstance = null;

	/**
	 * The DatabaseRequestor of this manager.
	 */
	private DatabaseRequestor requestor;

	private Properties prop;

	/**
	 * Private default constructor.
	 * 
	 * @param requestor the DatabaseRequestor of this manager.
	 * @roseuid 3FE3136B035E
	 */
	private DatabaseInformationListManager(DatabaseRequestor requestor, String propertiesPath) {
		allTheMap = new HashMap();
		this.requestor = requestor;
		prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesPath));
		} catch (FileNotFoundException e) {
			//TODO catch auto-g�n�r�
			e.printStackTrace();
		} catch (IOException e) {
			//TODO catch auto-g�n�r�
			e.printStackTrace();
		}
	}

	/**
	 * Instance getter.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @return the unique instance of DatabaseStudentManager.
	 * @roseuid 3FF851EE0284
	 */
	public static synchronized DatabaseInformationListManager getInstance(
				DatabaseRequestor requestor,
				String propertiesPath)
	{
		if (theInstance == null)
			theInstance = new DatabaseInformationListManager(requestor, propertiesPath);
		return theInstance;
	}

	/**
	 * @param INE
	 * @param name
	 * @param firstname
	 * @param diplomaId
	 * @return java.util.List
	 * @roseuid 3FF869BD0210
	 */
	public HashMap list(String resource) {
		HashMap map = (HashMap)allTheMap.get(resource);
		if(map == null) {
			String table = "table";
			String id = "id";
			String libel = "libel";
			String condition = null;
			if(BAC_PRE_95.equals(resource)) {
				resource = BAC_POST_95;
				condition = prop.get(resource+".post95") + " = 0";
			} 
			else if(BAC_POST_95.equals(resource)) {
				condition = prop.get(resource+".post95") + " = 1";
			}
			else if(SOCIAL_SECURITY_AFF.equals(resource)) {
				condition = prop.get(resource+".nonAff") + " = 0";
			}
			else if(SOCIAL_SECURITY_NON_AFF.equals(resource)) {
				resource = SOCIAL_SECURITY_AFF;
				condition = prop.get(resource+".nonAff") + " = 1";
			}
			else if(FRENCH_DEP.equals(resource)) {
				condition = prop.get(resource+".nationality")
								+ " = '" + prop.get(resource+".nationality.french") + "'";
			}
			else if(FOREIGN_COUNTRY.equals(resource)) {
				resource = FRENCH_DEP;
				condition = "NOT " + prop.get(resource+".nationality")
								+ " = '" + prop.get(resource+".nationality.french") + "'";
			}
			else if(LAST_ESTAB_TYPE.equals(resource)) {
				condition = prop.get(resource+".last")	+ " = 1";
			}
			else if(COMP_ESTAB_TYPE.equals(resource)) {
				resource = LAST_ESTAB_TYPE;
				condition = prop.get(resource+".comp") + " = 1";
			}
			else if(FRENCH_ZIP.equals(resource)) {
				resource = "frenchCity";
				libel = "zip";
			}

			table = (String)prop.get(resource+"."+table);
			id = (String)prop.get(resource+"."+id);
			libel = (String)prop.get(resource+"."+libel);
			map = getListFromDatabase(table, id, libel, condition);
		}
		return new HashMap(map);
	}

	public void reset() {
		Collection col = allTheMap.values();
		for(Iterator it = col.iterator() ; it.hasNext() ;) {
			HashMap map = (HashMap)it.next();
			map.clear();
		}
	}

	private HashMap getListFromDatabase(String table, String id, String libel, String condition) {
			HashMap map = new HashMap();
			String where = null;

			StringBuffer query = new StringBuffer();
			query.append("SELECT ").append(id).append(", ")
						.append(libel).append(" FROM ").append(table);
			if(condition != null) {
				query.append(" WHERE "+condition);
			}

			System.out.println("query : "+query);

			try {
				ResultSet rs=requestor.doQuery(query.toString());
				while(rs.next()) {
					map.put(rs.getString(1),		// the 'id' field
									rs.getString(2));	// the 'libel' field
				}
			} catch (SQLException e) {
				//TODO catch auto-g�n�r�
				e.printStackTrace();
			}
		return map;
	}
}