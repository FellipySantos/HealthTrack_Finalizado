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

import br.com.fiap.devpremium.bean.Pressao;
import br.com.fiap.devpremium.dao.PressaoDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/pressao")
public class PressaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PressaoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = PressaoDAO.getPressaoDAO();
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
		Pressao pressao = dao.buscar(id);
		request.setAttribute("pressao", pressao);
		request.getRequestDispatcher("edicao-pressao.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pressao> lista = dao.listar();
		request.setAttribute("pressao", lista);
		request.getRequestDispatcher("lista-pressao.jsp").forward(request, response);
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
			request.setAttribute("msg", "Pressão removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request,response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int sistolica = Integer.parseInt(request.getParameter("sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("diastolica"));
			int bpm = Integer.parseInt(request.getParameter("bpm"));
			
			Pressao pressao = new Pressao(codigo, null,sistolica,diastolica,bpm); 
			dao.atualizar(pressao);

			request.setAttribute("msg", "Pressão atualizada!");
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
			int sistolica = Integer.parseInt(request.getParameter("sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("diastolica"));
			int bpm = Integer.parseInt(request.getParameter("bpm"));
			
			Pressao pressao = new Pressao(0, null,sistolica,diastolica,bpm); 
			dao.cadastrar(pressao);

			request.setAttribute("msg", "Pressão cadastrada!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-pressao.jsp").forward(request, response);
	}

}