//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\DayConf.java

package fr.umlv.desperados.planning;

import org.w3c.dom.Element;

/**
 * Contains configuration informations for a complete day, by containing two 
 * HalfDayConf objects (one for the morning, the other for the afternoon).
 * 
 * @author Julien Decreton
 * @version 1.1
 */
public class DayConf implements NodeConverter {

	/** morning configuration */
	private HalfDayConf pm;

	/** afternoon configuration */
	private HalfDayConf am;

	/** DayConf dom tree */
	private Element domDay;

	/** the number of the day */
	private int dayNumber;

	/**
	 * default Constructor
	 * 
	 * @param am
	 * @param pm
	 * @roseuid 3FEEAB8102D5
	 */
	public DayConf(HalfDayConf am, HalfDayConf pm, int daynb) {
		this.am = am;
		this.pm = pm;
		dayNumber = daynb;
	}

	/**
	 * default Constructor
	 * 
	 * @param am
	 * @param pm
	 * @roseuid 3FEEAB8102D5
	 */
	public DayConf(Element e) throws BadDomTreeParameterException {
		
		if (e == null)
			throw new NullPointerException();
	
		if(!e.getNodeName().equals(PlanningDtd.DAY))
			throw new BadDomTreeParameterException("parameter is not a day tree");

		this.domDay = e;

		dayNumber = Integer.parseInt(domDay.getAttribute(PlanningDtd.NUMBER));
		
		Element amDomTree = (Element)e.getElementsByTagName(PlanningDtd.MORNING).item(0);
		Element pmDomTree = (Element)e.getElementsByTagName(PlanningDtd.AFTERNOON).item(0);
		
		// it could have no mornning or not afternoon in a working day
		if( pmDomTree != null ) pm = new HalfDayConf(pmDomTree);
		if( amDomTree != null ) am = new HalfDayConf(amDomTree);
		
	}

	/**
	 * Returns the HalfDayConf for the morning.
	 * 
	 * @return the HalfDayConf for the morning.
	 * @roseuid 3FEEAB630340
	 */
	public HalfDayConf getAMConf() {
		return am;
	}

	/**
	 * Returns the HalfDayConf for the afternoon.
	 * 
	 * @return the HalfDayConf for the afternoon.
	 * @roseuid 3FEEAB6E009D
	 */
	public HalfDayConf getPMConf() {
		return pm;
	}

	/**
	 * @param document
	 * @return org.w3c.dom.Node
	 * @roseuid 3FFBE68801B5
	 */
	public org.w3c.dom.Node toDomNode(org.w3c.dom.Document document) {

		if (domDay != null)
			return domDay;

		domDay = document.createElement(PlanningDtd.DAY);
		domDay.appendChild(document.createTextNode("\n"));
		domDay.setAttribute(PlanningDtd.NUMBER, new Integer(dayNumber).toString());
		
		// appen morning and afternoon
		if( am != null ) domDay.appendChild(am.toDomNode(document));
		if( pm != null ) domDay.appendChild(pm.toDomNode(document));	
		
		domDay.appendChild(document.createTextNode("\n"));

		return domDay;
	}

	/**
	 * @return the the date a the day
	 */
	public int getDayNumber() {		
		return dayNumber;
	}
}
