/*
 * Créé le 20 janv. 2004
 *
 */
package fr.umlv.desperados.stylesheet.junit;
import fr.umlv.desperados.stylesheet.StyleSheet;

import junit.framework.TestCase;

/**
 * @author ndedanil
 *
 */
public class StyleSheetTest extends TestCase {
	private StyleSheet styleSheet = null;
	/**
	 * Constructor for StyleSheetTest.
	 * @param arg0
	 */
	public StyleSheetTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(StyleSheetTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		styleSheet = new StyleSheet("/home/dslg00/ndedanil/workspace/stylesheet/raymonda.txt","ma Feuille");
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		styleSheet = null;
	}
	
	public void testGetFilename() {
		assertTrue(styleSheet.getFilename().equals("/home/dslg00/ndedanil/workspace/stylesheet/raymonda.txt"));
	}
	
	public void testGetName() {
		assertTrue(styleSheet.getName().equals("ma Feuille"));
	}
	
	public void testToXML() {
		assertTrue(styleSheet.toXML().equals("coucou"));
	}

}
