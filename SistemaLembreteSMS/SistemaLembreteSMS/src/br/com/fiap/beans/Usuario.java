package br.com.fiap.beans;

public class Usuario {
	
	private String nomeUsuario, senhaUsuario, emailUsuario, loginUsuario;
	
	public Usuario() {
		super();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public Usuario(String nomeUsuario, String senhaUsuario, String emailUsuario, String loginUsuario) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
		this.loginUsuario = loginUsuario;
	}
}
