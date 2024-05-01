package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TableTestPourFromTo {

	private Table tableTeste;
	public String EOL = Table.EOL;
		

	@Test
	void test1() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		
		tableTeste.pourFromTo(0, 3);

		String actual = tableTeste.toString();
		
		String expected = 
				  "⬜    😒    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    " + EOL
				+ "😃    😡    😃    😃    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		
		tableTeste.pourFromTo(3, 7);
		tableTeste.pourFromTo(5, 7);
		
		String actual = tableTeste.toString();
		String expected = 
				    "😃    😒    😈    ⬜    😎    ⬜    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😒    😃    😈    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😎    😈    😃    😇    😇    😡    ⬜    ⬜    " + EOL
				  + "😉    😎    😇    😈    😃    😉    😇    😡    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		tableTeste.pourFromTo(3, 7);
		tableTeste.pourFromTo(5, 7);
		tableTeste.pourFromTo(7,3);
		
		String actual = tableTeste.toString();
		String expected = 
				    "😃    😒    😈    😡    😎    ⬜    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😒    😃    😈    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😎    😈    😃    😇    😇    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😇    😈    😃    😉    😇    😡    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}

	@Test
	void test4() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		
		tableTeste.pourFromTo(3, 7);
		tableTeste.pourFromTo(5, 7);
		
		
		tableTeste.pourFromTo(6, 7);
		
		
		String actual = tableTeste.toString();
		String expected = 
				    "😃    😒    😈    ⬜    😎    ⬜    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😒    😃    😈    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😎    😈    😃    😇    😇    😡    ⬜    ⬜    " + EOL
				  + "😉    😎    😇    😈    😃    😉    😇    😡    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}
	
	@Test
	void test5() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		
		tableTeste.pourFromTo(3, 7);
		tableTeste.pourFromTo(5, 7);
		
		tableTeste.pourFromTo(1, 6);
		
		String actual = tableTeste.toString();
		String expected = 
				    "😃    😒    😈    ⬜    😎    ⬜    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😒    😃    😈    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😎    😈    😃    😇    😇    😡    ⬜    ⬜    " + EOL
				  + "😉    😎    😇    😈    😃    😉    😇    😡    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}

}
