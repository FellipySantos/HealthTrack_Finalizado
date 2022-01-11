package br.com.fiap.devpremium.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
	  
    public static Connection obterConexao() {
      Connection conexao = null;
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
  
        conexao = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "rm88061", "110394");
  
      } catch (SQLException e) {
    	    System.err.println("Não foi possível conectar no Banco de Dados");
    	    e.printStackTrace();
    	  } catch (ClassNotFoundException e) {
    	    System.err.println("O Driver JDBC não foi encontrado!");
    	    e.printStackTrace();
    	  }
      return conexao;
    }
  
  }
