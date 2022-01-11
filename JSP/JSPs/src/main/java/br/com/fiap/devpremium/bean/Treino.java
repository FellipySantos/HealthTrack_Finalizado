package br.com.fiap.devpremium.bean;

/**
*
* A classe Treino salva os registros de cadastro do Treino do Usuário. Ela é uma classe entidade que registra descrição, quantidade de calorias, validade (periodo) e frequência do treino.
*
*
* @author DevPremium
*
* @version 1.0
*
*/

public class Treino implements Comparable <Treino> {
	
	private int codigoTreino;
	private String dataTreino;
	private String nome;
    private String descricao;
    private int qtdCal;
    private String validade;
    private String frequencia;
    
    public Treino() {}
    
    /**
     * Construtor da classe Treino
     * @param codigoTreino
     * @param dataTreino
     * @param nome
     * @param descricao
     * @param qtdCal
     * @param validade
     * @param frequencia
     */
    
    public Treino(int codigoTreino, String dataTreino, String nome, String descricao, int qtdCal, String validade, String frequencia) {
    	this.codigoTreino = codigoTreino;
    	this.dataTreino = dataTreino;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdCal = qtdCal;
		this.validade = validade;
		this.frequencia = frequencia;
	}
    
 
	public int getCodigoTreino() {
		return codigoTreino;
	}
	public void setCodigoTreino(int codigoTreino) {
		this.codigoTreino = codigoTreino;
	}
	public String getDataTreino() {
		return dataTreino;
	}

	public void setDataTreino(String dataTreino) {
		this.dataTreino = dataTreino;
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
    public String getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
    
    //Criado a string para retorna na classe de Teste

	@Override
	public String toString() {
		return "Treino [nome=" + nome + ", descricao=" + descricao + ", qtdCal=" + qtdCal + ", validade=" + validade
				+ ", frequencia=" + frequencia + "]";
	}
	
	//Criado o comparativo para classificar. O nome do Treino sendo igual, ele compara pela quantidade de calorias e classifica

	@Override
	public int compareTo(Treino newTreino) {
		
		int retorno = 0;
		
		if (this.nome.equals (newTreino.getNome())) {
			
			retorno = Integer.compare(this.qtdCal,newTreino.getQtdCal());
			
		} else {
			
			retorno = this.nome.compareTo( newTreino.getNome());
			
		}
		
		return retorno;
	}




    
    

}
