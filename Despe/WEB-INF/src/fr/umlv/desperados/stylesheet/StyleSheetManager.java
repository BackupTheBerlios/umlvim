//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\StyleSheetManager.java

package fr.umlv.desperados.stylesheet;

import java.util.List;


/**
 * Class responsible of adding, removing, listing, getting and setting StyleSheet 
 * in/from a permanent storage.
 */
public interface StyleSheetManager 
{
   public static final int RDV_LIST_DOCUMENT = 3;
   public static final int INSCRIPTION_DOCUMENT = 1;
   public static final int CONFIRMATION_DOCUMENT = 2;
   
   /**
    * Adds a StyleSheet in the permanent storage.
    * 
    * @param styleSheet the StyleSheet to add.
    * @roseuid 3FC0F46C0270
    */
   public void addStyleSheet(StyleSheet styleSheet);
   
   /**
    * Removes a StyleSheet from the permanent storage.
    * 
    * @param styleSheetId the identifiant of the StyleSheet to remove.
    * @roseuid 3FC0F49800DA
    */
   public void removeStyleSheet(String styleSheetId);
   
   /**
    * Assigns a StyleSheet to a type of document (which is one of 
    * StyleSheetManager.RDV_LIST_DOCUMENT, StyleSheetManager.INSCRIPTION_DOCUMENT or 
    * StyleSheetManager.CONFIRMATION_DOCUMENT).
    * 
    * @param StyleSheetId the identifiant of the StyleSheet to assign.
    * @param docTypeId the type of document the StyleSheet is assigned to.
    * @roseuid 3FC0F4B50195
    */
   public void setStyleSheet(String StyleSheetId, int docTypeId);
   
   /**
    * Lists all the StyleSheet of the permanent storage.
    * 
    * @return a <code>List</code> containing the StyleSheet.
    * @roseuid 3FC353570119
    */
   public List listStyleSheet();
   
   /**
    * Gets a StyleSheet from the permanent storage.
    * 
    * @param DocType the type of the document for which the styleSheet is requested.
    * @return the StyleSheet to get.
    * @roseuid 3FD32FD700A4
    */
   public StyleSheet getStyleSheet(int DocType);
}
