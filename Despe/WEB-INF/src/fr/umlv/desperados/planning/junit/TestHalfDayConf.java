/*
 * Creation date: 7 janv. 2004
 * Author: Decreton julien 
 * file name: TestHalfDayConf.java
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

import fr.umlv.desperados.planning.HalfDayConf;

/**
 * @author Decreton Julien
 *
 */
public class TestHalfDayConf extends TestCase {

	GregorianCalendar begin,end;
	int rdvDuration = 10;
	int nbCorrector = 5;
	int nbRavel = 30;
	boolean isMorning = true;
	
	/**
	 * Constructor for TestHalfDayConf.
	 * @param arg0
	 */
	public TestHalfDayConf(String arg0) {
		super(arg0);
	}

	/**
	 * Test "DayConf(begin,end,meetingDuration,nbcorrector,nbRavel,morning)" constructor	 
	 */
	public void testDefaultConstructor(){
		
		
		// implement a HalfDayConf object
		HalfDayConf hd = new HalfDayConf(begin,end,rdvDuration,nbCorrector,nbRavel,isMorning); 
		
		assertEquals(hd.getBeginTime(),begin);
		assertEquals(hd.getEndTime(),end);
		assertEquals(hd.getRdvDuration(),rdvDuration);
		assertEquals(hd.getNbCorrector(),nbCorrector);
		assertEquals(hd.getNbRavel(),nbRavel);
		assertTrue( hd.isMorning()==isMorning );
		
	}
	
	
	/**
	 * Test ToDomNode methode
	 */
	public void testToDomNode(){
		Document document = new XmlDocument();
		HalfDayConf hd = new HalfDayConf(begin,end,rdvDuration,nbCorrector,nbRavel,isMorning);
		Element e = (Element)hd.toDomNode(document);
		
//		assertEquals(e.toString(),"<morning correctorNumber=\"5\" meetingDuration=\"10\" ravelNumber=\"30\">" +//								  "<beginingHour><Hour hour=\"2\" min=\"30\" />" +//								  "</beginingHour>" +//								  "<endHour>" +//								  "<Hour hour=\"5\" min=\"30\" />" +//								  "</endHour><" +//								  "/morning>");	
	}
	
	
	/**
	 * Test "DayConf(Element domDay)" constructor	 
	 */
	public void testConstructerWhitDomTree() throws Exception {
				
		Document document = new XmlDocument();
		HalfDayConf hd = new HalfDayConf(begin,end,rdvDuration,nbCorrector,nbRavel,isMorning);
		
		Element e = (Element)hd.toDomNode(document);

		// DayConf init with a tree
		HalfDayConf hd2 = new HalfDayConf(e);
		document.appendChild(hd2.toDomNode(document));

		// check the equality of the to day conf
		assertEquals(hd.toDomNode(document).toString(), hd2.toDomNode(document).toString());

	} 

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		
		
		begin = new GregorianCalendar(Locale.FRANCE);
				begin.set(0,0,0,2,30);
		
		end = new GregorianCalendar(Locale.FRANCE);
		end.set(0,0,0,5,30);
		
		
	}


	/**
	* run all the test of the DayConfTest classe
	* @return
	*/
	public static Test suite() {
		return new TestSuite(TestHalfDayConf.class);
	}

}
