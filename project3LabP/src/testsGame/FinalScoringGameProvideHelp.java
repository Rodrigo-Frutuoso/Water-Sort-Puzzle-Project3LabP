package testsGame;

import types.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FinalScoringGameProvideHelp {

	private Game game;

	public String EOL = Table.EOL;


	@Test
	void test1() {


		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		int score  = 1000;

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize, score);

		game.provideHelp();

		String actual = game.toString();
		String expected = "Score: 900" + EOL
				+ "😃    😒    😡    ⬜    ⬜    ⬜    ⬜    "+EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    ⬜    "+EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    ⬜    "+EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    ⬜    "+EOL
				+ "Status: The round is not finished." + EOL
				+ "0 moves have been used until now."+EOL;

		assertEquals(expected, actual);

	}


	@Test
	void test2() {
		Filling[] symbols = Filling.values();
		int numberOfUsedSymbols = 3;
		int seed =1;
		int bootleSize = 4;
		int score  = 1000;

		game = new Game(symbols, numberOfUsedSymbols, seed, bootleSize, score);

		game.provideHelp();
		game.provideHelp();
		game.provideHelp();
		game.provideHelp();
		game.provideHelp();
		

		String actual = game.toString();
		String expected = 
				"Score: 500" + EOL
				+ "😃    😒    😡    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    "+ EOL
				+ "😒    😡    😡    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    "+ EOL
				+ "😒    😒    😃    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    "+ EOL
				+ "😃    😡    😃    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    ⬜    "+ EOL
				+ "Status: The round is not finished."+ EOL
				+ "0 moves have been used until now." + EOL;

		assertEquals(expected, actual);


	}

}
