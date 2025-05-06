package controle;

class Produto {
    private int[] codigo;
    private String[] nome;
    private double[] valor;
    
    public Produto(int[] codigo, String[] nome, double[] valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public int[] getCodigo() {
        return codigo;
    }

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }

    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public double[] getValor() {
        return valor;
    }

    public void setValor(double[] valor) {
        this.valor = valor;
    }
}

public class OrdenaProduto {
	 public static void main(String[] args) {
	        int[] codigo = {105, 101, 110, 102, 109, 106, 108, 103, 107, 104};
	        String[] nome = {"Teclado", "Mouse", "Notebook", "Monitor", "Webcam", "Caixa Som", "Cabo USB", "Pen Drive", "HD Externo", "Mousepad"};
	        double[] valor = {129.90, 59.90, 3500.00, 899.00, 199.90, 89.90, 25.00, 49.90, 320.00, 29.90};

	        Produto produto = new Produto(codigo, nome, valor);
	        System.out.println("Produtos antes da ordenação:");
	        exibirProdutos(produto);
	        
	        ordenarPorCodigo(produto);
	        System.out.println("\nProdutos ordenados por código:");
	        exibirProdutos(produto);
	        
	        ordenarPorValor(produto);
	        System.out.println("\nProdutos ordenados por valor:");
	        exibirProdutos(produto);
	    }

    private static void ordenarPorCodigo(Produto produto) {
        for (int i = 0; i < produto.getCodigo().length - 1; i++) {
            for (int j = 0; j < produto.getCodigo().length - 1 - i; j++) {
                if (produto.getCodigo()[j] > produto.getCodigo()[j + 1]) {
                    trocarCod(produto.getCodigo(), j, j + 1);
                    trocarNome(produto.getNome(), j, j + 1);
                    trocarValor(produto.getValor(), j, j + 1);
                }
            }
        }
    }

    private static void ordenarPorValor(Produto produto) {
        for (int i = 0; i < produto.getValor().length - 1; i++) {
            for (int j = 0; j < produto.getValor().length - 1 - i; j++) {
                if (produto.getCodigo()[j] > produto.getValor()[j + 1]) {
                    trocarValor(produto.getValor(), j, j + 1);
                    trocarCod(produto.getCodigo(), j, j + 1);
                    trocarNome(produto.getNome(), j, j + 1);
                }
            }
        }
    }

    private static void trocarCod(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    private static void trocarValor(double[] arr, int i, int j) {
        double aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    private static void trocarNome(String[] arr, int i, int j) {
        String aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    private static void exibirProdutos(Produto produto) {
        for (int i = 0; i < produto.getCodigo().length; i++) {
            System.out.printf("Código: %d | Nome: %-10s | Valor: R$ %.2f\n", produto.getCodigo()[i], produto.getNome()[i], produto.getValor()[i]);
        }
    }
}



