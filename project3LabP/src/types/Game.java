package types;

/**
 * Esta classe constrói um jogo de uma mesa com garrafas.
 * 
 * @author Rodrigo Frutuoso 61865
 */
public class Game {
	public static final String EOL = System.lineSeparator();

	private int score;
	private int jogadas;
	private Table jogo;

	/**
	 * Constrói um jogo em que os conteúdos das garrafas na mesa são symbols.
	 * 
	 * @param symbols             os símbolos dos conteúdos das garrafas
	 * @param numberOfUsedSymbols o número de símbolos a serem usados
	 * @param seed                a semente do gerador de aleatórios
	 * @param capacity            o tamanho das garrafas
	 */
	public Game(Filling[] symbols, int numberOfUsedSymbols, int seed, int capacity) {
		this.jogo = new Table(symbols, numberOfUsedSymbols, seed, capacity);
			if(isRoundFinished()) {
				startNewRound();//para ter a certeza que o jogo não começa terminado
			}
	}

	/**
	 * Constrói um jogo em que os conteúdos das garrafas na mesa são symbols, com um
	 * determinado score.
	 * 
	 * @param symbols             os símbolos dos conteúdos das garrafas
	 * @param numberOfUsedSymbols o número de símbolos a serem usados
	 * @param seed                a semente do gerador de aleatórios
	 * @param capacity            o tamanho das garrafas
	 * @param score               o score do utilizador
	 */
	public Game(Filling[] symbols, int numberOfUsedSymbols, int seed, int capacity, int score) {
		this(symbols, numberOfUsedSymbols, seed, capacity);
		this.score = score;
		if(isRoundFinished()) {
			startNewRound();//para ter a certeza que o jogo não começa terminado
		}
	}

    /**
     * Gera uma garrafa extra para ser usada na mesa como ajuda.
     * 
     * @return uma nova garrafa
     */
	public Bottle getNewBottle() {
		Bottle newBottle = new Bottle(jogo.getSizeBottles());
		jogo.addBottle(new Bottle(jogo.getSizeBottles()));
		return newBottle;
	}

	/**
	 * Efetua uma jogada vertendo o conteúdo da garrafa com o índice i para a
	 * garrafa com o índice j.
	 * 
	 * @param i indice do conteúdo da garrafa a mover
	 * @param j indice onde colocar o conteúdo da garrafa a mover
	 */
	public void play(int i, int j) {
		if (isValid(i, j)) {
			while (isValid(i, j)) {
				jogo.pourFromTo(i, j);
			}
			jogadas++;
			updateScore();
		}
	}

	/**
     * Indica se a ronda está acabada, ou seja, se todas as garrafas estão
     * totalmente cheias com um único conteúdo ou vazias.
     * 
     * @return true se o jogo já acabou, caso contrário retorna false
     */
	public boolean isRoundFinished() {
		return jogo.areAllFilled();
	}

	/**
	 * Gera uma nova mesa com novas garrafas
	 */
	public void startNewRound() {
		jogadas = 0;
		do {
		jogo.regenerateTable();
		}while(isRoundFinished());
	}

    /**
     * Obtém a pontuação atual do jogo.
     * 
     * @return a pontuação atual do jogo
     */
	public int score() {
		return score;
	}

    /**
     * Retorna o número de jogadas efetuadas até ao momento.
     * 
     * @return o número de jogadas
     */
	public int jogadas() {
		return jogadas;
	}

	   /**
     * Retorna a quantidade de garrafas na mesa.
     * 
     * @return a quantidade de garrafas
     */
	public int getNumberBottles() {
		return jogo.getNumberBottles();
	}

	/**
     * Verifica se uma jogada é válida.
	 * 
	 * @param i indice do conteúdo da garrafa a mover
	 * @param j indice onde colocar o conteúdo da garrafa a mover
	 * @return true se a jogada for válida, false caso contrário
	 */
	public boolean isValid(int i, int j) {
		return ((i >= 0 && i < getNumberBottles() && j >= 0 && j < getNumberBottles() && i != j)
				&& (jogo.isEmpty(j) || !jogo.isEmpty(i) && jogo.top(i) == jogo.top(j)));
	}

	/**
	 * Permite ao jogador obter uma ajuda criando uma nova garrafa vazia, resultando
	 * numa penalização de 100 pontos
	 * 
	 * @requires {@code score>=100}
	 */
	public void provideHelp() {
		getNewBottle();
		score -= 100;
	}

	/**
     * Atualiza a pontuação do jogador ao finalizar a ronda.
	 */
	public void updateScore() {
		if (isRoundFinished()) {
			if (jogadas <= 10) {
				score += 1000;
			} 
			else if (jogadas > 10 && jogadas <= 15) {
				score += 500;
			} 
			else if ((jogadas > 15 && jogadas <= 25)) {
				score += 200;
			} 
			else {
				score += 0;
			}

		}
	}

	/**
     * Retorna uma descrição textual do estado do jogo.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Score: " + score + EOL + jogo.toString());
		if (!isRoundFinished()) {
			sb.append("Status: The round is not finished." + EOL);
			sb.append(jogadas + " moves have been used until now." + EOL);
		} 
		else {
			sb.append("Status: This round is finished." + EOL);
			sb.append(jogadas + " moves were used." + EOL);
		}
		return sb.toString();
	}
}
