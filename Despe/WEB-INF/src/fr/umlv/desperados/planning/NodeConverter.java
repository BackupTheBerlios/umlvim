//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\NodeConverter.java

package fr.umlv.desperados.planning;


/**
 * class responding of the data class into Dom tree
 */
public interface NodeConverter 
{
   
   /**
    * conter object's data to a DOM tree
    * @param document
    * @return org.w3c.dom.Node
    * @roseuid 3FFBE06D033C
    */
   public org.w3c.dom.Node toDomNode(org.w3c.dom.Document document);
}
