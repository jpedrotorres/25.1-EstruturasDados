import java.util.Scanner;

class Produto {
    private int id;
    private String nome;
    private int qtd;
    
    public Produto(int id, String nome, int qtd) {
        this.id= id;
        this.nome= nome;
        this.qtd= qtd;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome= nome;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd= qtd;
    }
}

class ListaArray {
    private Produto[] array;
    private int tamanho;
    
    public ListaArray (int capacidade) {
        this.array= new Produto[capacidade];
        this.tamanho= 0;
    }
    public void adicionarProduto (int id, String nome, int qtd) {
        if (tamanho == array.length) {
            System.out.println("Error: Lista cheia!");
            return;
        }
        
        array[tamanho++] = new Produto(id, nome, qtd);
    }
    public void removerProduto (int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
			System.out.println("Erro: Posição inválida!");
			return;
		}
		
		for (int i = posicao; i < tamanho - 1; i++) {
			array[i] = array[i + 1];
		}

		tamanho--;
    }
    public int pesquisar(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (id == array[i].getId()) {
                return i;
            }
        }
        
        return -1;
    }
    public int pesquisar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].getNome().equals(nome)) {
                return i;
            }
        }
        
        return -1;
    }
    public void imprimirLista() {
		System.out.print("Lista: ");
		for (int i = 0; i < tamanho; i++) {
			System.out.print("Id: "+ array[i].getId() + " - Nome: " + array[i].getNome() + " - Quantidade: " + array[i].getQtd() + " ");
		}

		System.out.println();
	}
}

public class ScannerCadastraProduto {
	public static void main(String[] args) {
	    Scanner scanner= new Scanner(System.in);
	    System.out.print("Digite o tamanho máximo da lista a ser criada: ");
	    int tamanhoLista= scanner.nextInt();
		
		ListaArray lista= new ListaArray(tamanhoLista);
		
		for(int i=0; i< tamanhoLista; i++) {
		    System.out.print("Digite o nome do produto: ");
		    String nome= scanner.next();
		    System.out.print("Digite a quantidade de produtos: ");
		    int qtd= scanner.nextInt();
		    
		    lista.adicionarProduto(i, nome, qtd);
		}
		lista.imprimirLista();
		lista.removerProduto(1);

		lista.imprimirLista();
		if (lista.pesquisar(2) != -1) {
		    System.out.println("O produto de ID '2' está presente");
		}
		else {
		    System.out.println("O produto de ID '2' NÃO está presente");
		}
		if (lista.pesquisar("Caminhão") != -1) {
		    System.out.println("O produto 'Caminhão' está presente");
		}
		else {
		    System.out.println("O produto 'Caminhão' NÃO está presente");
		}
		
		scanner.close();
	}
}
