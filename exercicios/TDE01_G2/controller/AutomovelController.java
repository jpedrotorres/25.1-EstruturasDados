package controller;

import model.Automovel;
import model.AutomovelRepository;

import java.io.*;
import java.util.ArrayList;

public class AutomovelController {
	private ArrayList<Automovel> automoveis;
	private AutomovelRepository automovelRepository;

	public AutomovelController() {
		this.automovelRepository = new AutomovelRepository();
		this.automoveis = new ArrayList<>(automovelRepository.carregarArquivo());
	}

	public ArrayList<Automovel> listarAutomovel() {
		return new ArrayList<>(automoveis);
	}

	public void adicionarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
		for (Automovel automovel : automoveis) {
			if (automovel.getPlaca().equals(placa)) {
				System.out.println("Placa já cadastrada no sistema!");
				return;
			}
		}
		
		Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
		automoveis.add(automovel);
		automovelRepository.salvarArquivo(automoveis);
	}

	public boolean alterarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
		Automovel automovel = buscarAutomovelPorPlaca(placa);
		if (automovel != null) {
			automovel.setModelo(modelo);
			automovel.setMarca(marca);
			automovel.setAno(ano);
			automovel.setValor(valor);
			automovelRepository.salvarArquivo(automoveis);
			return true;
		}
		return false;
	}
	
	public void consultarAutomovel(String placa) {
		Automovel automovel = buscarAutomovelPorPlaca(placa);
		if (automovel != null) {
			System.out.println(automovel.toString());
			return;
		}
		
		System.out.println("Veículo não encontrado!");
		return;
	}

	public boolean excluirAutomovel(String placa) {
		Automovel automovel = buscarAutomovelPorPlaca(placa);
		if (automovel != null) {
			automoveis.remove(automovel);
			automovelRepository.salvarArquivo(automoveis);
			return true;
		}
		return false;
	}

	private Automovel buscarAutomovelPorPlaca(String placa) {
		for (Automovel automovel : automoveis) {
			if (automovel.getPlaca().equals(placa)) {
				return automovel;
			}
		}
		return null;
	}
}