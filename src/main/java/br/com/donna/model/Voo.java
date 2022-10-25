package br.com.donna.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Voo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String origem;
	
	@Column(nullable = false)
	private String destino;
	
	@Column(name = "data_ida", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataIda;
	
	@Column(name = "data_volta", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVolta;

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

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataIda, dataVolta, destino, id, origem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		return Objects.equals(dataIda, other.dataIda) && Objects.equals(dataVolta, other.dataVolta)
				&& Objects.equals(destino, other.destino) && id == other.id && Objects.equals(origem, other.origem);
	}

	@Override
	public String toString() {
		 StringBuilder vooCompleto = new StringBuilder();
	        vooCompleto.append(origem)
	                        .append(", ")
	                        .append(destino)
	                        .append(", ")
	                        .append(dataIda)
	                        .append(", ")
	                        .append(dataVolta);

	        return vooCompleto.toString();
	}
	
}
