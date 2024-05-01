package testsBottle;

import types.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BottleTestSize {

	private Bottle bottleTest;
	

	
	@Test
	void test1() {

		Filling[] vec = new Filling[7];

		bottleTest = new Bottle(vec);

		int actual = bottleTest.capacity();
		int expected = 7;

		assertEquals(actual, expected);

	}
	
	@Test
	void test2() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.LOVE;
		
		bottleTest = new Bottle(vec);

		
		int actual = bottleTest.capacity();
		int expected = 5;
		
		assertEquals(actual, expected);

	}
	
	@Test
	void test3() {

		bottleTest = new Bottle();

		
		int actual = bottleTest.capacity();
		int expected = 5;
		
		assertEquals(actual, expected);

	}
	
	

}
