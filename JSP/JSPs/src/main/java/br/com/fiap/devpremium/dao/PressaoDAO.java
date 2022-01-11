package br.com.fiap.devpremium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.devpremium.exception.DBException;
import br.com.fiap.devpremium.singleton.ConexaoDAO;
import br.com.fiap.devpremium.bean.Pressao;

public class PressaoDAO {
	
    //Chama a conexão do ConexaoDAO
      private Connection conexao;
      


      	public static PressaoDAO getPressaoDAO() {
      		return new PressaoDAO();
      	}
      	
    	
         
   //Chama a classe de Imc, a conexão e seta as variáveis da classe no insert
      public void cadastrar(Pressao pressao) {
        PreparedStatement stmt = null;
    
        try {
          conexao = ConexaoDAO.obterConexao();
          String sql = "INSERT INTO tb_h_pressao (cd_pressao,dt_pressao,nr_sistolica,nr_diastolica,nr_bpm,tb_h_usuario_cd_usuario) VALUES (SQ_PRESSAO.NEXTVAL,?,?,?,?,2)";
          stmt = conexao.prepareStatement(sql);
          stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
          stmt.setInt(2, pressao.getSistolica());
          stmt.setInt(3, pressao.getDiastolica());
          stmt.setInt(4, pressao.getBpm());
    
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
      
      public List<Pressao> listar() {
    	    //Cria uma lista da Pressão
    	    List<Pressao> lista = new ArrayList<Pressao>();
    	    PreparedStatement stmt = null;
    	    ResultSet rs = null;
    	    //Realiza o select através da conexão
    	    try {
    	      conexao = ConexaoDAO.obterConexao();
    	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_pressao ORDER BY cd_pressao");
    	    rs = stmt.executeQuery();
    	  
    	    //Percorre todos os registros encontrados
    	    while (rs.next()) {
    	    int codigoPressao = rs.getInt("cd_pressao");
    	    String dataPressao = rs.getString("dt_pressao");
    	    int sistolica = rs.getInt("nr_sistolica");
    	    int diastolica = rs.getInt("nr_diastolica");
    	    int bpm = rs.getInt("nr_bpm");
   
    	    //Cria um objeto Pressão com as informações encontradas
    	        Pressao pressao = new Pressao(codigoPressao,dataPressao,sistolica,diastolica,bpm);
    	   //Adiciona o Pressão na lista
    	        lista.add(pressao);
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
      
      public Pressao buscar(int id) {
      	Pressao pressao = null;
      	PreparedStatement stmt = null;
      	ResultSet rs = null;
      	try {
      		conexao = ConexaoDAO.obterConexao();
      		stmt = conexao.prepareStatement("SELECT * FROM tb_h_pressao where cd_pressao = ?");
      		stmt.setInt(1, id);
      		rs = stmt.executeQuery();

      		if (rs.next()){
        	    int codigoPressao = rs.getInt("cd_pressao");
        	    String dataPressao = rs.getString("dt_pressao");
        	    int sistolica = rs.getInt("nr_sistolica");
        	    int diastolica = rs.getInt("nr_diastolica");
        	    int bpm = rs.getInt("nr_bpm");
        	    
      			pressao = new Pressao(codigoPressao,dataPressao,sistolica,diastolica,bpm);
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
      	return pressao;
      }
      
      	//Atualizar
  	public void atualizar(Pressao pressao) throws DBException {
  		PreparedStatement stmt = null;

  		try {
  			conexao = ConexaoDAO.obterConexao();
  			String sql = "UPDATE tb_h_pressao SET dt_pressao = ?, nr_sistolica = ?, nr_diastolica = ?, nr_bpm = ? WHERE cd_pressao = ?";
  			stmt = conexao.prepareStatement(sql);
            stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
            stmt.setInt(2, pressao.getSistolica());
            stmt.setInt(3, pressao.getDiastolica());
            stmt.setInt(4, pressao.getBpm());
  			stmt.setInt(5, pressao.getCodigoPressao());

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
  				String sql = "DELETE FROM tb_h_pressao WHERE cd_pressao = ?";
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