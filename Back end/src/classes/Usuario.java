package classes;

public class Usuario {
	private int id;
	private String login;
	private String senha;	
	private Cliente cliente;
	private Permissoes permissoes;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String login, String senha, Cliente cliente, Permissoes permissoes) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.cliente = cliente;
		this.permissoes = permissoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}
	
}
