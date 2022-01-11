package br.com.fiap.devpremium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.devpremium.exception.DBException;
import br.com.fiap.devpremium.singleton.ConexaoDAO;
import br.com.fiap.devpremium.bean.Imc;

public class ImcDAO {
	
    //Chama a conexão do ConexaoDAO
      private Connection conexao;
      

    	public static ImcDAO getImcDAO() {
    		return new ImcDAO();
    	}
    	
    
   //Chama a classe de Imc, a conexão e seta as variáveis da classe no insert
      public void cadastrar(Imc imc) {
        PreparedStatement stmt = null;
    
        try {
          conexao = ConexaoDAO.obterConexao();
          String sql = "INSERT INTO tb_h_imc (cd_imc,dt_imc,nr_peso,nr_altura,tb_h_usuario_cd_usuario) VALUES (SQ_IMC.NEXTVAL,?,?,?,2)";
          stmt = conexao.prepareStatement(sql);
          stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
          stmt.setDouble(2, imc.getPeso());
          stmt.setDouble(3, imc.getAltura());
    
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
      
      public List<Imc> listar() {
    	    //Cria uma lista de Imc
    	    List<Imc> lista = new ArrayList<Imc>();
    	    PreparedStatement stmt = null;
    	    ResultSet rs = null;
    	    //Realiza o select através da conexão
    	    try {
    	      conexao = ConexaoDAO.obterConexao();
    	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_imc ORDER BY cd_imc");
    	    rs = stmt.executeQuery();
    	  
    	    //Percorre todos os registros encontrados
    	    while (rs.next()) {
    	    int codigoImc = rs.getInt("cd_imc");
    	    String dataImc = rs.getString("dt_imc");
    	    Double peso = rs.getDouble("nr_peso");
    	    Double altura = rs.getDouble("nr_altura");
   
    	    //Cria um objeto Imc com as informações encontradas
    	        Imc imc = new Imc(codigoImc,dataImc,peso,altura);
    	   //Adiciona o treino na lista
    	        lista.add(imc);
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
      
      public Imc buscar(int id) {
      	Imc imc = null;
      	PreparedStatement stmt = null;
      	ResultSet rs = null;
      	try {
      		conexao = ConexaoDAO.obterConexao();
      		stmt = conexao.prepareStatement("SELECT * FROM tb_h_imc where cd_imc = ?");
      		stmt.setInt(1, id);
      		rs = stmt.executeQuery();

      		if (rs.next()){
        	    int codigoImc = rs.getInt("cd_imc");
        	    String dataImc = rs.getString("dt_imc");
        	    Double peso = rs.getDouble("nr_peso");
        	    Double altura = rs.getDouble("nr_altura");
        	    
      			imc = new Imc(codigoImc,dataImc,peso,altura);
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
      	return imc;
      }
      
      	//Atualizar
  	public void atualizar(Imc imc) throws DBException {
  		PreparedStatement stmt = null;

  		try {
  			conexao = ConexaoDAO.obterConexao();
  			String sql = "UPDATE tb_h_imc SET dt_imc = ?, nr_peso = ?, nr_altura = ? WHERE cd_imc = ?";
  			stmt = conexao.prepareStatement(sql);
            stmt.setTimestamp(1,new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
            stmt.setDouble(2, imc.getPeso());
            stmt.setDouble(3, imc.getAltura());
  			stmt.setInt(4, imc.getCodigoImc());

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
  				String sql = "DELETE FROM tb_h_imc WHERE cd_imc = ?";
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