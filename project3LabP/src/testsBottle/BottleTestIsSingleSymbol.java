package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BottleTestIsSingleSymbol {

	private Bottle bottleTest;
	


	@Test
	void test1() {

		Filling[] vec = new Filling[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.LOVE;
		}

		bottleTest = new Bottle(vec);

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = true;

		assertEquals(expected, actual);

	}

	@Test
	void test2() {

		Filling[] vec = new Filling[7];

		vec[0] = Filling.LOVE;

		for (int i = 1; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	void test3() {

		Filling[] vec = new Filling[5];



		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		vec[4] = Filling.LOVE;
		
		bottleTest = new Bottle(vec);

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = false;

		assertEquals(expected, actual);

	}

	@Test
	void test4() {

		Filling[] vec = new Filling[5];


		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		vec[2] = Filling.LOVE;
		
		bottleTest = new Bottle(vec);

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = false;

		assertEquals(expected, actual);

	}

	@Test
	void test5() {

		Filling[] vec = new Filling[5];



		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		vec[2] = Filling.LOVE;
		
		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	void test6() {

		Filling[] vec = new Filling[5];



		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		vec[0] = Filling.LOVE;
		
		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();

		boolean actual = bottleTest.isSingleFilling();
		boolean expected = true;

		assertEquals(expected, actual);
		
	}

}
