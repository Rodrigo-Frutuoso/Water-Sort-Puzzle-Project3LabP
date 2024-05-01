package types;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack; //remover no caso de optar por uma classe de AED.

/**
 * Esta classe implementa a interface Iterable para representar uma garrafa.
 * 
 * @author Rodrigo Frutuoso 61865
 */
public class Bottle implements Iterable<Filling> {
	public static final int DEFAULT_CAPACITY = 5;
	public static final String EMPTY = "⬜";
	public static final String EOL = System.lineSeparator();

	private Stack<Filling> contents;
	private final int capacity;

	/**
	 * Constrói uma garrafa vazia com tamanho default
	 */
	public Bottle() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constrói uma garrafa vazia com a capacidade dada
	 * 
	 * @param capacity da garrafa
	 */
	public Bottle(int capacity) {
		this.capacity = capacity;
		this.contents = new Stack<>();
	}

	/**
	 * Constrói uma garrafa com a capacidade do vetor content fornecido. O primeiro
	 * filling do vetor é colocado no topo da garrafa.
	 * 
	 * @param content o vetor de fillings para criar a garrafa
	 */
	public Bottle(Filling[] content) {
		this(content.length);
		for (int i = this.capacity - 1; i >= 0; i--) {
			if (content[i] != null) {
				this.contents.push(content[i]);
			}
		}

	}

	/**
	 * Verifica se a garrafa está cheia.
	 * 
	 * @return true se a garrafa estiver cheia, false caso contrário
	 */
	public boolean isFull() {
		return capacity() == contents.size();
	}

	/**
	 * Verifica se a garrafa está vazia.
	 * 
	 * @return true se a garrafa estiver vazia, false caso contrário
	 */
	public boolean isEmpty() {
		return contents.size() == 0;
	}

	/**
	 * Obtém o gole está no topo
	 * 
	 * @return o gole que está no topo da garrafa
	 * @throws EmptyStackException se a garrafa estiver vazia
	 */
	public Filling top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return contents.peek();
	}

	/**
	 * Diz quantos goles ainda pode receber a garrafa
	 * 
	 * @return o número de goles que a garrafa pode receber
	 */
	public int spaceAvailable() {
		return capacity() - contents.size();
	}

	/**
	 * Executa a operação de retirar um único gole da garrafa
	 */
	public void pourOut() {
		if (!isEmpty()) {
			contents.pop();
		}
	}

	/**
	 * Executa a operação de adicionar um gole ao topo da garrafa e informa se a
	 * operação foi feita com sucesso.
	 * 
	 * @param s gole a ser adicionado no topo da garrafa
	 * @return true se o gole foi adicionado com sucesso, false caso contrário
	 */
	public boolean receive(Filling s) {
		if (!isFull() && (isEmpty() || s == contents.peek())) {
			contents.push(s);
			return true;
		}
		return false;
	}

	/**
	 * Diz qual o tamanho da garrafa
	 * 
	 * @return a capacidade da garrafa
	 */
	public int capacity() {
		return capacity;
	}

	/**
	 * Diz se a garrafa tem um só tipo de conteúdo
	 * 
	 * @return true se a garrafa contém apenas um tipo de gole, false caso contrário
	 */
	public boolean isSingleFilling() {
		if (isEmpty()) {
			return true;
		}
		Filling first = contents.peek();
		for (Filling filling : contents) {
			if (filling != first) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Devolve uma cópia do conteúdo da garrafa
	 * 
	 * @return array com o conteúdo da garrafa
	 */
	public Filling[] getContent() {
		return contents.toArray(new Filling[0]);
	}

	/**
	 * Retorna uma representação textual do conteúdo da garrafa, do topo para a
	 * base.
	 * 
	 * @return uma string representando o conteúdo da garrafa
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = capacity - 1; i >= 0; i--) {
			if (i >= contents.size()) {
				sb.append(EMPTY + EOL);
			} 
			else {
				sb.append(contents.get(i) + EOL);
			}
		}
		return sb.toString();
	}

	/**
	 * Retorna um iterador sobre o conteúdo da garrafa.
	 * 
	 * @return um iterador sobre os fillings da garrafa
	 */
	public Iterator<Filling> iterator() {
		return contents.iterator();
	}
}
