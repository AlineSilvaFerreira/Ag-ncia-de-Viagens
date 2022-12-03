package br.com.donna.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pacote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false)
	private int desconto;
	
	@Lob
	private byte[] imagem;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hospedagem",nullable = false)
	private Hospedagem hospedagem;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_voo",nullable = false)
	private Voo voo;
	
	public Pacote() {
		
	}

	public Pacote(int id, double valor, int desconto, Hospedagem hospedagem, Voo voo) {
		super();
		this.id = id;
		this.valor = valor;
		this.desconto = desconto;
		this.hospedagem = hospedagem;
		this.voo = voo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public 	Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	
	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public double calcularPromocao() {
		double valorFinal = this.valor - (this.valor / 100 * this.desconto);
		return valorFinal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desconto, hospedagem, id, valor, voo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		return desconto == other.desconto && Objects.equals(hospedagem, other.hospedagem) && id == other.id
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor)
				&& Objects.equals(voo, other.voo);
	}

	@Override
	public String toString() {
		return "Pacote [id=" + id + ", valor=" + valor + ", desconto=" + desconto + ", hospedagem=" + hospedagem
				+ ", voo=" + voo + ", calcularPromocao()=" + calcularPromocao() + "]";
	}

		
}
