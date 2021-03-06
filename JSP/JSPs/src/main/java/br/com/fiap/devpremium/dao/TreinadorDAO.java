package br.com.fiap.devpremium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.devpremium.exception.DBException;
import br.com.fiap.devpremium.singleton.ConexaoDAO;
import br.com.fiap.devpremium.bean.Treinador;

public class TreinadorDAO {
	
    //Chama a conex?o do ConexaoDAO
      private Connection conexao;
      

    	public static TreinadorDAO getTreinadorDAO() {
    		return new TreinadorDAO();
    	}
    	
    
   //Chama a classe de Treinador, a conex?o e seta as vari?veis da classe no insert
      public void cadastrar(Treinador treinador) {
        PreparedStatement stmt = null;
    
        try {
          conexao = ConexaoDAO.obterConexao();
          String sql = "INSERT INTO tb_h_usuario (cd_usuario,ds_nome,dt_nascimento,ds_sexo, ds_email, ds_tipo_usuario, ds_cpf, ds_cnpj, ds_crn, ds_cref, ds_senha) VALUES (SQ_USUARIO.NEXTVAL,?,?,?,?,'T',0,?,0,?,?,?)";
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, treinador.getNome());
          java.sql.Date data = new java.sql.Date(treinador.getDtNasc().getTimeInMillis());
          stmt.setDate(2, data);
          stmt.setString(3, treinador.getSexo());
          stmt.setString(4, treinador.getEmail());
          stmt.setString(5, treinador.getCnpj());
          stmt.setString(6, treinador.getCref());
          stmt.setString(7, treinador.getSenha());
    
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
      
      public List<Treinador> listar() {
    	    //Cria uma lista de Treinador
    	    List<Treinador> lista = new ArrayList<Treinador>();
    	    PreparedStatement stmt = null;
    	    ResultSet rs = null;
    	    //Realiza o select atrav?s da conex?o
    	    try {
    	      conexao = ConexaoDAO.obterConexao();
    	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_usuario WHERE ds_tipo_usuario = 'T' ORDER BY cd_usuario");
    	    rs = stmt.executeQuery();
    	  
    	    //Percorre todos os registros encontrados
    	    while (rs.next()) {
    	    int userID = rs.getInt("cd_usuario");
    	    String nome = rs.getString("ds_nome");
    	    java.sql.Date data = rs.getDate("dt_nascimento");
    	    Calendar dtNasc = Calendar.getInstance();
    	    dtNasc.setTimeInMillis(data.getTime());
    	    String sexo = rs.getString("ds_sexo");
    	    String email = rs.getString("ds_email");
    	    String tipoUser = rs.getString("ds_tipo_usuario");
    	    String cnpj = rs.getString("ds_cnpj");
    	    String cref = rs.getString("ds_cref");
    	    String senha = rs.getString("ds_senha");
   
    	    //Cria um objeto Imc com as informa??es encontradas
    	        Treinador treinador = new Treinador(userID,nome,dtNasc,sexo,email,tipoUser,cnpj,cref,senha);
    	   //Adiciona o treinador na lista
    	        lista.add(treinador);
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
      
      public Treinador buscar(int id) {
      	Treinador treinador = null;
      	PreparedStatement stmt = null;
      	ResultSet rs = null;
      	try {
      		conexao = ConexaoDAO.obterConexao();
      		stmt = conexao.prepareStatement("SELECT * FROM tb_h_usuario WHERE ds_tipo_usuario = 'T' AND cd_usuario = ?");
      		stmt.setInt(1, id);
      		rs = stmt.executeQuery();

      		if (rs.next()){
        	    int userID = rs.getInt("cd_usuario");
        	    String nome = rs.getString("ds_nome");
        	    java.sql.Date data = rs.getDate("dt_nascimento");
        	    Calendar dtNasc = Calendar.getInstance();
        	    dtNasc.setTimeInMillis(data.getTime());
        	    String sexo = rs.getString("ds_sexo");
        	    String email = rs.getString("ds_email");
        	    String tipoUser = rs.getString("ds_tipo_usuario");
        	    String cnpj = rs.getString("ds_cnpj");
        	    String cref = rs.getString("ds_cref");
        	    String senha = rs.getString("ds_senha");
        	    
        	    treinador = new Treinador(userID,nome,dtNasc,sexo,email,tipoUser,cnpj,cref,senha);
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
      	return treinador;
      }
      
      	//Atualizar
  	public void atualizar(Treinador treinador) throws DBException {
  		PreparedStatement stmt = null;

  		try {
  			conexao = ConexaoDAO.obterConexao();
  			String sql = "UPDATE tb_h_usuario SET ds_nome = ?, dt_nascimento = ?, ds_sexo = ?, ds_email = ?, ds_cnpj = ?, ds_cref = ?, ds_senha = ? WHERE cd_usuario = ?";
  			stmt = conexao.prepareStatement(sql);
            stmt.setString(1, treinador.getNome());
            java.sql.Date data = new java.sql.Date(treinador.getDtNasc().getTimeInMillis());
            stmt.setDate(2, data);
            stmt.setString(3, treinador.getSexo());
            stmt.setString(4, treinador.getEmail());
            stmt.setString(5, treinador.getCnpj());
            stmt.setString(6, treinador.getCref());
            stmt.setString(7, treinador.getSenha());
            stmt.setInt(8, treinador.getUserID());

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
  				String sql = "DELETE FROM tb_h_usuario WHERE cd_usuario = ?";
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
