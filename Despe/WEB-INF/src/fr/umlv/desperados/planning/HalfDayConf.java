//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\HalfDayConf.java

package fr.umlv.desperados.planning;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.w3c.dom.Element;

/**
 * Contains configuration informations (such as  opening hours, number of 
 * correctors, duration of a renddez-vous...) for an half day (i.e. morning or 
 * afternoon).
 * 
 * @author Julien Decreton
 * @version 1.0
 */
public class HalfDayConf implements NodeConverter {

	/**
	 * the beginning hour of a halfday
	 */
	private Calendar begin;

	/**
	 * the end hour of a halfday
	 */
	private Calendar end;

	/**
	 * the duration of a rendez-vous in minute
	 */
	private int rdvDuration;

	/**
	 * the number of the corrector during the halfDay
	 */
	private int nbCorrector;

	/**
	 * the number of ravel allowed during this half day
	 */
	private int nbRavel;

	/**
	 * to know if the half day is the morning of the afternoon. it is useful to 
	 * generate the good tree in toDomNode
	 */
	private boolean isMorning;

	/**
	 * dom tree contening the data of an halfDay
	 */
	private Element domHalfDay;

	/**
	 * constructor by init with a dom tree to extract imformation and initialise field 
	 * from it 
	 * @param domTreeDay
	 * @roseuid 3FFC041001E4
	 */
	public HalfDayConf(org.w3c.dom.Element domHDay) throws BadDomTreeParameterException {

		if (domHDay == null)
			throw new NullPointerException();

		String domHDayBaliseName = domHDay.getNodeName();
		
		if (!domHDayBaliseName.equals(PlanningDtd.MORNING) && !domHDayBaliseName.equals(PlanningDtd.AFTERNOON))
			throw new BadDomTreeParameterException("the parameter is not an halfDay dom tree");

		this.domHalfDay = domHDay;

		// init morning 
		this.isMorning = domHDayBaliseName.equals("morning");

		rdvDuration = Integer.parseInt(domHDay.getAttribute(PlanningDtd.MEETINGDURATION));
		nbCorrector = Integer.parseInt(domHDay.getAttribute(PlanningDtd.CORRECTORNUMBER));
		nbRavel = Integer.parseInt(domHDay.getAttribute(PlanningDtd.RAVELNUMBER));

		// openning hour extraction
		begin = extractHour(domHDay, "beginingHour");
		end = extractHour(domHDay, "endHour");
	}

	/**
	 * Constructor.
	 * 
	 * @param begin opening time.
	 * @param end closing time.
	 * @param RdvDuration duration of a rendez-vous.
	 * @param nbCorrector number of correectors.
	 * @param nbRavel number of ravel students. 
	 * @param rdvDuration the duration of a meeting
	 * @param morning to know if the halfday is the morning or not
	 * @roseuid 3FE6018301BE
	 */
	public HalfDayConf(java.util.Calendar begin, java.util.Calendar end, int rdvDuration, int nbCorrector, int nbRavel, boolean morning) {

		if (begin == null || end == null)
			throw new NullPointerException();

		this.begin = begin;
		this.end = end;
		this.rdvDuration = rdvDuration;
		this.nbCorrector = nbCorrector;
		this.nbRavel = nbRavel;
		this.isMorning = morning;

	}

	/**
	 * extract an hour from a hour subtree 
	 * @param ElementName beginigHour or endHour
	 * @param root the root element where extract the hour
	 */
	private Calendar extractHour(Element midlDay, String ElementName) {
		Element hourElement = (Element)midlDay.getElementsByTagName(ElementName).item(0);

		Element hour = (Element)hourElement.getElementsByTagName("Hour").item(0);

		String hh = hour.getAttribute("hour");
		String mm = hour.getAttribute("min");

		Calendar gc = new GregorianCalendar(Locale.FRANCE);
		gc.set(0, 0, 0, Integer.parseInt(hh), Integer.parseInt(mm));

		return gc;
	}

	/**
	 * Returns the closing time.
	 * 
	 * @return the closing time.
	 * @roseuid 3FE6023A0280
	 */
	public Calendar getEndTime() {
		return end;
	}

	/**
	 * Returns the number of correctors.
	 * 
	 * @return the number of correctors.
	 * @roseuid 3FE6024D0241
	 */
	public int getNbCorrector() {
		return nbCorrector;
	}

	/**
	 * Returns the number of ravel student.
	 * 
	 * @return the number of ravel.
	 * @roseuid 3FE6025B0183
	 */
	public int getNbRavel() {
		return nbRavel;
	}

	/**
	 * Returns the opening time.
	 * 
	 * @return the opening time.
	 * @roseuid 3FE602260104
	 */
	public Calendar getBeginTime() {
		return begin;
	}

	/**
	 * Returns the duration of a rendez-vous.
	 * 
	 * @return the duration of a rendez-vous.
	 * @roseuid 3FE60244032E
	 */
	public int getRdvDuration() {
		return rdvDuration;
	}

	/**
	 * @param document
	 * @return org.w3c.dom.Node
	 * @roseuid 3FFBE6A6005D
	 */
	public org.w3c.dom.Node toDomNode(org.w3c.dom.Document document) {
	
		if(domHalfDay != null)
			return domHalfDay;
	
		// morning balise init 
		Element root;
		if(isMorning) root= document.createElement(PlanningDtd.MORNING);
		else root = document.createElement(PlanningDtd.AFTERNOON);
		root.appendChild(document.createTextNode("\n"));
		
		// morning blise parameters
		root.setAttribute(PlanningDtd.CORRECTORNUMBER, Integer.toString(nbCorrector));
		root.setAttribute(PlanningDtd.MEETINGDURATION, Integer.toString(rdvDuration));
		root.setAttribute(PlanningDtd.RAVELNUMBER, Integer.toString(nbRavel));

//		openning and close Hour init and appending
		HourNodeConvertor open =  new HourNodeConvertor(begin);
		HourNodeConvertor close = new HourNodeConvertor(end);
				
		root.appendChild(document.createElement(PlanningDtd.BEGININGHOUR)).appendChild(open.toDomNode(document));
		root.appendChild(document.createTextNode("\n"));		
		root.appendChild(document.createElement(PlanningDtd.ENDHOUR)).appendChild(close.toDomNode(document));
		root.appendChild(document.createTextNode("\n"));
		
		return root;

	}

	/**
	 * morning Getter
	 */
	public boolean isMorning() {		
		return isMorning;
	}
}
