//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\StyleSheet.java

package fr.umlv.desperados.stylesheet;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import fr.umlv.desperados.util.XMLable;

/**
 * Object that represents a style sheet.
 */
public class StyleSheet implements XMLable 
{
   
   /**
    * The filename of the StyleSheet.
    */
   private String fileName;
   
   /**
    * The name of the StyleSheet.
    */
   private String name;
   
   /**
    * Constructor.
    * @param name the name of the StyleSheet
    * @param filename the filename of the StyleSheet.
    * @roseuid 3FE74A2B01AE
    */
   public StyleSheet(String filename, String name) 
   {
    this.fileName = filename;
    this.name = name;
   }
   
   /**
    * Gets the file name of the StyleSheet.
    * 
    * @return the file name of the StyleSheet.
    * @roseuid 3FE74A410105
    */
   public String getFilename() 
   {
    return fileName;
   }
   
   public String getName()
   {
   	return name;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FF869D102EB
    */
   public String toXML() 
   {
   	// TODO
   	String xmlString = "";
   	try {
		InputStream is = new FileInputStream(fileName);
		byte[] lu = new byte[10];
		while(is.read(lu)!=-1)
			xmlString += new String(lu);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
    return xmlString;
   }
}