package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BottleTestPourOut {

	private Bottle bottleTest;
	
	
	public String empty = Table.EMPTY;
	public String EOL = Table.EOL;


	@Test
	void test1() {
		Filling[] vec = new Filling[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
//		System.out.println(bottleTest);
		
//		System.out.println("After pouring:");
		bottleTest.pourOut();
//	    System.out.println(bottleTest);

		bottleTest.pourOut();

		String actual = bottleTest.toString();
		String expected = empty + EOL
				+ empty + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇"+ EOL
				+ "😇"+ EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);
	}

	@Test
	void test2() {

		Filling[] vec = new Filling[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();

		String actual = bottleTest.toString();
		String expected = empty + EOL
				+ empty + EOL
				+ empty + EOL
                + empty + EOL
                + empty + EOL
                + empty + EOL
				+ empty + EOL;

		assertEquals(actual, expected);

	}

	@Test
	void test3() {

		Filling[] vec = new Filling[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();

		String actual = bottleTest.toString();
		String expected = empty + EOL
                + empty + EOL
                + empty + EOL
                + empty + EOL
                + empty + EOL
				+ "😇"+ EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);

	}

	
	@Test
	void test4() {

		Filling[] vec = new Filling[8];

		for (int i = 0; i < vec.length/2; i++) {
			vec[i] = Filling.LOVE;
		}
		for (int i = vec.length/2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();
		bottleTest.pourOut();


		String actual = bottleTest.toString();
		String expected = 
                  empty + EOL
                + empty + EOL
				+ "😍" + EOL
				+ "😍" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);

	}
	
	@Test
	void test5() {

		Filling[] vec = new Filling[8];

		for (int i = 0; i < vec.length/2; i++) {
			vec[i] = Filling.LOVE;
		}
		for (int i = vec.length/2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();

		String actual = bottleTest.toString();
		String expected = 
		        empty + EOL
	            + empty + EOL
                + empty + EOL
                + empty + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);

	}
	
	@Test
	void test6() {

		Filling[] vec = new Filling[8];

		for (int i = 0; i < vec.length/2; i++) {
			vec[i] = Filling.LOVE;
		}
		for (int i = vec.length/2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.pourOut();

		String actual = bottleTest.toString();
		String expected = 
				  empty + EOL
	            + empty + EOL
                + empty + EOL
                + empty + EOL
                + empty + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);

	}
}
