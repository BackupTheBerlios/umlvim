//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\transaction\\Undoable.java

package fr.umlv.desperados.util.transaction;


/**
 * A class that implements the <code>Undoable</code> interface represents an 
 * action that can be done and undone.
 */
public interface Undoable 
{
   
   /**
    * method that execute the Action.
    * 
    * @return <code>true</code> if the Action succeed, <code>false</code> otherwise.
    * @throws java.lang.Exception if a error occurs while doing the action.
    * @roseuid 3FE2C6100150
    */
   public boolean doIt() throws Exception;
   
   /**
    * Method that rollback the Action.
    * 
    * @return <code>true</code> if the Action rollback succeed, <code>false</code> 
    * otherwise.
    * @throws java.lang.Exception if a error occurs while undoing the action.
    * @roseuid 3FE2C6980155
    */
   public boolean undoIt() throws Exception;
}
