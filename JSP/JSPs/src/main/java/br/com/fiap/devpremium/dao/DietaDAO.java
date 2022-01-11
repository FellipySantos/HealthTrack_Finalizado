package br.com.fiap.devpremium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.devpremium.exception.DBException;
import br.com.fiap.devpremium.singleton.ConexaoDAO;
import br.com.fiap.devpremium.bean.Dieta;

public class DietaDAO {

    //Chama a conexão do ConexaoDAO
    private Connection conexao;
    
  	public static DietaDAO getDietaDAO() {
  		return new DietaDAO();
  	}
  	
  
 //Chama a classe de Dieta, a conexão e seta as variáveis da classe no insert
    public void cadastrar(Dieta dieta) {
      PreparedStatement stmt = null;
  
      try {
        conexao = ConexaoDAO.obterConexao();
        String sql = "INSERT INTO tb_h_dieta (cd_dieta,dt_dieta,ds_nome,ds_descricao,nr_calorias,ds_validade,tb_h_usuario_cd_usuario) VALUES (SQ_DIETA.NEXTVAL,?,?,?,?,?,2)";
        stmt = conexao.prepareStatement(sql);
        stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
        stmt.setString(2, dieta.getNome());
        stmt.setString(3, dieta.getDescricao());
        stmt.setInt(4, dieta.getQtdCal());
        stmt.setString(5, dieta.getValidade());
  
        stmt.executeUpdate();
      } catch (SQLException e) {
      	System.err.println("Erro ao realizar select");
        e.printStackTrace();
      } finally {
        try {
          stmt.close();
          conexao.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    
    //Selecionar
    
    public List<Dieta> listar() {
  	    //Cria uma lista de treino
  	    List<Dieta> lista = new ArrayList<Dieta>();
  	    PreparedStatement stmt = null;
  	    ResultSet rs = null;
  	    //Realiza o select através da conexão
  	    try {
  	      conexao = ConexaoDAO.obterConexao();
  	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_dieta ORDER BY cd_dieta");
  	    rs = stmt.executeQuery();
  	  
  	    //Percorre todos os registros encontrados
  	    while (rs.next()) {
  	    int codigoDieta = rs.getInt("cd_dieta");
  	    String dataDieta = rs.getString("dt_dieta");
  	    String nome = rs.getString("ds_nome");
  	    String descricao = rs.getString("ds_descricao");
  	    int qtdCal = rs.getInt("nr_calorias");
  	    String validade = rs.getString("ds_validade");
 
  	    //Cria um objeto Treino com as informações encontradas
  	        Dieta dieta = new Dieta(codigoDieta,dataDieta,nome,descricao, qtdCal, validade);
  	   //Adiciona o treino na lista
  	        lista.add(dieta);
  	      }
  	    //Cria as exceções 
  	    } catch (SQLException e) {
  	      e.printStackTrace();
  	    }finally {
  	      try {
  	        stmt.close();
  	        rs.close();
  	        conexao.close();
  	      } catch (SQLException e) {
  	        e.printStackTrace();
  	      }
  	    }
  	    return lista;
  	  }
    
    
    //Buscar
    
    public Dieta buscar(int id) {
    	Dieta dieta = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	try {
    		conexao = ConexaoDAO.obterConexao();
    		stmt = conexao.prepareStatement("SELECT * FROM tb_h_dieta where cd_dieta = ?");
    		stmt.setInt(1, id);
    		rs = stmt.executeQuery();

    		if (rs.next()){
    	  	int codigoDieta = rs.getInt("cd_dieta");
    	  	String dataDieta = rs.getString("dt_dieta");
    	  	String nome = rs.getString("ds_nome");
    	  	String descricao = rs.getString("ds_descricao");
    	  	int qtdCal = rs.getInt("nr_calorias");
    	  	String validade = rs.getString("ds_validade");
      	    
    	  	dieta = new Dieta(codigoDieta,dataDieta,nome,descricao, qtdCal, validade);
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			stmt.close();
    			rs.close();
    			conexao.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return dieta;
    }
    
    	//Atualizar
	public void atualizar(Dieta dieta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoDAO.obterConexao();
			String sql = "UPDATE tb_h_dieta SET dt_dieta = ?, ds_nome = ?, ds_descricao = ?, nr_calorias = ?, ds_validade = ? WHERE cd_dieta = ?";
			stmt = conexao.prepareStatement(sql);
	        stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
	        stmt.setString(2, dieta.getNome());
	        stmt.setString(3, dieta.getDescricao());
	        stmt.setInt(4, dieta.getQtdCal());
	        stmt.setString(5, dieta.getValidade());
			stmt.setInt(6, dieta.getCodigoDieta());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void remover(int codigo) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConexaoDAO.obterConexao();
				String sql = "DELETE FROM tb_h_dieta WHERE cd_dieta = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao remover.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

}
