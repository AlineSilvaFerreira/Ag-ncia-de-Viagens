package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Voo {
	private int id;
	private String origem;
	private String destino;
	private LocalDate dataIda;
	private LocalDate dataVolta;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Voo() {
		
	}
	
	public Voo(int id, String origem, String destino, String dataIda, String dataVolta) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.dataIda = LocalDate.parse(dataIda, formatter);
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDataIda() {
		return formatter.format(dataIda);
	}

	public void setDataIda(String dataIda) {
		this.dataIda = LocalDate.parse(dataIda, formatter);
	}

	public String getDataVolta() {
		return formatter.format(dataVolta);
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
	}

		
}
