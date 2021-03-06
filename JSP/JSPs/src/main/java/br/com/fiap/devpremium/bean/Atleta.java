package br.com.fiap.devpremium.bean;

import java.util.Calendar;

import br.com.fiap.devpremium.util.CriptografiaUtils;

	/**
	*
	* A classe Atleta salva os registros de cadastro do Atleta. Ela ? uma classe entidade que busca heran?a com a classe Usuario.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

	public class Atleta extends Usuario {
		
	    public Usuario usuario;
		public String cpf;
		
		public Atleta() {}
		
		
		/**
		 *
		 * Construtor da classe Atleta
		 *
		 * @param userID codigo do Usu?rio
		 * @param dtNasc ? a data de nascimento do usu?rio
		 * @param sexo do registro
		 * @param tipoUser ? o tipo de conta do usu?rio
		 * @param cpf ? o Cadastro de Pessoas F?sicas do usu?rio
		 *
		 */
		
		public Atleta(int userID, String nome, Calendar dtNasc, String sexo, String email, String tipoUser, String cpf, String senha) {
			
			super(userID, nome, dtNasc, sexo, email, tipoUser, senha);
			
			this.cpf = cpf;
			
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
		
		
		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
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

