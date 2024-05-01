package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TableTestAddBottle {

	private Table tableTeste;
	public String EOL = Table.EOL;


	@Test
	void test1() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		Filling[] vec = new Filling[4];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		Bottle bottleTest = new Bottle(vec);

		tableTeste.addBottle(bottleTest);

		String actual = tableTeste.toString();
		String expected = 
				"😃    😒    😡    ⬜    ⬜    ⬜    😇    "+ Table.EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    😇    "+ Table.EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    😇    "+ Table.EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    😇    "+ Table.EOL
				;

		assertEquals(actual, expected);
	}

	@Test
	void test2() {

		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;


		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		Filling[] vec = new Filling[4];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Filling.ANGEL;
		}

		Bottle bottleTest = new Bottle(vec);

		tableTeste.addBottle(bottleTest);
		tableTeste.addBottle(bottleTest);

		String actual = tableTeste.toString();
		String expected = 
				"😃    😒    😡    ⬜    ⬜    ⬜    😇    😇    "+ Table.EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    😇    😇    "+ Table.EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    😇    😇    "+ Table.EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    😇    😇    "+ Table.EOL
				;

		assertEquals(actual, expected);
	}

	
	
}
