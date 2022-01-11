package br.com.fiap.devpremium.bean;

import java.util.Calendar;

import br.com.fiap.devpremium.util.CriptografiaUtils;

	/**
	*
	* A classe Treinador salva os registros de cadastro do Treinador. Ela é uma classe entidade que busca herança com a classe Prestador (que busca herança com a classe Usuário).
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

public class Treinador extends Prestador {

	public Treinador() {};
	
	/**
	 *
	 * Construtor da classe Treinador
	 *
	 * @param userID codigo do Usuário
	 * @param dtNasc é a data de nascimento do usuário
	 * @param sexo do registro
	 * @param tipoUser é o tipo de conta do usuário
	 * @param cnpj da empresa do Treinador
	 * @param cref é o registro no Conselho Regional de Educação Física do treinador
	 *
	 */
	
	public String cref;
		
	public Treinador(int userID, String nome, Calendar dtNasc, String sexo, String email, String tipoUser, String cnpj, String cref, String senha) {
		
		super(userID, nome, dtNasc, sexo, email, tipoUser, cnpj,senha);
		
		this.cref = cref;

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
	
	public Calendar getdtNasc() {
		return dtNasc;
	}


	public void setdtNasc(Calendar dtNasc) {
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
	
	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCref() {
		return cref;
	}


	public void setCref(String cref) {
		this.cref = cref;
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