package br.com.fiap.devpremium.bean;

import java.util.Calendar;

import br.com.fiap.devpremium.util.CriptografiaUtils;

	/**
	*
	* A classe Nutri salva os registros de cadastro do Nutricionista. Ela ? uma classe entidade que busca heran?a com a classe Prestador (que busca heran?a com a classe Usu?rio).
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

public class Nutri extends Prestador {

	public Nutri() {};
	
	/**
	 *
	 * Construtor da classe Nutri
	 *
	 * @param userID codigo do Usu?rio
	 * @param dtNasc ? a data de nascimento do usu?rio
	 * @param sexo do registro
	 * @param tipoUser ? o tipo de conta do usu?rio
	 * @param cnpj da empresa do Nutricionista
	 * @param crn ? o registro no Conselhos Regional de Nutricionistas
	 *
	 */
		
	public String crn;
		
	public Nutri(int userID, String nome, Calendar dtNasc, String sexo, String email, String tipoUser, String cnpj, String crn, String senha) {
		
		super(userID, nome, dtNasc, sexo, email, tipoUser, cnpj,senha);
		
		this.crn = crn;

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
	
	public String getCrn() {
		return crn;
	}


	public void setCrn(String crn) {
		this.crn = crn;
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
