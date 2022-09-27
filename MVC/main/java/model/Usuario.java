package model;

public class Usuario {
	private int id;
	private String login;
	private String senha;	
	private Cliente cliente;
	private Permissao permissao;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String login, String senha, Cliente cliente, Permissao permissao) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.cliente = cliente;
		this.permissao = permissao;
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
}
