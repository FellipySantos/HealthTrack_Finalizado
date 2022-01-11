package br.com.fiap.devpremium.bean;

	/**
	*
	* A classe Dieta salva os registros de cadastro da Dieta do Usuário. Ela é uma classe entidade que registra descrição, quantidade de calorias e validade (periodo) da dieta.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

	public class Dieta {
		
		private int codigoDieta;
		private String dataDieta;
		public String nome;
		public String descricao;
		public int qtdCal;
		public String validade;

    public Dieta() {}
    
	/**
	 *
	 * Construtor da classe Dieta
	 *
	 * @param codigoDieta
	 * @param dataDieta
	 * @param nome da dieta
	 * @param descricao da dieta
	 * @param qtdCal são as calorias da dieta
	 * @param validade e periodo da dieta
	 *
	 */
    
    public Dieta(int codigoDieta, String dataDieta, String nome, String descricao, int qtdCal,String validade) {
    	
    	this.codigoDieta = codigoDieta;
    	this.dataDieta = dataDieta;
    	this.nome = nome;
    	this.descricao = descricao;
    	this.qtdCal = qtdCal;
    	this.validade = validade;
    	
    }
    
	public int getCodigoDieta() {
		return codigoDieta;
	}

	public void setCodigoDieta(int codigoDieta) {
		this.codigoDieta = codigoDieta;
	}

	public String getDataDieta() {
		return dataDieta;
	}

	public void setDataDieta(String dataDieta) {
		this.dataDieta = dataDieta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdCal() {
		return qtdCal;
	}

	public void setQtdCal(int qtdCal) {
		this.qtdCal = qtdCal;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}


}

