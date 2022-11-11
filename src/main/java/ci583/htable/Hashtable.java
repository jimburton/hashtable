package ci583.htable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * A HashTable with no deletions allowed. Duplicates overwrite the existing value. Values are of
 * type V and keys are strings -- one extension is to adapt this class to use other types as keys.
 *
 * The underlying data is stored in the array `arr', and the actual values stored are pairs of
 * (key, value). This is so that we can detect collisions in the hash function and look for the next
 * location when necessary.
 */
public class Hashtable<V> {

	private static final int DOUBLE_HASH_MAX = 8; //used in the doubleHash method.
	private Object[] arr; //an array of Pair objects, where each pair contains the key and value stored in the hashtable.
	private int max; //the size of arr. This should be a prime number.
	private int itemCount; //the number of items stored in arr.
	private final double maxLoad = 0.6; //the maximum load factor.

	public enum PROBE_TYPE {
		LINEAR_PROBE, QUADRATIC_PROBE, DOUBLE_HASH
	}
	private final PROBE_TYPE probeType; //the type of probe to use when dealing with collisions

	/**
	 * Create a new Hashtable with a given initial capacity and using a given probe type.
	 * @param initialCapacity	The desired size of the Hashtable.
	 * @param pt				The probe type to be used.
	 */
	public Hashtable(int initialCapacity, PROBE_TYPE pt) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
	
	/**
	 * Create a new Hashtable with a given initial capacity and using the default probe type.
	 * @param initialCapacity	The desired size of the Hashtable.
	 */
	public Hashtable(int initialCapacity) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Store the value against the given key. If the key is null or an empty string, throw an
	 * IllegalArgumentException. If the loadFactor exceeds maxLoad, call the resize
	 * method to resize the array. the If key already exists then its value should be overwritten.
	 * Create a new Pair item containing the key and value, then use the findEmpty method to find an unoccupied 
	 * position in the array to store the pair. Call findEmpty with the hashed value of the key as the starting
	 * position for the search, stepNum of zero and the original key. Increment the item count if and only if a new
	 * item was stored.
	 * @param key		The key to store.
	 * @param value 	The value to store against the key.
	 */
	public void put(String key, V value) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Get the value associated with key, or return an empty Optional if the key does not exist. Use the find method to search the
	 * array, starting at the hashed value of the key, stepNum of zero and the original key. If the key is found return
	 * the value associated it wrapped up in an Optional using the Optional.of method, e.g. Optional.of(pair.value). If the key is not
	 * found return Optional.empty(). 
	 *
	 * @param key	The key of the object we are looking for.
	 * @return		An Optional containing the value we are asked to find, which is empty if the key was not present.
	 */
	public Optional<V> get(String key) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Return true if the Hashtable contains this key, false otherwise.
	 * @param key	The key of the object we are looking for.
	 * @return		True if the hashtable contains the key.
	 */
	public boolean hasKey(String key) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Return all the keys in this Hashtable as a collection.
	 * @return	The collection of keys.
	 */
	public Collection<String> getKeys() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Return the load factor, which is the ratio of itemCount to max.
	 * @return	The load factor
	 */
	public double getLoadFactor() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Return the maximum capacity of the Hashtable.
	 * @return	The maximum capacity.
	 */
	public int getCapacity() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
	
	/**
	 * Find an Optional containing the value stored for this key, starting the search at position startPos in the array.
	 * If the item at position startPos is null, the Hashtable does not contain the value, so return Optional.empty().
	 * If the key stored in the pair at position startPos matches the key we're looking for, return an Optional
	 * containing the associated value. If the key stored in the pair at position startPos does not match the key
	 * we're looking for, this is a hash collision so use the getNextLocation method with an incremented value of
	 * stepNum to find the next location to search (the way that this is calculated will differ depending on the
	 * probe type being used). Then use the value of the next location in a recursive call to find.
	 * @param startPos	The array index to check.
	 * @param key		The key of the Pair object we're looking for.
	 * @param stepNum	The number of times this method has been called in the current search.
	 * @return			The value of the Pair object with the right key.
	 */
	private Optional<V> find(int startPos, String key, int stepNum) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Find the first location where a value associated with key can be stored. Suitable locations are either
	 * unoccupied or contain a Pair object with the same key. The search begins at position startPos.
	 * If startPos is unoccupied or contains a Pair object with the same key, return startPos. Otherwise use
	 * the getNextLocation method with an incremented value of stepNum to find the appropriate next position to check
	 * (which will differ depending on the probe type being used) and use this in a recursive call to findEmpty.
	 * @param startPos	The array index to check.
	 * @param key		The key to store.
	 * @param stepNum	The number of times this method has been called in the current search for a location.
	 * @return			The location at which a Pair object with the key `key' can be stored.
	 */
	private int findEmptyOrSameKey(int startPos, String key, int stepNum) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Finds the next position in the Hashtable array starting at position startPos. If the linear
	 * probe is being used, we just increment startPos. If the double hash probe type is being used, 
	 * add the double hashed value of the key to startPos. If the quadratic probe is being used, add
	 * the square of the step number to startPos.
	 * @param startPos	The starting position within the array.
	 * @param key		The kay of the value to find or store.
	 * @param stepNum	The number of times this method has been called in the current search for a location.
	 * @return			The next location
	 */
	private int getNextLocation(int startPos, String key, int stepNum) {
		int step = startPos;
		switch (probeType) {
		case LINEAR_PROBE:
			step++;
			break;
		case DOUBLE_HASH:
			step += doubleHash(key);
			break;
		case QUADRATIC_PROBE:
			step += stepNum * stepNum;
			break;
		default:
			break;
		}
		return step % max;
	}

	/**
	 * A secondary hash function which returns a small value (less than or equal to DBL_HASH_K)
	 * to probe the next location if the double hash probe type is being used.
	 * @param key	The string to hash
	 * @return		The hash value
	 */
	private int doubleHash(String key) {
		return (hash(key) % DOUBLE_HASH_MAX) + 1;
	}

	/**
	 * Return an int value calculated by hashing the key. See the lecture slides for information
	 * on creating hash functions. The return value should be a positive number less than max,
	 * the maximum capacity of the array
	 * @param key	The string to hash
	 * @return		The hash value
	 */
	private int hash(String key) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Return true if n is prime
	 * @param n		The number to test
	 * @return		True if n is prime, false otherwise.
	 */
	private boolean isPrime(int n) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Get the smallest prime number which is larger than or equal to n
	 * @param n		The number for which to find the next prime.
	 * @return		The smallest prime number larger than or equal to n
	 */
	private int nextPrime(int n) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Resize the hashtable, to be used when the load factor exceeds maxLoad. The new size of
	 * the underlying array should be the smallest prime number which is at least twice the size
	 * of the old array.
	 */
	private void resize() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	
	/**
	 * Instances of Pair are stored in the underlying array. We can't just store
	 * the value because we need to check the original key in the case of collisions.
	 *
	 */
	private class Pair {
		private final String key;
		private final V value;

		Pair(String key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
