//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\PDFTools.java

package fr.umlv.desperados.util;

import java.io.*;

import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.XSLTInputHandler;
import org.xml.sax.*;

/**
 * This class provides tools to transform XML data into PDF formatted stream.
 */
public class PDFTools 
{
   
	/**
	 * Returns a PDF formatted InputStream. The method obtains the datas from 
	 * <code>datas</code> and the model from <code>styleSheet</code>.
	 * 
	 * @param datas a XML formatted InputStream containing the datas to transform.
	 * @param styleSheet a XML formatted InputStream containing the styleSheet used 
	 * for transformation.
	 * 
	 * @return java.io.InputStream
	 * @roseuid 3FD34C55007B
	 */
	public static InputStream generatePDF(InputStream datas, InputStream styleSheet) 
	{
	ByteArrayOutputStream out = new ByteArrayOutputStream();
     
	try
		{
		XSLTInputHandler inputH = new XSLTInputHandler(new InputSource(datas),new InputSource(styleSheet));
       
		Driver driver = new Driver();
       
		driver.setRenderer(Driver.RENDER_PDF);
		driver.setOutputStream(out);
       
		inputH.run(driver);
		}
	catch(FOPException fopException)
		{
		System.out.println("class PDFTools / method generatePDF : " + fopException);
		}
     
	return new ByteArrayInputStream(out.toByteArray());
	}
}