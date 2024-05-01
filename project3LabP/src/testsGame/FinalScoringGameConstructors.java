package testsGame;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FinalScoringGameConstructors {

	private Game game;
	
	public String EOL = Table.EOL;
	
		

	@Test
	void testContrutor1() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize);

		String actual = game.toString();
		String expected = "Score: 0" + EOL +
				  "😃    😒    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    " + EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    " + EOL
				+ "Status: The round is not finished." + EOL
				+ "0 moves have been used until now." + EOL;

		assertEquals(expected, actual);

	}
	
	@Test
	void testContrutor2() {
		
		
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		int score  = 100;
		

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize, score);

		String actual = game.toString();
		String expected = "Score: 100" + EOL +
				  "😃    😒    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    " + EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    " + EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    " + EOL
				+ "Status: The round is not finished."+ EOL
				+ "0 moves have been used until now." + EOL;

		assertEquals(expected, actual);

	}

}
