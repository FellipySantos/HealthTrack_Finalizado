package br.com.fiap.devpremium.bean;

	/**
	*
	* A classe Pressao salva os registros de pressão do Usuário. Ela é uma classe entidade que registra a pressão do Usuário.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

	public class Pressao {
		
		private int codigoPressao;
		private String dataPressao;
		public int sistolica;
		public int diastolica;
		public int bpm;
	
		/**
		 *
		 * Construtor da classe Pressao
		 * @return 
		 */

    
	/**
	 *
	 * Construtor da classe Pressao
	 * @param codigoPressao 
	 * @param dataPressao 
	 * @param sistolica 
	 * @param diastolica 
	 * @param bpm 
	 *
	 */
		
	public Pressao() {}
    
    public Pressao(int codigoPressao, String dataPressao, int sistolica, int diastolica, int bpm) {
    	
    	this.codigoPressao = codigoPressao;
    	this.dataPressao = dataPressao;
		this.sistolica = sistolica;
		this.diastolica = diastolica;
		this.bpm = bpm;
    }

	public int getCodigoPressao() {
		return codigoPressao;
	}

	public void setCodigoPressao(int codigoPressao) {
		this.codigoPressao = codigoPressao;
	}

	public String getDataPressao() {
		return dataPressao;
	}

	public void setDataPressao(String dataPressao) {
		this.dataPressao = dataPressao;
	}

	public int getSistolica() {
		return sistolica;
	}

	public void setSistolica(int sistolica) {
		this.sistolica = sistolica;
	}

	public int getDiastolica() {
		return diastolica;
	}

	public void setDiastolica(int diastolica) {
		this.diastolica = diastolica;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
    

}

