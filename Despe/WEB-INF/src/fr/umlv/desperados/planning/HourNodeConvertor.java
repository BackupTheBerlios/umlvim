//Source file: E:\\FAC\\GENIE LOG\\prise de rendez vous\\fr\\umlv\\desperados\\planning\\HourNodeConvertor.java

package fr.umlv.desperados.planning;

import java.util.Calendar;

import org.w3c.dom.Element;


/**
 * class responding of the data class into Dom tree
 * 
 * @author julien Decreton
 * @version 1.1
 */
public class HourNodeConvertor implements NodeConverter{
   
   private int hour;
   private int min;
   /**
    * unique constructor
    * @param hour
    * @roseuid 3FFBE5F7038A
    */
   public HourNodeConvertor(java.util.Calendar hour){
    this.hour = hour.get(Calendar.HOUR);    
    this.min = hour.get(Calendar.MINUTE);
   }
   
   /**
    * @param document
    * @return org.w3c.dom.Node
    * @roseuid 3FFBE9ED031C
    */
   public org.w3c.dom.Node toDomNode(org.w3c.dom.Document document){
	Object doc = null;
   	
   	// create an hour element
	Element hour = document.createElement(PlanningDtd.HOUR);		
	hour.setAttribute(PlanningDtd.HOURPARAMHOUR,Integer.toString(this.hour));
	hour.setAttribute(PlanningDtd.HOURPARAMMIN,Integer.toString(this.min));	

	return hour;
   }
}
