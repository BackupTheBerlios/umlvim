//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\form\\PlanningConfForm.java

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PlanningConfForm extends ActionForm {

	private String beginAM;
	private String beginPM;
	private String endAM;
	private String endPM;
	private String nbCorrectorAM;
	private String nbCorrectorPM;
	private String nbRavelAM;
	private String nbRavelPM;
	private String rdvDurationAM;
	private String rdvDurationPM;
	private String toDate;
	private String fromDate;

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if ((beginAM == null) || (beginAM).equals("")) {
			errors.add("beginAM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d{1,2}:\\d\\d";
			if (!beginAM.matches(formatRegexp)) {
				errors.add(
					"beginAM",
					new ActionError("error.hour.format", "hh:mm"));
			}
		}
		if ((beginPM == null) || (beginPM).equals("")) {
			errors.add("beginPM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d{1,2}:\\d\\d";
			if (!beginPM.matches(formatRegexp)) {
				errors.add(
					"beginPM",
					new ActionError("error.hour.format", "hh:mm"));
			}
		}
		if ((endAM == null) || (endAM).equals("")) {
			errors.add("endAM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d{1,2}:\\d\\d";
			if (!endAM.matches(formatRegexp)) {
				errors.add(
					"endAM",
					new ActionError("error.hour.format", "hh:mm"));
			}
		}
		if ((endPM == null) || (endPM).equals("")) {
			errors.add("endPM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d{1,2}:\\d\\d";
			if (!endPM.matches(formatRegexp)) {
				errors.add(
					"endPM",
					new ActionError("error.hour.format", "hh:mm"));
			}
		}
		if ((nbCorrectorAM == null) || (nbCorrectorAM).equals("")) {
			errors.add("nbCorrectorAM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!nbCorrectorAM.matches(formatRegexp)) {
				errors.add(
					"nbCorrectorAM",
					new ActionError("error.number.format", "xx"));
			}
		}
		if ((nbCorrectorPM == null) || (nbCorrectorPM).equals("")) {
			errors.add("nbCorrectorPM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!nbCorrectorPM.matches(formatRegexp)) {
				errors.add(
					"nbCorrectorPM",
					new ActionError("error.number.format", "xx"));
			}
		}
		if ((nbRavelAM == null) || (nbRavelAM).equals("")) {
			errors.add("nbRavelAM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!nbRavelAM.matches(formatRegexp)) {
				errors.add(
					"nbRavelAM",
					new ActionError("error.number.format", "xx"));
			}
		}
		if ((nbRavelPM == null) || (nbRavelPM).equals("")) {
			errors.add("nbRavelPM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!nbRavelPM.matches(formatRegexp)) {
				errors.add(
					"nbRavelPM",
					new ActionError("error.number.format", "xx"));
			}
		}
		if ((rdvDurationAM == null) || (rdvDurationAM).equals("")) {
			errors.add("rdvDurationAM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!rdvDurationAM.matches(formatRegexp)) {
				errors.add(
					"rdvDurationAM",
					new ActionError("error.number.format", "xx"));
			}
		}

		if ((rdvDurationPM == null) || (rdvDurationPM).equals("")) {
			errors.add("rdvDurationPM", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d+";
			if (!rdvDurationPM.matches(formatRegexp)) {
				errors.add(
					"rdvDurationPM",
					new ActionError("error.number.format", "xx"));
			}
		}
		if ((fromDate == null) || (fromDate).equals("")) {
			errors.add("fromDate", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
			if (!fromDate.matches(formatRegexp)) {
				errors.add(
					"fromDate",
					new ActionError("error.date.format", "jj/mm/aaaa"));
			}
		}
		if ((toDate == null) || (toDate).equals("")) {
			errors.add("toDate", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
			if (!toDate.matches(formatRegexp)) {
				errors.add(
					"toDate",
					new ActionError("error.date.format", "jj/mm/aaaa"));
			}
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		beginAM = "";
		beginPM = "";
		endAM = "";
		endPM = "";
		nbCorrectorAM = "";
		nbCorrectorPM = "";
		nbRavelAM = "";
		nbRavelPM = "";
		rdvDurationAM = "";
		rdvDurationPM = "";
		toDate = "";
		fromDate = "";

	}

	/**
	 * @return
	 */
	public String getBeginAM() {
		return beginAM;
	}

	/**
	 * @return
	 */
	public String getBeginPM() {
		return beginPM;
	}

	/**
	 * @return
	 */
	public String getEndAM() {
		return endAM;
	}

	/**
	 * @return
	 */
	public String getEndPM() {
		return endPM;
	}

	/**
	 * @return
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @return
	 */
	public String getNbCorrectorAM() {
		return nbCorrectorAM;
	}

	/**
	 * @return
	 */
	public String getNbCorrectorPM() {
		return nbCorrectorPM;
	}

	/**
	 * @return
	 */
	public String getNbRavelAM() {
		return nbRavelAM;
	}

	/**
	 * @return
	 */
	public String getNbRavelPM() {
		return nbRavelPM;
	}

	/**
	 * @return
	 */
	public String getRdvDurationAM() {
		return rdvDurationAM;
	}

	/**
	 * @return
	 */
	public String getRdvDurationPM() {
		return rdvDurationPM;
	}

	/**
	 * @return
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param string
	 */
	public void setBeginAM(String string) {
		beginAM = string;
	}

	/**
	 * @param string
	 */
	public void setBeginPM(String string) {
		beginPM = string;
	}

	/**
	 * @param string
	 */
	public void setEndAM(String string) {
		endAM = string;
	}

	/**
	 * @param string
	 */
	public void setEndPM(String string) {
		endPM = string;
	}

	/**
	 * @param string
	 */
	public void setFromDate(String string) {
		fromDate = string;
	}

	/**
	 * @param string
	 */
	public void setNbCorrectorAM(String string) {
		nbCorrectorAM = string;
	}

	/**
	 * @param string
	 */
	public void setNbCorrectorPM(String string) {
		nbCorrectorPM = string;
	}

	/**
	 * @param string
	 */
	public void setNbRavelAM(String string) {
		nbRavelAM = string;
	}

	/**
	 * @param string
	 */
	public void setNbRavelPM(String string) {
		nbRavelPM = string;
	}

	/**
	 * @param string
	 */
	public void setRdvDurationAM(String string) {
		rdvDurationAM = string;
	}

	/**
	 * @param string
	 */
	public void setRdvDurationPM(String string) {
		rdvDurationPM = string;
	}

	/**
	 * @param string
	 */
	public void setToDate(String string) {
		toDate = string;
	}

}