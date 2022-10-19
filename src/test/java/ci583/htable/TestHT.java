package ci583.htable;

import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import ci583.htable.Hashtable.PROBE_TYPE;

import static org.junit.Assert.*;

public class TestHT {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Check that we can call get on an empty hashtable and that there is nothing in it.
	 */
	@Test
	public void testEmpty() {
		Hashtable<Boolean> h = new Hashtable<>(10);
		assertFalse(h.get("foo").isPresent());
	}

	/**
	 * Check that we can insert a key:value pair then retrieve it, and that key:value pairs
	 * that we have not inserted are not there.
	 */
	@Test
	public void testFoundNotFound() {
		Hashtable<Boolean> h = new Hashtable<>(10);
		h.put("yes", true);
		Optional<Boolean> o1 = h.get("yes");
		assertTrue(o1.isPresent() && o1.get());
		Optional<Boolean> o2 = h.get("no");
		assertFalse(o2.isPresent());
	}

	/**
	 * Check that duplicate keys are handled correctly, i.e. that the value associated with the
	 * key is overwritten.
	 */
	@Test
	public void testDuplicates() {
		Hashtable<String> h = new Hashtable<>(100);
		for(int i=0;i<50;i++) {
		    h.put(i+"", i+"");
        }
		h.put("a", "a");
		h.put("b", "b");
		h.put("a", "c");
		h.put("b", "d");
		assertEquals(h.get("a").get(), "c");
		assertEquals(h.get("b").get(), "d");
		assertEquals(h.getKeys().size(), 52);
	}

	/**
	 * Check that we cannot insert a null key.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullKey() {
		Hashtable<Boolean> h = new Hashtable<>(10);
		h.put(null, true);
	}

	/**
	 * Insert 100 items into a hashtable and retrieve them.
	 */
	@Test
	public void testGet() {
		Hashtable<String> h = new Hashtable<>(200);
		int c =0;
		for(int i=0;i<10;i++) {
			for(int j=10;j>0;j--) {
				h.put(i+":"+j, j+":"+i);
				c++;
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=10;j>0;j--) {
				assertEquals(h.get(i+":"+j).get(), j+":"+i);
			}
		}
	}

	/**
	 * Inserts 2 million items into the hashtable then makes sure we can retrieve them.
	 * This is a stress test for the data structure. It will probably take a few minutes to
	 * run. If it takes more time than that, consider refactoring the hash function so that
	 * fewer collisions occur.
	 */
	@Test
	public void testBigInsert() {
		Hashtable<Boolean> h = new Hashtable<>(2000000, PROBE_TYPE.DOUBLE_HASH);
		for(int i=0;i<1000;i++) {
			for(int j=1000;j>0;j--) {
				h.put(i+":"+j, true);
			}
		}
		
		for(int i=0;i<1000;i++) {
			for(int j=1000;j>0;j--) {
				assertTrue(h.hasKey(i+":"+j));
			}
		}
	}

	/**
	 * Test that the hashtable is resized when necessary.
	 */
	@Test
	public void testCapacity() {
		Hashtable<Integer> h = new Hashtable<>(20, Hashtable.PROBE_TYPE.LINEAR_PROBE);
		assertEquals(h.getCapacity(), 23);//23 is smallest prime > 20
		for(int i=0;i<20;i++) h.put(Integer.valueOf(i).toString(), Integer.valueOf(i));
		assertNotEquals(23, h.getCapacity());//should have resized
		assertFalse(h.getLoadFactor() > 0.6);
	}

	/**
	 * Test that we can get all the keys in the hashtable.
	 */
	@Test
	public void testKeys() {
		Hashtable<Integer> h = new Hashtable<>(20, Hashtable.PROBE_TYPE.LINEAR_PROBE);
		h.put("bananas", 1);
		h.put("pyjamas", 99);
		h.put("kedgeree", 1);
		Collection<String> keys = h.getKeys();
		assertEquals(3, keys.size());
		for(String k: keys) {
			assertTrue(k.equals("bananas") || k.equals("pyjamas") || k.equals("kedgeree"));
		}
	}
}