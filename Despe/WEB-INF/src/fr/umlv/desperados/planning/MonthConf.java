/*
 * Creation date: 10 janv. 2004
 * Author: Decreton julien 
 * file name: MonthConf.java
 * Team : Desperados
 * Version: 0.1
 */
 
package fr.umlv.desperados.planning;

import java.util.Calendar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



/**
 * Classe use to create month subtree in a planning
 * @author Decreton Julien
 */
public class MonthConf implements NodeConverter {

	private int monthNb; 
	private DayConf dayConf;
	
	/**
	 * @param day
	 * @param conf
	 */
	public MonthConf(Calendar day, DayConf conf) {
		
		monthNb = day.get(Calendar.MONTH);
		dayConf = conf;		
	}

	public Node toDomNode(Document document) {
		
		Element monthElement = document.createElement(PlanningDtd.MONTH);		
		monthElement.setAttribute(PlanningDtd.NUMBER,Integer.toString(monthNb));
		
		monthElement.appendChild(dayConf.toDomNode(document));
		monthElement.appendChild(document.createTextNode("\n"));
		
		return monthElement;
	}
}
