//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\UserUtilities.java

package fr.umlv.desperados.account;


/**
 * Class containing some tools for the User managment.
 */
public final class UserUtilities 
{
   
   /**
    * Generates a password in a random way.
    * 
    * @return the password generated, in plain text.
    * @roseuid 3FBBC3400147
    */
   public static String generatePassword() 
   {
    return null;
   }
   
   /**
    * Generates a login, using the given name and firstname. The returned String 
    * contains a maximum of eight letters. This method takes the first letter of 
    * <code>firstname</code> and the seven first letter of the <code>name</code>. If 
    * <code>name</code> contains less than seven letters, the return string will 
    * contains less than eight letters.
    * 
    * @param name the name used to create the login.
    * @param firstname the firstname used to create the login.
    * @return the generated login.
    * @roseuid 3FE55E4D002E
    */
   public static String generateLogin(String name, String firstname) 
   {
    return null;
   }
   
   /**
    * Generates a login, using the given name, firstname and number. The returned 
    * String contains a maximum of eight letters. This method concatenes the first 
    * letter of <code>firstname</code>, the five first letter of the 
    * <code>name</code>, and the given number. If <code>name</code> contains less 
    * than five letters, the return string will contains less than eight letters.
    * 
    * This method is typically used when a login, generated with the method 
    * <code>generateLogin(String, String)</code>, already exists for the application.
    * 
    * @param name the name used to create the login.
    * @param firstname the firstname used to create the login.
    * @param number the number used to create the login (if the login created with
    * name and firstname already exists).
    * @return the generated login.
    * @roseuid 3FBBBF4A00D9
    */
   public static String generateLogin(String name, String firstname, int number) 
   {
    return null;
   }
}
