/*
 * Créé le 4 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.util;

import junit.framework.TestCase;

/**
 * @author ncuvelie
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class CacheTest extends TestCase {

	/**
	 * Constructor for CacheTest.
	 * @param arg0
	 */
	public CacheTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(CacheTest.class);
	}

	public void testCache() {
		Cache cache = new Cache(10);
		cache.setCapacity(12);
		String[] objects = { "object0",
				"object1", "object2", "object3", "object4", "object5",
				"object6", "object7", "object8", "object9", "object10",
				"object11", "object12", "object13", "object14", "object15" };
		for(int i=0 ; i<16 ; i++) {
			cache.put(""+i, objects[i]);
			cache.get(""+3);
			cache.get(""+0);
		}
		for(int i=0 ; i<16 ; i++) {
			String str = (String)cache.get(""+i);
			if(str != null) {
				System.out.println(str+" est dans le cache");
			}
		}
	}
}