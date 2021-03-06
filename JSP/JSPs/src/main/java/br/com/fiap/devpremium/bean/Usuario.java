package br.com.fiap.devpremium.bean;

import java.util.Calendar;

import br.com.fiap.devpremium.util.CriptografiaUtils;

	/**
	*
	* A classe Usu?rio salva os registros de cadastro do Usu?rio. Ela ? uma classe abstrata que serve de heran?a para a classe Prestador e Atleta.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

	public class Usuario {
	
		protected int userID;
		protected String nome;
		protected Calendar dtNasc;
		protected String sexo;
		protected String email;
		protected String tipoUser;
		protected String senha;

    public Usuario() {}
    
	/**
	 *
	 * Construtor da classe Usu?rio
	 *
	 * @param userID codigo do Usu?rio
	 * @param dtNasc ? a data de nascimento do usu?rio
	 * @param sexo do registro
	 * @param tipoUser ? o tipo de conta do usu?rio
	 *
	 */
    
    public Usuario(int userID, String nome, Calendar dtNasc, String sexo,  String email, String tipoUser,String senha) {
    	
    	this.userID = userID;
    	this.nome = nome;
    	this.dtNasc = dtNasc;
    	this.sexo = sexo;
    	this.email = email;
    	this.tipoUser = tipoUser;
    	setSenha(senha);  	
    }
    
    

	public Usuario(String email2, String senha2) {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    

}