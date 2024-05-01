package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BottleTestIsReceive {

	private Bottle bottleTest;

	public String empty = Table.EMPTY;
	public String EOL = Table.EOL;

	@Test
	void test1() {

		Filling[] vec = new Filling[7];


		bottleTest = new Bottle(vec);
		bottleTest.receive(Filling.ANGEL);
		bottleTest.receive(Filling.ANGEL);
		bottleTest.receive(Filling.ANGEL);


		boolean actual = bottleTest.receive(Filling.ANGEL);
		boolean expected = true;

		assertEquals(actual, expected);

	}

	@Test
	void test2() {

		Filling[] vec = new Filling[7];

		vec[6] = Filling.LOVE;

		for (int i = 0; i < vec.length-1; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);

		
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
				+ "😍" + EOL;

		assertEquals(expected, actual);
	}

	@Test
	void test3() {

		Filling[] vec = new Filling[7];

		vec[6] = Filling.LOVE;
		vec[5] = Filling.LOVE;

		for (int i = 0; i < vec.length-2; i++) {
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
		bottleTest.receive(Filling.LOVE);

		String actual = bottleTest.toString();
		String expected = empty + EOL
				+ empty + EOL
				+ empty + EOL
				+ empty + EOL
				+ empty + EOL
				+ empty + EOL
				+ "😍" + EOL;

		assertEquals(actual, expected);

	}

	@Test
	void test4() {

		Filling[] vec = new Filling[7];

		vec[0] = Filling.LOVE;
		vec[1] = Filling.LOVE;

		for (int i = 2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		bottleTest.pourOut();
		bottleTest.pourOut();
		bottleTest.receive(Filling.LOVE);


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
	void test5() {
		Filling[] vec = new Filling[7];

		vec[0] = Filling.LOVE;
		vec[1] = Filling.LOVE;

		for (int i = 2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);
		bottleTest.pourOut();

		bottleTest.receive(Filling.LOVE);


		String actual = bottleTest.toString();
		String expected = 
				  "😍" + EOL
				+ "😍" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇"+ EOL
				+ "😇"+ EOL
				+ "😇" + EOL;

		assertEquals(actual, expected);

	}

	@Test
	void test6() {



		Filling[] vec = new Filling[7];

		vec[6] = Filling.LOVE;
		vec[5] = Filling.LOVE;

		for (int i = 0; i < vec.length-2; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		bottleTest.pourOut();

		boolean actual = bottleTest.receive(Filling.ANGEL);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	void test7() {



		Filling[] vec = new Filling[7];

		vec[0] = Filling.LOVE;
		vec[1] = Filling.LOVE;

		for (int i = 2; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		bottleTest.pourOut();

		bottleTest.receive(Filling.ANGEL);

		String actual = bottleTest.toString();
		String expected = empty + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL
				+ "😇" + EOL;

		assertEquals(expected, actual);
	}

	@Test
	void test8() {



		Filling[] vec = new Filling[7];

		vec[6] = Filling.LOVE;
		vec[5] = Filling.LOVE;

		for (int i = 0; i < vec.length-2; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);

		bottleTest.pourOut();
		bottleTest.pourOut();

		
		boolean actual = bottleTest.receive(Filling.LOVE);
		boolean expected = false;

		assertEquals(expected, actual);
	}	

	@Test
	void test9() {

		Filling[] vec = new Filling[7];

		vec[6] = Filling.LOVE;
		vec[5] = Filling.LOVE;

		for (int i = 0; i < vec.length-2; i++) {
			vec[i] = Filling.ANGEL;
		}

		bottleTest = new Bottle(vec);



		boolean actual = bottleTest.receive(Filling.LOVE);
		boolean expected = false;

		assertEquals(expected, actual);
	}

}
