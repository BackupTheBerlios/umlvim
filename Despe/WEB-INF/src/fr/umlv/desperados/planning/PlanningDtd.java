//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\PlanningDtd.java

package fr.umlv.desperados.planning;

/**
 * Dtd balise description classe, usefull if dtd balise name or paramerters nmaes change
 * @author Julien Decreton
 * @version 1.0
 */
public class PlanningDtd {

	/** root balise */
	static final String PLANNING = "planning";

	/** Month balise name */
	static final String MONTH = "month";
	/** Day balise name */
	static final String DAY = "day";
	/** Day and month balise parameter */
	static final String NUMBER = "number";

	/** Mormning balise name */
	static final String MORNING = "morning";
	/** Afternoon balise name */
	static final String AFTERNOON = "afternoon";
	/** Morning and afternoon balise parameter */
	static final String CORRECTORNUMBER = "correctorNumber";
	/** Morning and afternoon balise parameter */
	static final String MEETINGDURATION = "meetingDuration";
	/** Morning and afternoon balise parameter */
	static final String RAVELNUMBER = "ravelNumber";

	/** EndHour balise parameter */
	static final String ENDHOUR = "endHour";
	/** beginingHour balise parameter */
	static final String BEGININGHOUR = "beginingHour";
	/**Hour balise name	 */
	static final String HOUR = "Hour";
	/** Hour balise parameter */
	static final String HOURPARAMHOUR = "hour";
	/** Hour balise parameter */
	static final String HOURPARAMMIN = "min";

	/** the pah of the dtd */

	// TODO aaa changer si on change de compte
	static String dtdPath = "http://etudiant.univ-mlv.fr/~ncuvelie/planningConf.dtd";

	/**
	 * @param path the dtd's path
	 * @roseuid 3FFBF0A3030D
	 */
	public void setDtdPath(String path) {
		dtdPath = path;
	}

	/**
	 * @return the dtd path of a planning
	 */
	public static String getDtdPath() {
		return dtdPath;
	}

}
