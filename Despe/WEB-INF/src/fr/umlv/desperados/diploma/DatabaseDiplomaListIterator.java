//Source file: C:\\Documents and Settings\\Arnaud FRICOTTEAU\\Mes documents\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaListIterator.java

package fr.umlv.desperados.diploma;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.umlv.desperados.database.DatabaseAbstractListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseDiplomaList.
 */
final class DatabaseDiplomaListIterator extends DatabaseAbstractListIterator 
{
   
	/**
	* @param rs
	* @param beginIndex
	* @roseuid 400BE8DD0242
	*/
	DatabaseDiplomaListIterator(ResultSet rs, int beginIndex) 
	{
	 super(rs, beginIndex);
	}
	   
   /**
	* Constructor.
	* 
	* @param rs the ResultSet containing the Diploma list.
	* @roseuid 3FE5CFBE0091
	*/
   DatabaseDiplomaListIterator(ResultSet rs) 
   {
	super(rs);
   }
   
   /**
	* @return java.lang.Object
	* @roseuid 3FF869D001B4
	*/
   public Object next() 
   {
	int current = 0;
	Diploma diploma = null;
	try {
		current = rs.getRow();
		index++;
		rs.absolute(index);
		diploma = new Diploma(rs.getString("LIB_DIP_MLV"));
		diploma.setId(rs.getString("ID_DIP_MLV"));
		diploma.setCycle(rs.getString("ID_CYC"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			rs.absolute(current);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return diploma;
   }
   
   /**
	* @return java.lang.Object
	* @roseuid 3FF869D001C7
	*/
   public Object previous() 
   {
	int current = 0;
	Diploma diploma = null;
	try {
		current = rs.getRow();
		index--;
		rs.absolute(index);
		diploma = new Diploma(rs.getString("ID_DIP_MLV"));
		diploma.setId(rs.getString("LIB_DIP_MLV"));
		diploma.setCycle(rs.getString("ID_CYC"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			rs.absolute(current);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return diploma;
   }
}
