//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\transaction\\Transaction.java

package fr.umlv.desperados.util.transaction;


/**
 * This class represents a transaction, that is a succession of actions on which 
 * the exit depends one on the other (if one of the actions fails, the others must 
 * be cancelled).
 */
public class Transaction 
{
   
   /**
    * Adds an <code>Undoable</code> to the transaction.
    * 
    * @param action the Undoable to add
    * @roseuid 3FE2C6FD01DD
    */
   public void addAction(Undoable action) 
   {
    
   }
   
   /**
    * Executes the Transaction.
    * 
    * @return <code>true</code> if the transaction ends correctly, <code>false</code> 
    * otherwise.
    * @throws java.lang.Exception if a error occurs when doing the Transaction.
    * @roseuid 3FE2C78A006D
    */
   public boolean doIt() throws Exception 
   {
    return true;
   }
}
