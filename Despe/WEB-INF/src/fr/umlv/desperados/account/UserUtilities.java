//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\UserUtilities.java

package fr.umlv.desperados.account;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public final class UserUtilities {

	/**
	 * Generates a password in a random way.
	 * 
	 * @return the password generated, in plain text.
	 * @roseuid 3FBBC3400147
	 */
	public static String generatePassword() {
		char [] tabChar ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
										'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
										'0','1','2','3','4','5','6','7','8','9'}; 

		Random rand = new Random(System.currentTimeMillis());
		byte[] passwordArray = new byte[8];
		for (int i = 0; i < 8; i++)
			passwordArray[i] = (byte) tabChar[rand.nextInt(tabChar.length)];

		return new String(passwordArray);
	}

	public static String cryptPassword(String plainTextPassword) {
		String cryptedPassword = null;
		try {
			MessageDigest messageDigest;
			messageDigest = MessageDigest.getInstance("MD5");
			byte[] b = messageDigest.digest(plainTextPassword.getBytes("US-ASCII"));
			cryptedPassword = new String(b, "US-ASCII");
		}catch (NoSuchAlgorithmException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		return cryptedPassword;
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
	public static String generateLogin(String name, String firstname) {
		return createLogin(name, firstname, 7);
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
	public static String generateLogin(String name, String firstname, int number) {

		String login = createLogin(name, firstname, 5);

		if (number < 10)
			login = login.concat(String.valueOf(0));
		login = login.concat(String.valueOf(number));

		return login;
	}

	private static String createLogin(String name, String firstname, int length) {
		String firstLetter = firstname.substring(0, 1);
		if (name.length() >= length)
			name = name.substring(0, length);
		name = name.replaceAll("[ ]", "");
		return firstLetter.concat(name).toLowerCase();
	}
}