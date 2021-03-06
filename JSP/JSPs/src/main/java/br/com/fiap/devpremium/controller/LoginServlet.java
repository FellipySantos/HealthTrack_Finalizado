package br.com.fiap.devpremium.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.devpremium.singleton.ConexaoDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conexao;
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		if(Validacao(email, senha)) {
			response.sendRedirect("index.jsp");
		}	
	}
	
	public boolean Validacao(String email, String senha){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoDAO.obterConexao();
			String sql = "SELECT FROM tb_h_usuario (ds_senha) WHERE ds_email = ?";
			stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, email);
	        rs = stmt.executeQuery();
	        String senhaUser = rs.getString("ds_senha");
	        
	        if(senhaUser.equals(senha)) {
	        	return true;
	        }
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
		return false;
	}
}