package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutomovelRepository {
	private final String ARQUIVOAUTOMOVEL = "automovel.txt";

	public void salvarArquivo(List<Automovel> automoveis) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVOAUTOMOVEL))) {
			for (Automovel automovel : automoveis) {
				writer.write(automovel.toFileString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao salvar os automóveis: " + e.getMessage());
		}
	}

	public List<Automovel> carregarArquivo() {
		List<Automovel> automoveis = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVOAUTOMOVEL))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				automoveis.add(Automovel.fromFileString(linha));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de automóveis não encontrado. Será criado ao salvar novos veículos.");
		} catch (IOException e) {
			System.out.println("Erro ao carregar automóveis: " + e.getMessage());
		}
		return Collections.unmodifiableList(automoveis);
	}
}
