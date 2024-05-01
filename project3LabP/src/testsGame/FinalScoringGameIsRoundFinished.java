package testsGame;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FinalScoringGameIsRoundFinished {

	private Game game;
	
	public String EOL = Table.EOL;
	
		
	@Test
	void test1() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		boolean actual = game.isRoundFinished();
		boolean expected = false;

		assertEquals(expected, actual);

	}

	
	@Test
	void test2() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;

		
		

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		
		
		game.play(2,3);
		game.play(0,2);
		game.play(0,4);
		game.play(2,0);
		game.play(1,4);
		
		boolean actual = game.isRoundFinished();
		boolean expected = false;


		assertEquals(expected, actual);

	}
	
	@Test
	void test3() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;

		
		
		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		
		
		game.play(2,3);
		game.play(0,2);
		game.play(0,4);
		game.play(2,0);
		game.play(1,4);
		game.play(1,3);
		game.play(1,4);
		game.play(1,3);
		
		boolean actual = game.isRoundFinished();
		boolean expected = true;


		assertEquals(expected, actual);

	}
}
