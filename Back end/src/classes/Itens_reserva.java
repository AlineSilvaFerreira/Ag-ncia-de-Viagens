package classes;

public class Itens_reserva {
	private int id;
	private int quantidade;
	private double valor;
	private Pacote pacote;
	private Reserva reserva;
	
	public Itens_reserva(){
		
	}
	
	public Itens_reserva(int id, int quantidade, Pacote pacote, Reserva reserva) {
		this.id = id;
		this.quantidade = quantidade;
		valorItens(pacote.calcularPromocao());
		this.pacote = pacote;
		this.reserva = reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}	
	
	public void valorItens(double preco) {
		this.valor = this.quantidade * preco;
		
	}
}

