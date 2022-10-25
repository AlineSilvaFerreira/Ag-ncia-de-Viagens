package br.com.donna.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false, unique = true)
	private String cpf;	
	
	@Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
	private UF estado;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String rua;
	@Column(nullable = false)
	private int numero;
	@Column(nullable = false)
	private String cep;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, String telefone, String cpf, UF estado, String cidade, String bairro,
			String rua, int numero, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public UF getEstado() {
		return estado;
	}
	public void setEstado(UF estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cpf, estado, id, nome, numero, rua, telefone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(estado, other.estado) && id == other.id && Objects.equals(nome, other.nome)
				&& numero == other.numero && Objects.equals(rua, other.rua) && Objects.equals(telefone, other.telefone);
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", estado=" + estado
				+ ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", cep=" + cep
				+ "]";
	}
	
	

}
