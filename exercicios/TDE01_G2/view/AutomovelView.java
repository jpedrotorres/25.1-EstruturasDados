package view;

import controller.AutomovelController;
import model.Automovel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AutomovelView {
	private AutomovelController controller;
	private Scanner scanner;

	public AutomovelView(AutomovelController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

	public void exibirMenu() {
		int opcao;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Adicionar Automovel");
			System.out.println("2. Listar Automovel");
			System.out.println("3. Alterar Automovel");
			System.out.println("4. Consultar Automovel");
			System.out.println("5. Excluir Automovel");
			System.out.println("0. Sair");
			opcao = capturarInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1 -> adicionarAutomovel();
			case 2 -> listarAutomovel();
			case 3 -> alterarAutomovel();
			case 4 -> consultarAutomovel();
			case 5 -> excluirAutomovel();
			case 0 -> System.out.println("Encerrando o programa.");
			default -> System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 0);
	}

	private void adicionarAutomovel() {
		int id = capturarInteiro("ID do Produto: ");
		String nome = capturarString("Nome do Produto: ");
		double valor = capturarDouble("Valor do Produto: ");
		controller.adicionarProduto(id, nome, valor);
		System.out.println("Produto adicionado com sucesso!");
	}

	private void listarAutomovel() {
		controller.listarProdutos().forEach(produto -> System.out.println(
				"ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Valor: R$ " + produto.getValor()));
	}

	private void alterarAutomovel() {
		int id = capturarInteiro("ID do Produto a alterar: ");
		String novoNome = capturarString("Novo Nome: ");
		double novoValor = capturarDouble("Novo Valor: ");
		if (controller.alterarProduto(id, novoNome, novoValor)) {
			System.out.println("Produto alterado com sucesso!");
		} else {
			System.out.println("Produto com ID " + id + " não encontrado.");
		}
	}
	
	private void consultarAutomovel() {
		
	}

	private void excluirAutomovel() {
		String placa = capturarString("Placa do automóvel a excluir: ");
		if (controller.excluirAutomovel(placa)) {
			System.out.println("Automovel excluído com sucesso!");
		} else {
			System.out.println("Automovel com placa " + placa + " não encontrado.");
		}
	}

	private int capturarInteiro(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
				scanner.nextLine();
			}
		}
	}

	private double capturarDouble(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número decimal.");
				scanner.nextLine();
			}
		}
	}

	private String capturarString(String mensagem) {
		System.out.print(mensagem);
		return scanner.next();
	}
}
