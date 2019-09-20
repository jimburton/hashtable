package ci583.htable.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ci583.htable.impl.Hashtable;
import ci583.htable.impl.Hashtable.PROBE_TYPE;

public class TestHT {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testEmpty() {
		Hashtable<Boolean> h = new Hashtable<Boolean>(100);
		assertNull(h.get("foo"));
	}
	
	@Test
	public void testNotFound() {
		Hashtable<Boolean> h = new Hashtable<Boolean>(100);
		h.put("yes", true);
		assertNull(h.get("no"));
	}
	
	@Test
	public void testInsert() {
		Hashtable<Boolean> h = new Hashtable<Boolean>(1000, PROBE_TYPE.DOUBLE_HASH);
		for(int i=0;i<2000;i++) {
			for(int j=2000;j>0;j--) {
				h.put(i+":"+j, true);
			}
		}
		
		for(int i=0;i<2000;i++) {
			for(int j=2000;j>0;j--) {
				assertTrue(h.hasKey(i+":"+j));
			}
		}
	}
	
	@Test
	public void testGet() {
		Hashtable<String> h = new Hashtable<String>(9);
		for(int i=0;i<10;i++) {
			for(int j=10;j>0;j--) {
				h.put(i+":"+j, j+":"+i);
			}
		}
		
		for(int i=0;i<10;i++) {
			for(int j=10;j>0;j--) {
				assertEquals(h.get(i+":"+j), j+":"+i);
			}
		}
	}
	
	@Test
	public void testNull() {
		Hashtable<Integer> h = new Hashtable<Integer>(20);
		for(int i=0;i<10;i++) h.put(Integer.valueOf(i).toString(), Integer.valueOf(i));
		assertNull(h.get(11+""));
	}

	@Test
	public void testCapacity() {
		Hashtable<Integer> h = new Hashtable<Integer>(20, Hashtable.PROBE_TYPE.LINEAR_PROBE);
		assertEquals(h.getCapacity(), 23);//23 is smallest prime > 20
		for(int i=0;i<20;i++) h.put(Integer.valueOf(i).toString(), Integer.valueOf(i));
		assertFalse(h.getCapacity() == 23);//should have resized
		assertFalse(h.getLoadFactor() > 0.6);
	}
	
	@Test
	public void testKeys() {
		Hashtable<Integer> h = new Hashtable<Integer>(20, Hashtable.PROBE_TYPE.LINEAR_PROBE);
		h.put("bananas", 1);
		h.put("pyjamas", 99);
		h.put("kedgeree", 1);
		for(String k: h.getKeys()) {
			assertTrue(k.equals("bananas") || k.equals("pyjamas") || k.equals("kedgeree"));
		}
	}

}