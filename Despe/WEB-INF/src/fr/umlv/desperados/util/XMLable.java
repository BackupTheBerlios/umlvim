//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\XMLable.java

package fr.umlv.desperados.util;


/**
 * A class that implements this interface can be transformed in a XML stream (by 
 * implementing the toXML() method).
 * This is typically used when transforming an Object to a PDF file (using in 
 * association with a StyleSheet).
 */
public interface XMLable 
{
   
   /**
    * Returns a XML string representation of the object.
    * 
    * @return a String containing the XML stream that represents the object
    * @roseuid 3FE3024D026C
    */
   public String toXML();
}
