/*
 * Creation date: 10 janv. 2004
 * Author: Decreton julien 
 * file name: TestPlanningConf.java
 * Team : Desperados
 * Version: 0.1
 */

package fr.umlv.desperados.planning.junit;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import fr.umlv.desperados.planning.BadDomTreeParameterException;
import fr.umlv.desperados.planning.DayConf;
import fr.umlv.desperados.planning.DayNotFoundException;
import fr.umlv.desperados.planning.HalfDayConf;
import fr.umlv.desperados.planning.MonthNotFoundException;
import fr.umlv.desperados.planning.PlanningConf;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Decreton Julien
 *
 */
public class TestPlanningConf extends TestCase {


	String day1 = "<day number=\"1\"><morning correctorNumber=\"10\" meetingDuration=\"10\" ravelNumber=\"2\"><beginingHour><Hour hour=\"9\" min=\"10\" /></beginingHour><endHour><Hour hour=\"9\" min=\"11\" /></endHour></morning></day>";   
	String day2 = "<day number=\"2\"><morning correctorNumber=\"3\" meetingDuration=\"2\" ravelNumber=\"1\"><beginingHour><Hour hour=\"14\" min=\"45\" /></beginingHour><endHour><Hour hour=\"13\" min=\"10\" /></endHour></morning></day>";
		
	/**
	 * Constructor for TestPlanningConf.
	 * @param arg0
	 */
	public TestPlanningConf(String arg0) {
		super(arg0);
	}

	/**
	 * Test default planning constructor -> PlanningConf(path)
	 */
	public void testDefaultConstructor() throws ParserConfigurationException, SAXException, IOException {

		PlanningConf pc = new PlanningConf("E:\\fac\\eclipse\\workspace\\fichiers\\planningExemple.xml");
		
	}
	
	
	/**
	 * Test ToDomNOde Methode 
	 */
	public void testToDomNode() throws ParserConfigurationException, SAXException, IOException {
		Document document = new XmlDocument();
		PlanningConf pc = new PlanningConf("E:\\fac\\eclipse\\workspace\\fichiers\\planningExemple.xml");
		
		Element e = (Element)pc.toDomNode(document);
		
//		String month = "<month number=\"0\">\n"+day1+"\n"+day2+"\n"+"</month>\n";
//		String planning = "<planning>\n"+month+"</planning>";            
//		
//		System.out.println(e);
//		System.out.println(planning);
//				
//		assertEquals(e.toString(),planning);
		
	}
	
	
	/**
	 * Test setConf Methode
	 */
	public void testSetConf() throws ParserConfigurationException, SAXException, MonthNotFoundException, DayNotFoundException, IOException{
	
		Document document = new XmlDocument();
		PlanningConf pc = new PlanningConf("E:\\fac\\eclipse\\workspace\\fichiers\\planningExemple.xml");
		
		int rdvDuration = 10;
		int nbCorrector = 5;
		int nbRavel = 30;

		GregorianCalendar begin = new GregorianCalendar(Locale.FRANCE);
		begin.set(0, 0, 0, 2, 30);

    	GregorianCalendar end = new GregorianCalendar(Locale.FRANCE);
		end.set(0, 0, 0, 5, 30);

		HalfDayConf am = new HalfDayConf(begin, end, rdvDuration, nbCorrector, nbRavel, true);
		HalfDayConf pm = new HalfDayConf(begin, end, rdvDuration, nbCorrector, nbRavel, false);
		
		int daynb = 1;
		DayConf df = new DayConf(am, pm, daynb);
		
		pc.setConf(new GregorianCalendar(2004,1,1),df);
		
	}
	
	
	/**
	 * Test getConf Method 
	 */
	public void testGetConf() throws ParserConfigurationException, SAXException, IOException, BadDomTreeParameterException, MonthNotFoundException, DayNotFoundException{
		
		Document document = new XmlDocument();
		PlanningConf pc = new PlanningConf("E:\\fac\\eclipse\\workspace\\fichiers\\planningExemple.xml");
		
		DayConf dayConf = pc.getConf(new GregorianCalendar(2004,0,1));
		
		//System.out.println(dayConf.toDomNode(document).toString());
		//System.out.println(day1);
		
		//assertEquals(dayConf.toDomNode(document).toString(),day1);
		
	}
	
	/**
	 * run all the test of the DayConfTest classe
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(TestPlanningConf.class);
	}

}
