package model;

public class Automovel {
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private double valor;

	public Automovel(String placa, String modelo, String marca, int ano, double valor) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String toString() {
		return placa+":"+" "+modelo+", "+marca+", "+ano+", "+valor;
	}
	
	public String toFileString() {
		return placa + ";" + modelo + ";" + marca + ";" + ano + ";" + valor;
	}

	public static Automovel fromFileString(String line) {
		String[] data = line.split(";");
		if (data.length != 5) {
			throw new IllegalArgumentException("Linha de dados inválida: " + line);
		}
		try {
			String placa= data[0];
			String modelo= data[1];
			String marca= data[2];
			int ano = Integer.parseInt(data[3]);
			double valor = Double.parseDouble(data[4]);
			return new Automovel(placa, modelo, marca, ano, valor);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Formato numérico inválido em: " + line, e);
		}
	}
}
