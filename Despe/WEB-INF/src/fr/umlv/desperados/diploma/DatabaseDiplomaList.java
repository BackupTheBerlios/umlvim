//Source file: C:\\Documents and Settings\\Arnaud FRICOTTEAU\\Mes documents\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaList.java

package fr.umlv.desperados.diploma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ListIterator;

import fr.umlv.desperados.database.DatabaseAbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Diploma.
 */
final class DatabaseDiplomaList extends DatabaseAbstractList 
{
   
   /**
	* Constructor.
	* 
	* @param rs the ResultSet containing the Diploma list.
	* @roseuid 3FE5CF43012B
	*/
   DatabaseDiplomaList(ResultSet rs) 
   {
	super(rs);
   }
   
   /**
	* @return java.util.Iterator
	* @roseuid 400BCB81031C
	*/
   public Iterator iterator() 
   {
	return new DatabaseDiplomaListIterator(rs);
   }
   
   /**
	* @param index
	* @return java.util.ListIterator
	* @roseuid 400BCB81032C
	*/
   public ListIterator listIterator(int index) 
   {
	return new DatabaseDiplomaListIterator(rs, index);
   }
   
   /**
	* @param index
	* @return java.lang.Object
	* @roseuid 400BD29A01C5
	*/
   public Object get(int index) 
   {
	Diploma diploma = null;
   	
	try {
		rs.absolute(index+1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		diploma = new Diploma(rs.getString("LIB_DIP_MLV"));
		diploma.setId(rs.getString("ID_DIP_MLV"));
		diploma.setCycle(rs.getString("ID_CYC"));
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return diploma;
   }
}
