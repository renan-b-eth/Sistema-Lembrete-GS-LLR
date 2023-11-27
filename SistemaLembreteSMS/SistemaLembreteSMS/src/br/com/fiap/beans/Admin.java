package br.com.fiap.beans;

public class Admin extends Usuario{
	
	private String emailAdmin, senhaAdmin;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String emailAdmin, String senhaAdmin) {
		super();
		this.emailAdmin = emailAdmin;
		this.senhaAdmin = senhaAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}
}
