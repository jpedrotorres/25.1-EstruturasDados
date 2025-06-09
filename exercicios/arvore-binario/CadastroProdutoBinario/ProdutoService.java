import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto novo) {
        produtos.add(novo);
        Collections.sort(produtos); // Mantém a lista ordenada por id
    }

    public Produto buscarPorId(int id) {
        int inicio = 0;
        int fim = produtos.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Produto atual = produtos.get(meio);

            if (atual.getId() == id) {
                return atual;
            } else if (atual.getId() < id) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null; // Produto não encontrado
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }
}
