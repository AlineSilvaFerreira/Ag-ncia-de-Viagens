package br.com.donna.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hospedagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String incluso;
	
	@Column(nullable = false)
	private int diarias;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIncluso() {
		return incluso;
	}

	public void setIncluso(String incluso) {
		this.incluso = incluso;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(diarias, id, incluso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		return diarias == other.diarias && id == other.id && Objects.equals(incluso, other.incluso);
	}

	@Override
	public String toString() {
		return "Hospedagem [id=" + id + ", incluso=" + incluso + ", diarias=" + diarias + "]";
	}

	
}
