/*
 * Creation date: 7 janv. 2004
 * Author: Decreton julien 
 * file name: AllTests.java
 * Team : Desperados
 * Version: 0.1
 */

package fr.umlv.desperados.planning.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Decreton Julien
 *
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.class);
	}

	public static Test suite() {
		TestSuite suite =
			new TestSuite("Test for fr.umlv.desperados.planning.junit");
		//$JUnit-BEGIN$
		suite.addTest(TestDayConf.suite());
		suite.addTest(TestHalfDayConf.suite());
		suite.addTest(TestHourNodeConvertor.suite());
		suite.addTest(TestPlanningConf.suite());
		//$JUnit-END$
		return suite;
	}
}
