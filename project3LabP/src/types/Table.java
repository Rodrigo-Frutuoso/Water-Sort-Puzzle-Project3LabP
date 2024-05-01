package types;

import java.util.Arrays;
import java.util.Random;

/**
 * Esta classe representa uma mesa de garrafas.
 * 
 * @author Rodrigo Frutuoso 61865
 */
public class Table {
	public static final String EMPTY = "⬜";
	public static final String EOL = System.lineSeparator();
	public static final int DIFFICULTY = 3; // grau de dificuldade
	public static final int DEFAULT_BOTTLE_CAPACITY = 5; // tamanho por defeito das garrafas

	private Bottle[] table;
	private final Filling[] symbols;
	private final int capacity;
	private final Random rd;

	/**
	 * Constrói uma mesa cujas garrafas estão preenchidas com elementos de symbols,
	 * que corresponde a uma representação vetorial do enumerado.
	 * 
	 * @param symbols             todos os símbolos possíveis de usar no jogo
	 * @param numberOfUsedSymbols número de símbolos a ser usados
	 * @param seed                para gerar o conteúdo das garrafas de forma
	 *                            aleatória, escolhendo entre os símbolos possíveis
	 * @param capacity            capacidade máxima das garrafas
	 */
	public Table(Filling[] symbols, int numberOfUsedSymbols, int seed, int capacity) {
		int minimo = Math.min(numberOfUsedSymbols, symbols.length);
		this.table = new Bottle[minimo + DIFFICULTY];
		this.symbols = Arrays.copyOf(symbols, minimo);
		rd = new Random(seed);
		this.capacity = capacity;
		regenerateTable();
	}

	/**
	 * Constroí uma nova mesa de garrafas com o mesmo esquema do construtor
	 */
	public void regenerateTable() {
		int[] counter = new int[symbols.length];
		for (int i = 0; i < table.length; i++) {
			Filling[] simbolos = new Filling[capacity];
			if (i < table.length - DIFFICULTY) {
				for (int j = capacity - 1; j >= 0; j--) {
					int indice;
					do {
						indice = rd.nextInt(symbols.length);
					} while (counter[indice] == capacity);
					simbolos[j] = symbols[indice];
					counter[indice]++;
				}
			}
			table[i] = new Bottle(simbolos);
		}
	}

	/**
	 * Diz se a garrafa com índice i desta mesa é composta por um só tipo de
	 * conteúdo
	 * 
     * @param i o índice da garrafa
     * @return true se essa garrafa é composta por um só tipo, se não false
	 */
	public boolean singleFilling(int i) {
		return table[i].isSingleFilling();
	}

	/**
	 * Diz se a garrafa com índice i desta mesa está vazia
	 * 
     * @param i o índice da garrafa
	 * @return true se essa garrafa está vazia, se não false
	 */
	public boolean isEmpty(int i) {
		return table[i].isEmpty();
	}

	/**
	 * Diz se a garrafa com índice i desta mesa está cheia
	 * 
     * @param i o índice da garrafa
	 * @return true se essa garrafa está cheia, se não false
	 */
	public boolean isFull(int i) {
		return table[i].isFull();
	}

	/**
	 * Diz se todas as garrafas não vazias estão totalmente cheias com um só tipo de
	 * conteúdo
	 * 
	 * @return true todas as garrafas estão totalmente cheias com um só tipo, se não
	 *         false
	 */
	public boolean areAllFilled() {
		for (Bottle bottle : table) {
			if (!bottle.isEmpty() && (!bottle.isFull() || !bottle.isSingleFilling())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Concretiza a ação de verter um único gole da garrafa no índice i para a
	 * garrafa no índice j
	 * 
	 * @param i gole da garrafa a mover
	 * @param j novo local desse gole i
	 */
	public void pourFromTo(int i, int j) {
		if (table[j].receive(table[i].top())) {
			table[i].pourOut();
		}
	}

	/**
	 * Adiciona uma nova garrafa ao conjunto de garrafas da mesa
	 * 
     * @param bottle a garrafa a adicionar
	 */

	public void addBottle(Bottle bottle) {
		table = Arrays.copyOf(table, table.length + 1);
		table[table.length - 1] = bottle;
	}

	/**
     * Obtém a capacidade das garrafas da mesa.
	 * 
	 * @return a capacidade das garrafas
	 */
	public int getSizeBottles() {
		return capacity;
	}

	/**
     * Obtém a quantidade de garrafas na mesa.
	 * 
	 * @return quantidade de garrafas
	 */
	public int getNumberBottles() {
		return table.length;
	}

	/**
	 * Quando a garrafa não está vazia, diz qual o tipo de gole que se encontra no
	 * topo da garrafa no índice i
	 * 
     * @param i o índice da garrafa
	 * @return o gole que está no topo dessa garrafa i
	 */
	public Filling top(int i) {
		return table[i].top();
	}

	/**
     * Retorna uma descrição textual do conteúdo da mesa.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = capacity - 1; i >= 0; i--) {
			for (Bottle bottle : table) {
				if (i < bottle.getContent().length) {
					sb.append(bottle.getContent()[i] + "    ");
				} 
				else {
					sb.append(EMPTY + "    ");
				}
			}
			sb.append(EOL);
		}
		return sb.toString();
	}
}
