//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\PlanningConf.java

package fr.umlv.desperados.planning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * This class provides access to the planning configuration.
 * @author Julien Decreton
 * @version 1.1
 */
public class PlanningConf implements NodeConverter {

	/**
	 * the path a the planning file
	 */
	private String path;

	/**
	 * the dom document associate with the planning
	 */
	private org.w3c.dom.Document planningDoc;

	/**
	 * the planning's tree DOM root element
	 */
	private org.w3c.dom.Element rootElement;

	/**
	 * create a planningConf object with a defined file
	 * 
	 * @param path - the path of the xml planning
	 * @param name - the name of the xml planning
	 * @roseuid 3FFBF5FD02CE
	 */
	public PlanningConf(String path) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException, IOException {

		if (path == null)
			throw new NullPointerException();

		this.path = path;

		// planning parsing an validating
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		FileInputStream fis = new FileInputStream(new File(this.path));
		planningDoc = builder.parse(fis);

		//verification if its realy a planning
		if (!isAPlanning())
			throw new ParserConfigurationException("the given file is not a planning");

		rootElement = (Element)planningDoc.getDocumentElement();

	}

	/**
	 * check if a file is a planning
	 * @return boolean
	 * @roseuid 3FED7808029F
	 */
	private boolean isAPlanning() {
		// get the planning root
		Element rootElement = (Element)planningDoc.getDocumentElement();
		// check if the root element name is "planning"
		return rootElement.getNodeName().equals(PlanningDtd.PLANNING);
	}

	/**
	 * Sets the configuration <code>conf</code> for the given day.
	 * 
	 * @param day the day to configure.
	 * @param conf the new configuration of the given day.
	 * @roseuid 3FE602B40109
	 */
	public void setConf(Calendar day, DayConf conf) throws IOException {

		//	day and month extraction 		
		Element monthElement;
		try {
			monthElement = getMonth(day.get(Calendar.MONTH));
			Element dayE;
			try {
				dayE = getDay(monthElement, conf.getDayNumber());
				monthElement.removeChild(dayE);
			} catch (DayNotFoundException e) {}

			// append the day in the month
			monthElement.appendChild(conf.toDomNode(planningDoc));

		} catch (MonthNotFoundException e1) {
			monthElement = (Element)new MonthConf(day, conf).toDomNode(planningDoc);
			rootElement.appendChild(monthElement);
		}

		// save	
		save();
	}

	/**
	 * Save the planning
	 */
	private void save() throws IOException {

		// TODO : améliorer le systeme de sauvagarde il y a un bug avec les retour a la ligne

		//((XmlDocument)planningDoc).write(new FileOutputStream(path));

		DocumentType docT = planningDoc.getDoctype();

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<!DOCTYPE planning SYSTEM '" + PlanningDtd.getDtdPath() + "'>\n";

		FileOutputStream fo = new FileOutputStream(path);
		fo.write((header + rootElement.toString()).getBytes());
		fo.close();
	}

	/**
	 * Gets the configuration of the given day.
	 * 
	 * @param day the day we want the configuration.    * 
	 * @return fr.umlv.desperados.planning.DayConf
	 * @roseuid 3FE602C90217
	 */
	public DayConf getConf(Calendar day) throws BadDomTreeParameterException, MonthNotFoundException, DayNotFoundException {

		//		parcours de l'arbre jusqu'au bon jour
		Element goodMonth = getMonth(day.get(Calendar.HOUR));
		Element goodDay = getDay(goodMonth, day.get(Calendar.DATE));

		// day transformation in a DayConf sub tree	
		return new DayConf(goodDay);

	}

	/**
	 * get a month in the xml configuration tree 
	 * @param monthnb the month number. - 1 for january ... 12 for december
	 * @return the tree node corresponding to monthnb orelse null 
	 */
	private Element getMonth(int monthNb) throws MonthNotFoundException {

		NodeList monthList = rootElement.getElementsByTagName("month");
		Element goodMonth = null;
		Element month = null;
		int monthListSize = monthList.getLength();

		// search the month correscponding to the date
		for (int i = 0; i < monthListSize; ++i) {
			month = (Element)monthList.item(i);
			int monthnb = Integer.parseInt(month.getAttribute("number"));
			if (monthnb == monthNb) {
				i = monthListSize;
				goodMonth = month;
			}
		}

		if (goodMonth == null)
			throw new MonthNotFoundException("unable to find th month number: " + monthNb + "( january=0 ).\n " + "This month doesn't appair in the configuration file");

		return goodMonth;
	}

	/**
	 * get a day from a month element
	 * @param month the month where search the day
	 * @param daynb the day number to search in the month ( number between 1 and 31 )
	 * @return the day corresponding to the number orelese null
	 */
	private Element getDay(Element month, int daynb) throws DayNotFoundException {

		NodeList dayList = month.getElementsByTagName("day");
		int dayListSize = dayList.getLength();

		Element goodDay = null;
		Element day = null;

		for (int i = 0; i < dayListSize && month != null; ++i) {
			day = (Element)dayList.item(i);
			int dayNb = Integer.parseInt(day.getAttribute("number"));
			if (dayNb == daynb) {
				i = dayListSize;
				goodDay = day;
			}

		}

		if (goodDay == null)
			throw new DayNotFoundException("unable to find the day number: " + daynb);

		return goodDay;
	}

	/**
	 * @param document
	 * @return org.w3c.dom.Node
	 * @roseuid 3FFBE66D032C
	 */
	public org.w3c.dom.Node toDomNode(org.w3c.dom.Document document) {
		return rootElement;
	}

	/**
	 * planning document getter
	 * 
	 * @return the planning dom document
	 * @roseuid 3FFBF169002E
	 */
	public org.w3c.dom.Document getPlanningDoc() {
		return null;
	}
}
