package model;
public class Pacote {

	private int id;
	private double valor;
	private int desconto;
	private Hospedagem hospedagem;
	private Voo voo;

	public Pacote() {

	}

	public Pacote(int id, double valor, int desconto, Hospedagem hospedagem, Voo voo) {
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

	public Hospedagem getHospedagem() {
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

	public double calcularPromocao() {
		double valorFinal = this.valor - (this.valor / 100 * this.desconto);
		return valorFinal;
	}

}

