package ci583.htable;

/**
 * A HashTable with no deletions allowed. Duplicates overwrite the existing value. Values are of
 * type V and keys are strings -- one extension is to adapt this class to use other types as keys.
 *
 * The underlying data is stored in the array `arr', and the actual values stored are pairs of
 * (key, value). This is so that we can detect collisions in the hash function and look for the next
 * location when necessary.
 */

import java.util.Collection;
import java.util.List;

public class Hashtable<V> {

    private static final int DOUBLE_HASH_MAX = 8; //used in the doubleHash method
    private Object[] arr; //an array of Pair objects, where each pair contains the key and value stored in the hashtable
    private int max; //the size of arr. This should be a prime number
    private int itemCount; //the number of items stored in arr
    private final double maxLoad = 0.6; //the maximum load factor

    public enum PROBE_TYPE {
        LINEAR_PROBE, QUADRATIC_PROBE, DOUBLE_HASH
    }
    private PROBE_TYPE probeType; //the type of probe to use when dealing with collisions

    /**
     * Create a new Hashtable with a given initial capacity and using a given probe type
     * @param initialCapacity
     * @param pt
     */
    public Hashtable(int initialCapacity, PROBE_TYPE pt) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Create a new Hashtable with a given initial capacity and using the default probe type
     * @param initialCapacity
     */
    public Hashtable(int initialCapacity) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Store the value against the given key. If the loadFactor exceeds maxLoad, call the resize
     * method to resize the array. the If key already exists then its value should be overwritten.
     * Create a new Pair item containing the key and value, then use the findEmpty method to find an unoccupied
     * position in the array to store the pair. Call findEmmpty with the hashed value of the key as the starting
     * position for the search, stepNum of zero and the original key.
     * containing
     * @param key
     * @param value
     */
    public void put(String key, V value) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Get the value associated with key, or return null if key does not exists. Use the find method to search the
     * array, starting at the hashed value of the key, stepNum of zero and the original key.
     * @param key
     * @return
     */
    public V get(String key) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Return true if the Hashtable contains this key, false otherwise
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Return all the keys in this Hashtable as a collection
     * @return
     */
    public Collection<String> getKeys() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Return the load factor, which is the ratio of itemCount to max
     * @return
     */
    public double getLoadFactor() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * return the maximum capacity of the Hashtable
     * @return
     */
    public int getCapacity() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Find the value stored for this key, starting the search at position startPos in the array. If
     * the item at position startPos is null, the Hashtable does not contain the value, so return null.
     * If the key stored in the pair at position startPos matches the key we're looking for, return the associated
     * value. If the key stored in the pair at position startPos does not match the key we're looking for, this
     * is a hash collision so use the getNextLocation method with an incremented value of stepNum to find
     * the next location to search (the way that this is calculated will differ depending on the probe type
     * being used). Then use the value of the next location in a recursive call to find.
     * @param startPos
     * @param key
     * @param stepNum
     * @return
     */
    private V find(int startPos, String key, int stepNum) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Find the first unoccupied location where a value associated with key can be stored, starting the
     * search at position startPos. If startPos is unoccupied, return startPos. Otherwise use the getNextLocation
     * method with an incremented value of stepNum to find the appropriate next position to check
     * (which will differ depending on the probe type being used) and use this in a recursive call to findEmpty.
     * @param startPos
     * @param key
     * @param stepNum
     * @return
     */
    private int findEmpty(int startPos, String key, int stepNum) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Finds the next position in the Hashtable array starting at position startPos. If the linear
     * probe is being used, we just increment startPos. If the double hash probe type is being used,
     * add the double hashed value of the key to startPos. If the quadratic probe is being used, add
     * the square of the step number to startPos.
     * @param startPos
     * @param key
     * @param stepNum
     * @return
     */
    private int getNextLocation(int startPos, String key, int stepNum) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * A secondary hash function which returns a small value (less than or equal to DBL_HASH_MAX)
     * to probe the next location if the double hash probe type is being used
     * @param key
     * @return
     */
    private int doubleHash(String key) {
        return (hash(key) % DOUBLE_HASH_MAX) + 1;
    }

    /**
     * Return an int value calculated by hashing the key. See the lecture slides for information
     * on creating hash functions. The return value should be less than max, the maximum capacity
     * of the array
     * @param key
     * @return
     */
    private int hash(String key) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Return true if n is prime
     * @param n
     * @return
     */
    private boolean isPrime(int n) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Get the smallest prime number which is larger than n
     * @param n
     * @return
     */
    private int nextPrime(int n) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Resize the hashtable, to be used when the load factor exceeds maxLoad. The new size of
     * the underlying array should be the smallest prime number which is at least twice the size
     * of the old array.
     */
    private void resize() {
        throw new UnsupportedOperationException("Method not implemented");
    }


    /**
     * Instances of Pair are stored in the underlying array. We can't just store
     * the value because we need to check the original key in the case of collisions.
     * @author jb259
     *
     */
    private class Pair {
        private String key;
        private V value;

        Pair(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}