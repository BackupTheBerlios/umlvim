//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserList.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;


/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of User.
 */
final class DatabaseUserList extends AbstractList 
{
   
   /**
    * The ResultSet containing the User list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a User list.
    * @roseuid 3FE5CEFC0223
    */
   DatabaseUserList(ResultSet rs) 
   {
    this.rs=rs;
   }
   
   /**
    * @param i
    * @return java.lang.Object
    * @roseuid 3FF869BA0143
    */
   public Object get(int i) 
   {
   	   	User user = null;
   	try {
		rs.absolute(i);
	} catch (SQLException e) {
		// TODO Bloc catch auto-généré
		e.printStackTrace();
	}
   	try {
		user = new User(rs.getString ("LOGIN_COM"));
		user.setName(rs.getString("NOM_COM"));
		user.setFirstname(rs.getString("PRENOM_COM"));
		user.setAdmin(rs.getBoolean("EST_ADM_COM"));
		user.setPassword(rs.getString("PASS_COM"));
	} catch (SQLException e1) {
		// TODO Bloc catch auto-généré
		e1.printStackTrace();
	}
   	   	    return user;
   }
   
   /**
    * @return int
    * @roseuid 3FF869BA0157
    */
   public int size() 
   {
	int i=0;
   	try {
		rs.last();
		i=rs.getRow();
	} catch (SQLException e) {
				e.printStackTrace();
	}   
  
    return i;
   }
}
/**
 * 
 * 
 *  
 * DatabaseUserList.get(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserList.size(){
 *     return 0;
 *    }
 *  
 *  
 *  
 */
