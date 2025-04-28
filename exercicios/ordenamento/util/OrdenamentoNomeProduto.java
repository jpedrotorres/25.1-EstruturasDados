package util;

import java.util.Scanner;

class Produto {
	private String nome;
	private int preco;
	
	public Produto(String nome, int preco) {
		this.nome= nome;
		this.preco= preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome= nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public void setPreco(int preco) {
		this.preco= preco;
	}
}

public class OrdenamentoNomeProduto {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		Produto[] produtos= new Produto[10];
		
		for(int i= 0; i<10; i++) {
			System.out.print("Digite o nome do produto: ");
			String nome= scanner.next();
			System.out.print("Digite o preço: ");
			int preco= scanner.nextInt();
			
			produtos[i]= new Produto(nome, preco);
		}
		
		for (int i = 0; i < produtos.length - 1; i++) {
			for (int j = 0; j < produtos.length - 1 - i; j++) {
				if (produtos[j].getPreco() > produtos[j + 1].getPreco()) {
					Produto temp = produtos[j];
					produtos[j] = produtos[j + 1];
					produtos[j + 1] = temp;
				}
			}
		}
		
		System.out.println("Lista ordenada de maneira crescente: ");
		for(Produto pr: produtos) {
			System.out.println(pr.getNome() + ": R$" + pr.getPreco());
		}
		
		scanner.close();

	}

}
