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
import br.com.fiap.devpremium.bean.Nutri;

public class NutriDAO {
	
    //Chama a conex?o do ConexaoDAO
      private Connection conexao;
      

    	public static NutriDAO getNutriDAO() {
    		return new NutriDAO();
    	}
    	
    
   //Chama a classe de Nutri, a conex?o e seta as vari?veis da classe no insert
      public void cadastrar(Nutri nutri) {
        PreparedStatement stmt = null;
    
        try {
          conexao = ConexaoDAO.obterConexao();
          String sql = "INSERT INTO tb_h_usuario (cd_usuario,ds_nome,dt_nascimento,ds_sexo, ds_email, ds_tipo_usuario, ds_cpf, ds_cnpj, ds_crn, ds_cref, ds_senha) VALUES (SQ_USUARIO.NEXTVAL,?,?,?,?,'N',0,?,?,0,?)";
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, nutri.getNome());
          java.sql.Date data = new java.sql.Date(nutri.getDtNasc().getTimeInMillis());
          stmt.setDate(2, data);
          stmt.setString(3, nutri.getSexo());
          stmt.setString(4, nutri.getEmail());
          stmt.setString(5, nutri.getCnpj());
          stmt.setString(6, nutri.getSenha());
          stmt.setString(7, nutri.getCrn());
    
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
      
      public List<Nutri> listar() {
    	    //Cria uma lista de Imc
    	    List<Nutri> lista = new ArrayList<Nutri>();
    	    PreparedStatement stmt = null;
    	    ResultSet rs = null;
    	    //Realiza o select atrav?s da conex?o
    	    try {
    	      conexao = ConexaoDAO.obterConexao();
    	    stmt = conexao.prepareStatement("SELECT * FROM tb_h_usuario WHERE ds_tipo_usuario = 'N' ORDER BY cd_usuario");
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
    	    String crn = rs.getString("ds_crn");
    	    String senha = rs.getString("ds_senha");
   
    	    //Cria um objeto Imc com as informa??es encontradas
    	        Nutri nutri = new Nutri(userID,nome,dtNasc,sexo,email,tipoUser,cnpj,crn,senha);
    	   //Adiciona o treino na lista
    	        lista.add(nutri);
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
      
      public Nutri buscar(int id) {
      	Nutri nutri = null;
      	PreparedStatement stmt = null;
      	ResultSet rs = null;
      	try {
      		conexao = ConexaoDAO.obterConexao();
      		stmt = conexao.prepareStatement("SELECT * FROM tb_h_usuario WHERE ds_tipo_usuario = 'N' AND cd_usuario = ?");
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
        	    String crn = rs.getString("ds_crn");
        	    String senha = rs.getString("ds_senha");
        	    
        	    nutri = new Nutri(userID,nome,dtNasc,sexo,email,tipoUser,cnpj,crn,senha);
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
      	return nutri;
      }
      
      	//Atualizar
  	public void atualizar(Nutri nutri) throws DBException {
  		PreparedStatement stmt = null;

  		try {
  			conexao = ConexaoDAO.obterConexao();
  			String sql = "UPDATE tb_h_usuario SET ds_nome = ?, dt_nascimento = ?, ds_sexo = ?, ds_email = ?, ds_cnpj = ?, ds_crn = ?, ds_senha=? WHERE cd_usuario = ?";
  			stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nutri.getNome());
            java.sql.Date data = new java.sql.Date(nutri.getDtNasc().getTimeInMillis());
            stmt.setDate(2, data);
            stmt.setString(3, nutri.getSexo());
            stmt.setString(4, nutri.getEmail());
            stmt.setString(5, nutri.getCnpj());
            stmt.setString(6, nutri.getCrn());
            stmt.setString(7, nutri.getSenha());
            stmt.setInt(8, nutri.getUserID());

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
