package classes;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
	private int id;
	private String tipoPagamento;
	private double 	valor;
	private Usuario usuario;
	private List<Itens_reserva> itens = new ArrayList<Itens_reserva>();
	
	public Reserva() {
		
	}
	
	public Reserva(int id, String tipoPagamento, Usuario usuario) {
		this.id = id;
		this.tipoPagamento = tipoPagamento;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public double getValor() {
		return valorTotal();
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Itens_reserva> getItens() {
		return itens;
	}

	public void setItens(List<Itens_reserva> itens) {
		this.itens = itens;
	}

	public double valorTotal() {
		for (int i = 0; i < itens.size(); i++) {
			this.valor += itens.get(i).getValor();
		}
		return this.valor;
	}
	
}
