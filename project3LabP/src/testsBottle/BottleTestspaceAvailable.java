package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BottleTestspaceAvailable {

	private Bottle bottleTest;

	
	@Test
	void test1() {

		Filling[] vec = new Filling[7];

		bottleTest = new Bottle(vec);

		int actual = bottleTest.spaceAvailable();
		int expected = 7;

		assertEquals(expected, actual);

	}
	
	@Test
	void test2() {

		Filling[] vec = new Filling[7];
		vec[0] = Filling.SMILE;
		
		bottleTest = new Bottle(vec);

		
		int actual = bottleTest.spaceAvailable();
		int expected = 6;

		assertEquals(expected, actual);

	}
	
	@Test
	void test3() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.SMILE;
		vec[1] = Filling.SMILE;
		vec[2] = Filling.SMILE;
		vec[3] = Filling.SMILE;
		vec[4] = Filling.SMILE;
		
		bottleTest = new Bottle(vec);

		
		int actual = bottleTest.spaceAvailable();
		int expected = 0;

		assertEquals(expected, actual);

	}
	
	@Test
	void test4() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.SMILE;
		vec[1] = Filling.SMILE;
		vec[2] = Filling.SMILE;
		vec[3] = Filling.SMILE;
		vec[4] = Filling.SMILE;
		
		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		
		int actual = bottleTest.spaceAvailable();
		int expected = 1;

		assertEquals(expected, actual);

	}
	
	@Test
	void test5() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.SMILE;
		vec[1] = Filling.SMILE;
		vec[2] = Filling.SMILE;
		vec[3] = Filling.SMILE;
		
		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		
		
		int actual = bottleTest.spaceAvailable();
		int expected = 2;

		assertEquals(expected, actual);

	}
	
	@Test
	void test6() {

		Filling[] vec = new Filling[5];
		vec[0] = Filling.SMILE;
		vec[1] = Filling.SMILE;
		vec[2] = Filling.SMILE;
		vec[3] = Filling.SMILE;
		
		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		
		bottleTest.receive(vec[2]);
		
		int actual = bottleTest.spaceAvailable();
		int expected = 1;
		

		assertEquals(expected, actual);

	}
	
	@Test
	void test7() {

		
		bottleTest = new Bottle();

		
		int actual = bottleTest.spaceAvailable();
		int expected = 5;
		

		assertEquals(expected, actual);

	}
	
	@Test
	void test8() {

		
		bottleTest = new Bottle();

		bottleTest.receive(Filling.ANGEL);
		
		int actual = bottleTest.spaceAvailable();
		int expected = 4;
		

		assertEquals(expected, actual);

	}

}
