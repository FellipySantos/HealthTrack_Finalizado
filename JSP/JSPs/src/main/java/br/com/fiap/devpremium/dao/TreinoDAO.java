package br.com.fiap.devpremium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.devpremium.exception.DBException;
import br.com.fiap.devpremium.singleton.ConexaoDAO;
import br.com.fiap.devpremium.bean.Treino;

public class TreinoDAO {

    //Chama a conex?o do ConexaoDAO
    private Connection conexao;
    
  	public static TreinoDAO getTreinoDAO() {
  		return new TreinoDAO();
  	}
  	
  
 //Chama a classe de Treino, a conex?o e seta as vari?veis da classe no insert
    public void cadastrar(Treino treino) {
      PreparedStatement stmt = null;
  
      try {
        conexao = ConexaoDAO.obterConexao();
        String sql = "INSERT INTO tb_h_treino (cd_treino,dt_treino,ds_nome,ds_descricao,nr_calorias,ds_validade,ds_frequencia,tb_h_usuario_cd_usuario) VALUES (SQ_TREINO.NEXTVAL,?,?,?,?,?,?,2)";
        stmt = conexao.prepareStatement(sql);
        stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
        stmt.setString(2, treino.getNome());
        stmt.setString(3, treino.getDescricao());
        stmt.setInt(4, treino.getQtdCal());
        stmt.setString(5, treino.getValidade());
        stmt.setString(6, treino.getFrequencia());
  
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
    
    public List<Treino> listar() {
  	    //Cria uma lista de treino
  	    List<Treino> lista = new ArrayList<Treino>();
  	    PreparedStatement stmt = null;
  	    ResultSet rs = null;
  	    //Realiza o select atrav?s da conex?o
  	    try {
  	      conexao = ConexaoDAO.obterConexao();
  	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_treino ORDER BY cd_treino");
  	    rs = stmt.executeQuery();
  	  
  	    //Percorre todos os registros encontrados
  	    while (rs.next()) {
  	    int codigoTreino = rs.getInt("cd_treino");
  	    String dataTreino = rs.getString("dt_treino");
  	    String nome = rs.getString("ds_nome");
  	    String descricao = rs.getString("ds_descricao");
  	    int qtdCal = rs.getInt("nr_calorias");
  	    String validade = rs.getString("ds_validade");
  	    String frequencia = rs.getString("ds_frequencia");
 
  	    //Cria um objeto Treino com as informa??es encontradas
  	        Treino treino = new Treino(codigoTreino,dataTreino,nome,descricao, qtdCal, validade,frequencia);
  	   //Adiciona o treino na lista
  	        lista.add(treino);
  	      }
  	    //Cria as exce??es 
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
    
    public Treino buscar(int id) {
    	Treino treino = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	try {
    		conexao = ConexaoDAO.obterConexao();
    		stmt = conexao.prepareStatement("SELECT * FROM tb_h_treino where cd_treino = ?");
    		stmt.setInt(1, id);
    		rs = stmt.executeQuery();

    		if (rs.next()){
    	  	int codigoTreino = rs.getInt("cd_treino");
    	  	String dataTreino = rs.getString("dt_treino");
    	  	String nome = rs.getString("ds_nome");
    	  	String descricao = rs.getString("ds_descricao");
    	  	int qtdCal = rs.getInt("nr_calorias");
    	  	String validade = rs.getString("ds_validade");
    	  	String frequencia = rs.getString("ds_frequencia");
      	    
    	  	treino = new Treino(codigoTreino,dataTreino,nome,descricao, qtdCal, validade,frequencia);
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
    	return treino;
    }
    
    	//Atualizar
	public void atualizar(Treino treino) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConexaoDAO.obterConexao();
			String sql = "UPDATE tb_h_treino SET dt_treino = ?, ds_nome = ?, ds_descricao = ?, nr_calorias = ?, ds_validade = ?, ds_frequencia = ? WHERE cd_treino = ?";
			stmt = conexao.prepareStatement(sql);
	        stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
	        stmt.setString(2, treino.getNome());
	        stmt.setString(3, treino.getDescricao());
	        stmt.setInt(4, treino.getQtdCal());
	        stmt.setString(5, treino.getValidade());
	        stmt.setString(6, treino.getFrequencia());
			stmt.setInt(7, treino.getCodigoTreino());

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
				String sql = "DELETE FROM tb_h_treino WHERE cd_treino = ?";
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