package testsGame;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FinalScoringGamePlay {

	
	
	public String EOL = Table.EOL;
	
		

	@Test
	void test1() {
		
		Game game;
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		game.play(2,3);
		
		
		String actual = game.toString();
		String expected = "Score: 0" + EOL +
				  "😃    😒    ⬜    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😡    ⬜    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😒    😃    😡    ⬜    ⬜    " + EOL
				+ "😃    😡    😃    😡    ⬜    ⬜    " + EOL
				+ "Status: The round is not finished." + EOL
				+ "1 moves have been used until now." + EOL;

		assertEquals(expected, actual);

	}
	
	@Test
	void test2() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		
		Game game;

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		game.play(2,3);
		game.play(0,2);
		game.play(0,4);
		game.play(2,0);
		game.play(1,4);
		game.play(1,3);
		game.play(1,4);
		game.play(1,3);
		
		
		String actual = game.toString();
		String expected = "Score: 1000" + EOL +
				    "😃    ⬜    ⬜    😡    😒    ⬜    " + EOL
				  + "😃    ⬜    ⬜    😡    😒    ⬜    " + EOL
				  + "😃    ⬜    ⬜    😡    😒    ⬜    " + EOL
				  + "😃    ⬜    ⬜    😡    😒    ⬜    " + EOL
				+ "Status: This round is finished." + EOL
				+ "8 moves were used." + EOL;

		assertEquals(expected, actual);

	}

}
