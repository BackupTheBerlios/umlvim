/*
 * Creation date: 7 janv. 2004
 * Author: Decreton julien 
 * file name: TestHourNodeConvertor.java
 * Team : Desperados
 * Version: 0.1
 */
 
package fr.umlv.desperados.planning.junit;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.Document;

import fr.umlv.desperados.planning.HourNodeConvertor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Decreton Julien
 *
 */
public class TestHourNodeConvertor extends TestCase {

	private GregorianCalendar c;
	private int mm;
	private int hh;

	/**
	 * Constructor for TestHourNodeConvertor.
	 * @param arg0
	 */
	public TestHourNodeConvertor(String arg0) {
		super(arg0);
	}

	/**
	 * Test HourNodeConvertor(Calendar) constructor
	 * */
	public void testDefaultConstructor(){
		
		HourNodeConvertor h = new HourNodeConvertor(c);				
	}
	
	/**
	 * Test ToDomNode methode
	 */
	public void testToDomNode(){
		
		Document doc = new XmlDocument();
		String res = new HourNodeConvertor(c).toDomNode(doc).toString();
		System.out.println(res);
		assertEquals(res,"<Hour hour=\""+hh+"\" min=\""+mm+"\" />");		
	}
	
	
	/**
	 *  initialisation of the tests
	 */
	public void setUp() throws Exception{
		super.setUp();
		hh = 2;
		mm = 45;
		c = new GregorianCalendar(Locale.FRANCE);
		c.set(0,0,0,hh,mm);
		
	}
	
	/**
	* run all the test of the DayConfTest classe
	* @return
	*/
	public static Test suite() {
		return new TestSuite(TestHourNodeConvertor.class);
	}
	

}
