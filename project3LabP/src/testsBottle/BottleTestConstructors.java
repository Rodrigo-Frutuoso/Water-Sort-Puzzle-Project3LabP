package testsBottle;

import types.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class BottleTestConstructors {

	private Bottle bottleTest;

	@Test
	public void testContrutor1() {

		bottleTest = new Bottle();

		int actual = bottleTest.capacity();
		int expected = Bottle.DEFAULT_CAPACITY;

		assertEquals(actual,expected);

	}

	@Test
	public void testContrutor2() {

		bottleTest = new Bottle();

		int actual = bottleTest.spaceAvailable();
		int expected = 5;

		assertEquals(actual,expected);

	}

	@Test
	public void testContrutor3() {

		Filling[] vec = new Filling[7];

		bottleTest = new Bottle(vec);

		int actual = bottleTest.capacity();
		int expected = 7;

		assertEquals(actual,expected);

	}

	@Test
	public void testContrutor4() {

		Filling[] vec = new Filling[7];

		bottleTest = new Bottle(vec);

		int actual = bottleTest.spaceAvailable();
		int expected = 7;

		assertEquals(actual,expected);

	}
	
	
	@Test
	public void test8() {
		Filling[] vec = new Filling[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		

		String actual = bottleTest.toString();
		String expected = 
				  "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL;

		assertEquals(actual,expected);
	}
	
	@Test
	public void test4() {

		Filling[] vec = new Filling[5];
		vec[4] = Filling.LOVE;

		for (int i = 0; i < vec.length-1; i++) {
			vec[i] = Filling.ANGEL;
		}
		bottleTest = new Bottle(vec);


		String actual = bottleTest.toString();
		String expected = "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😇"+ Table.EOL
				+ "😍"+ Table.EOL;

		assertEquals(actual,expected);
	}

}
