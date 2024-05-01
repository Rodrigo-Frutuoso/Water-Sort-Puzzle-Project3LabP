package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TableTestAreAllFilled {

	private Table tableTeste; 
	public String EOL = Table.EOL;
		

	@Test
	void test1() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		boolean actual = tableTeste.areAllFilled();
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

		boolean actual = tableTeste.areAllFilled();
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 10;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		
		boolean actual = tableTeste.areAllFilled();
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
		tableTeste.pourFromTo(0,4);
		tableTeste.pourFromTo(0,5);
		
		
		boolean actual = tableTeste.areAllFilled();
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
		
		boolean actual = tableTeste.singleFilling(3);
		boolean expected = true;

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
		
		
		boolean actual = tableTeste.areAllFilled();
		boolean expected = false;

		assertEquals(expected, actual);
	}
	
	
}
