package br.com.fiap.devpremium.controller;

/*import java.text.SimpleDateFormat;*/
/*import java.util.Calendar;*/

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.devpremium.bean.Dieta;
import br.com.fiap.devpremium.dao.DietaDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/dieta")
public class DietaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DietaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DietaDAO.getDietaDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		}
		
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Dieta dieta = dao.buscar(id);
		request.setAttribute("dieta", dieta);
		request.getRequestDispatcher("edicao-dieta.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dieta> lista = dao.listar();
		request.setAttribute("dieta", lista);
		request.getRequestDispatcher("lista-dieta.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Dieta removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request,response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			int qtdCal = Integer.parseInt(request.getParameter("qtdCal"));
			String validade = request.getParameter("validade");
			
			Dieta dieta = new Dieta(codigo, null,nome,descricao,qtdCal,validade); 
			dao.atualizar(dieta);

			request.setAttribute("msg", "Dieta atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			int qtdCal = Integer.parseInt(request.getParameter("qtdCal"));
			String validade = request.getParameter("validade");
			
			Dieta dieta = new Dieta(0, null,nome,descricao,qtdCal,validade); 
			dao.cadastrar(dieta);

			request.setAttribute("msg", "Dieta cadastrada!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-dieta.jsp").forward(request, response);
	}

}
