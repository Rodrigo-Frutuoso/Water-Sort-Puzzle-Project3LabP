package testsTable;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TableTestGetSizeBottle {

	private Table tableTeste; 
		

	@Test
	void test1() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		int actual = tableTeste.getSizeBottles();
		int expected = 4;
				
		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 7;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		int actual = tableTeste.getSizeBottles();
		int expected = 7;
				
		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed = 10;
		int bootleSize = 5;
		

		tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		
		int actual = tableTeste.getSizeBottles();
		int expected = 5;
				
		assertEquals(expected, actual);
	}
	
}
