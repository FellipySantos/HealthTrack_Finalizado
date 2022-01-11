package br.com.fiap.devpremium.bean;

import java.util.Calendar;

	/**
	*
	* A classe Prestador salva os registros de cadastro do Prestador. Ela é uma classe abstrata que serve de herança para a classe Nutri e Treinador e busca herança com a classe Usuario.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/


public class Prestador extends Usuario {
	
	protected Prestador() {};
	
	/**
	 *
	 * Construtor da classe Prestador
	 *
	 * @param userID codigo do Usuário
	 * @param dtNasc é a data de nascimento do usuário
	 * @param sexo do registro
	 * @param tipoUser é o tipo de conta do usuário
	 * @param cnpj da empresa do Prestador
	 *
	 */
	
	public String cnpj;
	
	public Prestador(int userID, String nome, Calendar dtNasc, String sexo, String email, String tipoUser, String cnpj, String senha) {
		
		super(userID, nome, dtNasc, sexo, email, tipoUser,senha);
		
		this.cnpj = cnpj;
		
	}

}

