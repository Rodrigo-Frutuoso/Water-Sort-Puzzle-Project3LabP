package types;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta classe é responsável por iniciar e controlar o jogo "Water Sort Puzzle".
 * Permite ao jogador interagir com o jogo através de entrada pelo terminal.
 * 
 * @author Rodrigo Frutuoso 61865
 */
public class Main {
	private static final String EOL = System.lineSeparator();
	private static final int DEFAULT_SEED = 1;
	private static final int MINIMUM_NUMBER = 2;
	private static final int MAXIMUM_NUMBER = 8;

	private static Scanner sc;
	private static Game game;
	private static int numberOfUsedSymbols;
	private static int capacity;

	public static void main(String[] args) {
		Boolean restart = false;
		int counterDeRondas = 1;
		sc = new Scanner(System.in);
		bemVindo();
		settings();
		sc.nextLine();

		game = new Game(Filling.values(), numberOfUsedSymbols, DEFAULT_SEED, capacity, 0);
		do {
			tabela(counterDeRondas);
			play(sc);

			if (game.isRoundFinished()) {
				System.out.println("Bem jogado!!");
				System.out.println(game.toString());
				System.out.println("Quer jogar novamente? Yes/No");
				String novamente = sc.next();
				if (novamente.toUpperCase().contains("YES")) {
					sc.nextLine();
					settings();
					game = new Game(Filling.values(), numberOfUsedSymbols, DEFAULT_SEED, capacity, game.score());;
					sc.nextLine();
				} 
				else {
					System.out.println("Obrigado por jogar!");
					restart = true;
				}
			}
		} while (!restart);

		sc.close();
	}

	/**
	 * Método responsável por controlar a jogada do jogador.
	 */
	private static void play(Scanner sc) {
		boolean found = false;
		String input = "";
		do {
			input = sc.nextLine();
			if (input.toUpperCase().contains("AJUDA")) {
				if (game.score() >= 100) {
					System.out.println("Nova garrafa adicionada à mesa.");
					game.provideHelp();
				} 
				else {
					System.out.println("Não é possível adicionar nova garrafa, pois não tem pontos suficientes");
				}
				found = true;
				break;
			} 
			else {
				String[] indices = input.split(" ");
				try {
					int i = Integer.parseInt(indices[0]);
					int j = Integer.parseInt(indices[1]);
					if (game.isValid(i, j)) {
						game.play(i, j);
						found = true;
					} 
					else {
						System.out.println("Jogada inválida. Por favor, insira novamente.");
					}
				} 
				catch (EmptyStackException e) {
					System.out.println("Garrafa vazia. Por favor, insira novamente.");
				} 
				catch (Exception e) {
					System.out.println("Jogada inválida. Por favor, insira novamente.");
				}
			}
		} while (!found);
	}

	/**
	 * Método utilitário para obter entrada de número inteiro dentro de um intervalo
	 * específico.
	 * 
	 * @param minimo Valor mínimo permitido.
	 * @param maximo Valor máximo permitido.
	 * @param prompt Mensagem para onde é utilizada este função.
	 * @return O número inteiro fornecido pelo jogador dentro do intervalo
	 *         especificado.
	 */

	private static int getIntInput(int minimo, int maximo, String prompt) {
		int numero = 0;

		try {
			numero = sc.nextInt();
			if (numero >= minimo) {
				if (numero > maximo) {
					return maximo;
				}
				return numero;
			} 
			else {
				System.out.println("Número Inválido para a " + prompt
						+ ". Insira um número inteiro positivo maior ou igual a " + minimo + ".");
			}
		} 
		catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Formato Inválido para a " + prompt
					+ ". Insira um número inteiro positivo maior ou igual a " + minimo + ".");
			sc.nextLine();
		}
		return getIntInput(minimo, maximo, prompt);

	}

	/**
	 * Método para exibir a mensagem de boas-vindas e as regras do jogo.
	 */
	private static void bemVindo() {
		System.out.println("Bem vindo ao jogo Water Sort Puzzle!" + EOL);
		System.out.println(
				"* O jogo consiste em ordenar emojis em garrafas, de modo que cada garrafa contenha apenas um tipo de emoji."
						+ EOL + "* O jogador pode realizar movimentos para transferir emojis entre as garrafas." + EOL
						+ "* Pode solicitar uma nova garrafa como ajuda, mas isso resultará em uma penalização de 100 pontos"
						+ EOL);
		System.out.println("Regras:" + EOL + "-Número de garrafas e a capacidade tem de ser superiores ou iguais a 2"
				+ EOL
				+ "-Para realizar uma jogada vai ser pedido dois índices, uma para a garrafa que quer mover o emoji, e outro para onde quer colocar esse emoji "
				+ EOL
				+ "-Se precisar de uma nova garrafa, escreva 'ajuda', quando lhe for pedido o índice da garrafa a mover"
				+ EOL);
	}

	/**
	 * Método para exibir a tabela do jogo.
	 */
	private static void tabela(int j) {
		System.out.println();
		for (int i = 0; i < game.getNumberBottles() * 5 + 4; i++) {
			System.out.print("-");

		}
		System.out.println("");
		for (int i = 0; i < game.getNumberBottles() * 5 / 2 - 2; i++) {
			System.out.print(" ");
		}
		System.out.print(" Ronda " + j + " ");
		System.out.println();

		for (int k = 0; k < game.getNumberBottles() * 5 + 4; k++) {
			System.out.print("-");
		}
		System.out.print(EOL);

		for (int i = 0; i < game.getNumberBottles(); i++) {
			System.out.print(i + "     ");
		}
		System.out.println();
		System.out.println(game.toString());
		if (game.score() >= 100) {
			System.out.println("Se precisar de mais de uma garrafa escreva 'ajuda'");
		}
		System.out.println("Escolha sua jogada (no formato 'i j', onde i e j são os índices das garrafas):");
	}

	/**
	 * 
	 * Método para configurar o número de garrafas e capacidade do jogo.
	 */
	private static void settings() {
		System.out.println("Insira a quantidade de garrafas, pelo menos " + MINIMUM_NUMBER + " , para jogar:");
		numberOfUsedSymbols = getIntInput(MINIMUM_NUMBER, MAXIMUM_NUMBER, "quantidade de garrafas");
		sc.nextLine();
		System.out.println("Insira a capacidade, pelo menos " + MINIMUM_NUMBER + ", para as garrafas:");
		capacity = getIntInput(MINIMUM_NUMBER, MAXIMUM_NUMBER, "capacidade para as garrafas");
	}
}