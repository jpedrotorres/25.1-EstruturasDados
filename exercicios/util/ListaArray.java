package util;

class ListaSimples {
	private int[] array;
	private int tamanho;

	public ListaSimples(int capacidade) {
		this.array = new int[capacidade];
		this.tamanho = 0;
	}
	public void adicionar(int elemento) {
		if (tamanho == array.length) {
			System.out.println("Erro: Lista cheia!");
			return;
		}

		array[tamanho++] = elemento;
	}
	public void adicionar(int elemento, int posicao) {
		if (posicao < 0 || posicao > tamanho) {
			System.out.println("Erro: Posição inválida!");
			return;
		}
		if (tamanho == array.length) {
			System.out.println("Erro: Lista cheia!");
			return;
		}
		
		for (int i= posicao; i<= tamanho; i++) {
			int temp01= array[i];
			array[i] = elemento;
			array[i+1]= temp01;
		}
		
		tamanho++;
		return;
	}
	
	public void remover(int posicao) {
		if (posicao < 0 || posicao >= tamanho) {
			System.out.println("Erro: Posição inválida!");
			return;
		}

		for (int i = posicao; i < tamanho - 1; i++) {
			array[i] = array[i + 1];
		}

		tamanho--;
	}
	public void imprimirLista() {
		System.out.print("Lista: ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}
}

public class ListaArray {
	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples(5);
		lista.adicionar(10);
		lista.adicionar(20);
		lista.adicionar(30);
		lista.adicionar(40);
		lista.imprimirLista();
		lista.remover(1);
		lista.adicionar(50, 3);

		lista.imprimirLista();
	}
}
