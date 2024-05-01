package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TableTestConstructors {

	private Table tableTeste;
	
	public String EOL = Table.EOL;
		

	@Test
	void testContrutor1() {
		
		Filling[] symbols = Filling.values();
//		System.out.println(Arrays.toString(symbols));
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		String actual = tableTeste.toString();
		
		String expected = 
				  "😃    😒    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    " + EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);

	}

	@Test
	void testContrutor2() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		String actual = tableTeste.toString();
		String expected = 
				    "😃    😒    😈    😡    😎    😡    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😒    😃    😈    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😎    😈    😃    😇    😇    ⬜    ⬜    ⬜    " + EOL
				  + "😉    😎    😇    😈    😃    😉    😇    ⬜    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}
	
	@Test
	void testContrutor3() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 7;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		String actual = tableTeste.toString();
		String expected = 
				      "😃    😈    😡    😃    😉    😡    😒    ⬜    ⬜    ⬜    " + EOL
				    + "😎    😈    😈    😎    😇    😇    😒    ⬜    ⬜    ⬜    " + EOL
				    + "😎    😈    😃    😡    😡    😉    😒    ⬜    ⬜    ⬜    " + EOL
				    + "😃    😈    😃    😉    😎    😃    😒    ⬜    ⬜    ⬜    " + EOL
				    + "😒    😎    😃    😇    😈    😎    😉    ⬜    ⬜    ⬜    " + EOL
				    + "😉    😇    😡    😉    😡    😇    😒    ⬜    ⬜    ⬜    " + EOL
				    + "😉    😒    😡    😎    😈    😇    😇    ⬜    ⬜    ⬜    " + EOL;

		assertEquals(expected, actual);
	}

}
