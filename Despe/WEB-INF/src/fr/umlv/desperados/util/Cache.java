//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\util\\Cache.java

package fr.umlv.desperados.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * provide a cache system.
 * When maximal size is reached, the eldest element is removed from the cache.
 * The eldest element is the least-recently accessed element of the Cache.
 */
public final class Cache extends LinkedHashMap {

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
	public Cache(int initialCapacity) {
		super(2*initialCapacity, (float)0.75, true);
		capacity = initialCapacity;
	}

	/**
	 * Returns the capacity of the cache.
	 * 
	 * @return the capacity of the cache.
	 * @roseuid 3FE5AB810381
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity of the cache.
	 * 
	 * @param capacity the new capacity of the cache.
	 * @roseuid 3FE5ABB0017F
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	public boolean removeEldestEntry(Map.Entry eldest) {
		return (size() > capacity);
	}
}