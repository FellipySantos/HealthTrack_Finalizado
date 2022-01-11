package br.com.fiap.devpremium.enums;

public enum TipoUsuario {

	ATLETA(1, "A"),
	NUTRICIONISTA(2, "N"),
	TREINADOR(3, "T");
	
	private int codTipoUsuario;
	private String descricaoTipoUsuario;
	
	private TipoUsuario(int codTipoUsuario, String descricaoTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
		this.descricaoTipoUsuario = descricaoTipoUsuario;
	}

	
	public int getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(int codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

	public String getDescricaoTipoUsuario() {
		return descricaoTipoUsuario;
	}

	public void setDescricaoTipoUsuario(String descricaoTipoUsuario) {
		this.descricaoTipoUsuario = descricaoTipoUsuario;
	}
	
	
	public static TipoUsuario toEnum(Integer codTipoUsuario) {

		if(codTipoUsuario == null) {
			return null;
		}

		for(TipoUsuario x : TipoUsuario.values()) {
			if(codTipoUsuario.equals(x.getCodTipoUsuario())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codTipoUsuario);
	}
}
