//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetManager.java

package fr.umlv.desperados.stylesheet;

import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;

/**
 * Provides an implementation of the StyleSheetManager interface, using an 
 * relational database.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseStyleSheetManager implements StyleSheetManager 
{
   
   /**
    * The DatabaseRequestor of this manager.
    */
   private DatabaseRequestor requestor;
   
   /**
    * The unique instance of DatabaseStyleSheetManager.
    */
   private static DatabaseStyleSheetManager theInstance = null;
   
   /**
    * Private default constructor.
    * 
    * @param requestor the DatabaseRequestor of this manager.
    * @roseuid 3FD7420D01D4
    */
   private DatabaseStyleSheetManager(DatabaseRequestor requestor) 
   {
    
   }
   
   /**
    * Instance getter.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @return the unique instance of StyleSheetManager.
    * @roseuid 3FF85111002D
    */
   public DatabaseStyleSheetManager getInstance(DatabaseRequestor requestor) 
   {
		if (theInstance == null)
			theInstance = new DatabaseStyleSheetManager(requestor);

		return theInstance;    
   }
   
   /**
    * @param styleSheet
    * @roseuid 3FF869D00380
    */
   public void addStyleSheet(StyleSheet styleSheet) 
   {
    
   }
   
   /**
    * @param styleSheetId
    * @roseuid 3FF869D00394
    */
   public void removeStyleSheet(String styleSheetId) 
   {
    
   }
   
   /**
    * @param StyleSheetId
    * @param docTypeId
    * @roseuid 3FF869D003A8
    */
   public void setStyleSheet(String StyleSheetId, int docTypeId) 
   {
    
   }
   
   /**
    * @return java.util.List
    * @roseuid 3FF869D003D0
    */
   public List listStyleSheet() 
   {
    return null;
   }
   
   /**
    * @param DocType
    * @return fr.umlv.desperados.stylesheet.StyleSheet
    * @roseuid 3FF869D003DA
    */
   public StyleSheet getStyleSheet(int DocType) 
   {
    return null;
   }
}
/**
 * 
 * 
 *  
 * DatabaseStyleSheetManager.setStyleSheet(String,int){
 * 	}
 *  
 *  
 * DatabaseStyleSheetManager.removeStyleSheet(String){
 * 	}
 *  
 *  
 * DatabaseStyleSheetManager.getStyleSheet(int){
 * 		return null;
 * 	}
 *  
 *  
 * DatabaseStyleSheetManager.addStyleSheet(StyleSheet){
 * 	}
 *  
 *  
 * DatabaseStyleSheetManager.listStyleSheet(){
 * 		return null;
 * 	}
 *  
 *  
 *  
 */
