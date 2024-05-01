package testsBottle;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class BottleTestTop {

	private Bottle bottleTest;

	@Test
	public void test1() {
		Filling[] vec = new Filling[1];
		bottleTest = new Bottle(vec);
		assertThrows(
						EmptyStackException.class,
						() -> bottleTest.top(),
						"Expected top() to throw, but it didn't"
		);
	}

	@Test
	void test2() {

		Filling[] vec = new Filling[7];
		vec[0] = Filling.SMILE;

		bottleTest = new Bottle(vec);

//		System.out.println(bottleTest);

		Filling actual = bottleTest.top();
		Filling expected = Filling.SMILE;

		assertEquals(expected,actual);
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


		Filling actual = bottleTest.top();
		Filling expected = Filling.SMILE;

		assertEquals(expected,actual);
	}

	@Test
	void test4() {

		Filling[] vec = new Filling[5];
		vec[4] = Filling.LOVE;

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}
		bottleTest = new Bottle(vec);


		Filling actual = bottleTest.top();
		Filling expected = Filling.ANGEL;

		assertEquals(expected,actual);
	}

	@Test
	void test5() {

		Filling[] vec = new Filling[2];
		vec[1] = Filling.LOVE;
		vec[0] = Filling.ANGEL;

		bottleTest = new Bottle(vec);

		bottleTest.pourOut();

		Filling actual = bottleTest.top();
		Filling expected = Filling.LOVE;

		assertEquals(expected,actual);
	}

	@Test
	void test6() {

		Filling[] vec = new Filling[3];
		vec[1] = Filling.LOVE;
		vec[0] = Filling.ANGEL;



		bottleTest = new Bottle(vec);
		System.out.println(bottleTest);

		bottleTest.receive(Filling.ANGEL);

		Filling actual = bottleTest.top();
		Filling expected = Filling.ANGEL;

		assertEquals(expected,actual);
	}

}
