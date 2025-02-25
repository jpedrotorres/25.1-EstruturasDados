package util;

class ListaString {
	private String[] array;
	private int tamanho;

	public ListaString(int capacidade) {
		this.array = new String[capacidade];
		this.tamanho = 0;
	}
	public void adicionar(String elemento) {
		if (tamanho == array.length) {
			System.out.println("Erro: Lista cheia!");
			return;
		}

		array[tamanho++] = elemento;
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
	public int pesquisar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equals(nome)) {
                return i;
            }
        }
        return -1; // Retorna -1 caso o nome não seja encontrado
    }
	public void imprimirLista() {
		System.out.print("Lista de Nomes: ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}
}

public class ListaArrayString {
	public static void main(String[] args) {
		ListaString lista = new ListaString(7);
		lista.adicionar("Ana");
		lista.adicionar("Bruno");
		lista.adicionar("Carlos");
		lista.adicionar("João");
		lista.adicionar("Miguel");
		lista.adicionar("Maria Vitoria");
		lista.adicionar("Mathias");

		int busca= lista.pesquisar("João");
		if (busca!=-1) {
			 System.out.println("O nome 'João' foi encontrado na posição " + busca);
		}
		else {
			System.out.println("O nome 'João' não foi encontrado na lista.");
		}
		
		lista.imprimirLista();
		lista.remover(1);
		lista.imprimirLista();
	}
}
