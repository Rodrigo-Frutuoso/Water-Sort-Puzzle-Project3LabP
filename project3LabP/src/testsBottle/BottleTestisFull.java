package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BottleTestisFull {

	private Bottle bottleTest;

	
	@Test
	void test1() {

		Filling[] vec = new Filling[7];

		bottleTest = new Bottle(vec);

		boolean actual = bottleTest.isFull();
		boolean expected = false;

		assertEquals(actual, expected);

	}
	
	@Test
	void test2() {

		Filling[] vec = new Filling[7];
		vec[0] = Filling.ANGEL;
		
		bottleTest = new Bottle(vec);

		
		boolean actual = bottleTest.isFull();
		boolean expected = false;

		assertEquals(actual, expected);

	}
	
	@Test
	void test3() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.ANGEL;
		vec[1] = Filling.ANGEL;
		vec[2] = Filling.ANGEL;
		vec[3] = Filling.ANGEL;
		vec[4] = Filling.ANGEL;
		
		bottleTest = new Bottle(vec);

		
		boolean actual = bottleTest.isFull();
		boolean expected = true;

		assertEquals(actual, expected);

	}
	
	@Test
	void test4() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.ANGEL;
		vec[1] = Filling.ANGEL;
		vec[2] = Filling.ANGEL;
		vec[3] = Filling.ANGEL;
		vec[4] = Filling.ANGEL;
		
		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		
		boolean actual = bottleTest.isFull();
		boolean expected = false;

		assertEquals(actual, expected);

	}
	
	@Test
	void test5() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.ANGEL;
		vec[1] = Filling.ANGEL;
		vec[2] = Filling.ANGEL;
		vec[3] = Filling.ANGEL;
		
		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		
		boolean actual = bottleTest.isFull();
		boolean expected = false;

		assertEquals(actual, expected);
	}
	
	@Test
	void test6() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.ANGEL;
		vec[1] = Filling.ANGEL;
		vec[2] = Filling.ANGEL;
		vec[3] = Filling.ANGEL;
		vec[4] = Filling.ANGEL;
		
		bottleTest = new Bottle(vec);
		
		bottleTest.receive(vec[2]);
		
		boolean actual = bottleTest.isFull();
		boolean expected = true;

		assertEquals(actual,expected);

	}

}
