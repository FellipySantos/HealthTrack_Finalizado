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

import br.com.fiap.devpremium.bean.Imc;
import br.com.fiap.devpremium.dao.ImcDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/imc")
public class ImcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ImcDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = ImcDAO.getImcDAO();
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
		Imc imc = dao.buscar(id);
		request.setAttribute("imc", imc);
		request.getRequestDispatcher("edicao-imc.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Imc> lista = dao.listar();
		request.setAttribute("imc", lista);
		request.getRequestDispatcher("lista-imc.jsp").forward(request, response);
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
			request.setAttribute("msg", "Imc removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request,response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			double peso = Double.parseDouble(request.getParameter("peso"));
			double altura = Double.parseDouble(request.getParameter("altura"));

			Imc imc = new Imc(codigo, null,peso,altura); 
			dao.atualizar(imc);

			request.setAttribute("msg", "Imc atualizado!");
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
			double peso = Double.parseDouble(request.getParameter("peso"));
			double altura = Double.parseDouble(request.getParameter("altura"));
			
			Imc imc = new Imc(0, null,peso,altura); 
			dao.cadastrar(imc);

			request.setAttribute("msg", "Imc cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-imc.jsp").forward(request, response);
	}

}
