package br.com.fiap.devpremium.bean;

	/**
	*
	* A classe Imc salva os registros de medida do Usuário. Ela é uma classe entidade que registra o peso e altura do Usuário.
	*
	*
	* @author DevPremium
	*
	* @version 1.0
	*
	*/

	public class Imc {
		
		private int codigoImc;
		private String dataImc;
		public double peso;
		public double altura;
		
		
		/**
		 *
		 * Construtor da classe Imc
		 * @return 
		 */

    
	/**
	 *
	 * Construtor da classe Imc
	 * @param codigoImc 
	 * @param dataImc 
	 * @param altura 
	 * @param peso 
	 *
	 */
		
	public Imc() {}
    
    public Imc(int codigoImc, String dataImc, double peso, double altura) {
    	
    	setAltura(altura);
    	setPeso(peso);
    	this.codigoImc = codigoImc;
    	this.dataImc = dataImc;
    	this.peso = peso;
		this.altura = altura;
		
    }
    
    /**
     * Método responsável por retornar o IMC
     */
    
    @Override
    public String toString() {
        return "IMC: \n altura=" + altura + ", peso=" + peso + "\n Imc"+CalculaIMC(peso,altura);
    }
    
	public String getDataImc() {
		return dataImc;
	}

	public void setDataImc(String dataImc) {
		this.dataImc = dataImc;
	}

	public int getCodigoImc() {
		return codigoImc;
	}

	public void setCodigoImc(int codigoImc) {
		this.codigoImc = codigoImc;
	}

	public double getAltura() {
			return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
		
		/**
		 * Cálculo e condições do IMC
		 * @param peso
		 * @param altura
		 * @return
		 */
		
	    private String CalculaIMC(double peso, double altura) {
	    	double imc = peso/(altura*altura);
	        String grupo;
	        if(imc<18.5) {
	            grupo = "Abaixo do peso";
	        }
	        else if(imc<25) {
	            grupo = "Peso normal";
	        }
	        else if(imc<30) {
	            grupo = "Sobrepeso";
	        }
	        else if(imc<35) {
	            grupo = "Obesidade Grau I";
	        }
	        else if(imc<40) {
	            grupo = "Obesidade Grau II";
	        }
	        else {
	            grupo = "Obesidade Grau III ou morbida";
	        }
	        return ("Seu IMC é: "+imc+" Você está no grupo:"+grupo) ;

	    }
	    

		
		
		



}
