/*
 * Creation date: 8 janv. 2004
 * Author: Decreton julien 
 * file name: TestDayConf.java
 * Team : Desperados
 * Version: 0.1
 */

package fr.umlv.desperados.planning.junit;

import java.util.GregorianCalendar;
import java.util.Locale;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.umlv.desperados.planning.BadDomTreeParameterException;
import fr.umlv.desperados.planning.DayConf;
import fr.umlv.desperados.planning.HalfDayConf;

/**
 * @author Decreton Julien
 *
 */
public class TestDayConf extends TestCase {

	HalfDayConf am;
	HalfDayConf pm;

	/**
	 * Constructor for TestDayConf.
	 * @param arg0
	 */
	public TestDayConf(String arg0) {
		super(arg0);
	}

	/**
	 * Test the DayConf( am,pm, daynb ) constructor	 
	 */
	public void TestDefaultConstructor() {

		int daynb = 1;
		DayConf df = new DayConf(am, pm, daynb);

	}

	/**
	 * Test the dayConf(Element) constructor
	 */
	public void testConstructerWhitDomTree() throws BadDomTreeParameterException{
		Document document = new XmlDocument();
		
		int daynb = 1;
		DayConf df = new DayConf(am, pm, daynb);
		Element e = (Element)df.toDomNode(document);
		
		DayConf df2 = new DayConf(e);		
		
		assertEquals(e.toString(),df2.toDomNode(document).toString());
				
	}

	/**
		 * Test ToDomNOde Methode 
		 */
	public void testToDomNode() {
		Document document = new XmlDocument();
		int daynb = 1;
		DayConf df = new DayConf(am, pm, daynb);
		Element e = (Element)df.toDomNode(document);

//		String morning =
//			"<morning correctorNumber=\"5\" meetingDuration=\"10\" ravelNumber=\"30\">"
//				+ "<beginingHour><Hour hour=\"2\" min=\"30\" />"
//				+ "</beginingHour>"
//				+ "<endHour>"
//				+ "<Hour hour=\"5\" min=\"30\" />"
//				+ "</endHour><"
//				+ "/morning>";
//
//		String afternon =
//			"<afternoon correctorNumber=\"5\" meetingDuration=\"10\" ravelNumber=\"30\">"
//				+ "<beginingHour><Hour hour=\"2\" min=\"30\" />"
//				+ "</beginingHour>"
//				+ "<endHour>"
//				+ "<Hour hour=\"5\" min=\"30\" />"
//				+ "</endHour><"
//				+ "/afternoon>";
//		
//		String day = "<day number=\""+daynb+"\">"+morning+afternon+"</day>";
//				
//		//System.out.println(e);
//		//System.out.println(day);
//		
//		assertEquals(e.toString(),day);		

	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		int rdvDuration = 10;
		int nbCorrector = 5;
		int nbRavel = 30;

		GregorianCalendar begin = new GregorianCalendar(Locale.FRANCE);
		begin.set(0, 0, 0, 2, 30);

		GregorianCalendar end = new GregorianCalendar(Locale.FRANCE);
		end.set(0, 0, 0, 5, 30);

		am = new HalfDayConf(begin, end, rdvDuration, nbCorrector, nbRavel, true);
		pm = new HalfDayConf(begin, end, rdvDuration, nbCorrector, nbRavel, false);

	}

	/**
	* run all the test of the DayConfTest classe
	* @return
	*/
	public static Test suite() {
		return new TestSuite(TestDayConf.class);
	}

}
