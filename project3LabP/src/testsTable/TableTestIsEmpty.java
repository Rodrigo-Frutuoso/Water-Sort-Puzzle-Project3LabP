package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TableTestIsEmpty {

	private Table tableTeste;
	public String EOL = Table.EOL;


	@Test
	void test1() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);



		boolean actual = tableTeste.isEmpty(2);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	void test2() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);


		boolean actual = tableTeste.isEmpty(3);
		boolean expected = true;



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



		boolean actual = tableTeste.isEmpty(0);
		boolean expected = false;

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



		boolean actual = tableTeste.isEmpty(3);
		boolean expected = false;

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
		tableTeste.pourFromTo(0,4);
		tableTeste.pourFromTo(0,5);
		tableTeste.pourFromTo(0,3);

		boolean actual = tableTeste.isEmpty(0);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	
}
