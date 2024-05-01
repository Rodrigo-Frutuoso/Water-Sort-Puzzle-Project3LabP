package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class TableTestTop {

	private Table tableTeste;
	public String EOL = Table.EOL;


	@Test
	void test1() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);



		Filling actual = tableTeste.top(2);
		Filling expected = Filling.FURIOUS;

		assertEquals(expected, actual);
	}

	@Test
	void test2() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		Filling actual = tableTeste.top(0);
		Filling expected = Filling.SMILE;


		assertEquals(expected, actual);
	}

	@Test
	void test4() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 2;
		int bootleSize = 4;

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		tableTeste.pourFromTo(0,3);

		Filling actual = tableTeste.top(0);
		Filling expected = Filling.FURIOUS;

		assertEquals(expected, actual);
	}

	@Test
	void test5() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 2;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);


		tableTeste.pourFromTo(0,3);



		Filling actual = tableTeste.top(3);
		Filling expected = Filling.SAD;

		assertEquals(expected, actual);
	}

	@Test
	void test6() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 2;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);


		tableTeste.pourFromTo(0,3);
		tableTeste.pourFromTo(1,4);



		Filling actual = tableTeste.top(4);
		Filling expected = Filling.SAD;

		assertEquals(expected, actual);
	}

	@Test
	public void test7() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 2;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);


		assertThrows(
				EmptyStackException.class,
				() -> tableTeste.top(4),
				"Expected top() to throw, but it didn't"
				);
	}

	@Test
	void test8() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 2;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		tableTeste.pourFromTo(0,3);
		tableTeste.pourFromTo(0,4);
		tableTeste.pourFromTo(0,5);
		tableTeste.pourFromTo(0,3);
		

		assertThrows(
				EmptyStackException.class,
				() -> tableTeste.top(0),
				"Expected top() to throw, but it didn't"
				);
	}
}
