package util;

import java.util.Scanner; 

public class OrdenamentoSimples {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int[] lista= new int[10];
		
		for(int i= 0; i<10; i++) {
			System.out.print("Digite um número: ");
			lista[i]= scanner.nextInt();
		}
		
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = 0; j < lista.length - 1 - i; j++) {
				if (lista[j] > lista[j + 1]) {
					int temp = lista[j];
					lista[j] = lista[j + 1];
					lista[j + 1] = temp;
				}
			}
		}
		
		System.out.print("Lista ordenada de maneira crescente: ");
		for(int num: lista) {
			System.out.print(num + " ");
		}
		
		
		scanner.close();
	}

}
