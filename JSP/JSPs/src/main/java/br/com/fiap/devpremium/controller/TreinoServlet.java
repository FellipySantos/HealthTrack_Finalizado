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

import br.com.fiap.devpremium.bean.Treino;
import br.com.fiap.devpremium.dao.TreinoDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/treino")
public class TreinoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TreinoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = TreinoDAO.getTreinoDAO();
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
		Treino treino = dao.buscar(id);
		request.setAttribute("treino", treino);
		request.getRequestDispatcher("edicao-treino.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Treino> lista = dao.listar();
		request.setAttribute("treino", lista);
		request.getRequestDispatcher("lista-treino.jsp").forward(request, response);
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
			request.setAttribute("msg", "Treino removido!");
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
			String frequencia = request.getParameter("frequencia");
			
			Treino treino = new Treino(codigo, null,nome,descricao,qtdCal,validade,frequencia); 
			dao.atualizar(treino);

			request.setAttribute("msg", "Treino atualizado!");
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
			String frequencia = request.getParameter("frequencia");
			
			Treino treino = new Treino(0, null,nome,descricao,qtdCal,validade,frequencia); 
			dao.cadastrar(treino);

			request.setAttribute("msg", "Treino cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-treino.jsp").forward(request, response);
	}

}
