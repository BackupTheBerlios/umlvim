//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\Cache.java

package fr.umlv.desperados.util;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * provide a cache system.
 * When maximal size is reached, the eldest element is removed from the cache.
 * The eldest element is the least-recently accessed element of the Cache.
 */
public final class Cache extends LinkedHashMap 
{
   
   /**
    * The size of the cache.
    */
   private int capacity = 16;
   
   /**
    * Constructs an empty access-ordered <code>Cache</code> instance with the 
    * specified initial capacity.
    * 
    * @param initialCapacity the initial capacity of the cache.
    * @roseuid 3FF2E8C50035
    */
   public Cache(int initialCapacity) 
   {
    
   }
   
   /**
    * Returns the size of the cache.
    * 
    * @return the size of the cache.
    * @roseuid 3FE5AB810381
    */
   public int getCapacity() 
   {
    return 0;
   }
   
   /**
    * Sets the size of the cache.
    * 
    * @param size the new size of the cache.
    * @roseuid 3FE5ABB0017F
    */
   public void setCapacity(String size) 
   {
    
   }
   
   /**
    * Returns <code>true<code> if the cache should remove its eldest element, 
    * <code>false</code> otherwise.
    * 
    * 
    * @param eldest
    * @return boolean
    * @roseuid 3FF2E44A0389
    */
   public boolean removeEldestEntry(Map.Entry eldest) 
   {
    return true;
   }
}
