package br.com.fiap.devpremium.controller;

/*import java.text.SimpleDateFormat;*/
/*import java.util.Calendar;*/

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.devpremium.bean.Nutri;
import br.com.fiap.devpremium.dao.NutriDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/nutri")
public class NutriServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private NutriDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = NutriDAO.getNutriDAO();
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
		Nutri nutri = dao.buscar(id);
		request.setAttribute("nutri", nutri);
		request.getRequestDispatcher("edicao-nutri.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Nutri> lista = dao.listar();
		request.setAttribute("nutri", lista);
		request.getRequestDispatcher("lista-nutri.jsp").forward(request, response);
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
			request.setAttribute("msg", "Nutricionista removido!");
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
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtNasc = Calendar.getInstance();
			dtNasc.setTime(format.parse(request.getParameter("dtNasc")));
			String sexo = request.getParameter("sexo");
			String email = request.getParameter("email");
			String tipoUser = request.getParameter("tipoUser");
			String cnpj = request.getParameter("cnpj");
			String crn = request.getParameter("crn");
			String senha = request.getParameter("senha");
			
			Nutri nutri = new Nutri(codigo,nome,dtNasc,sexo,email,tipoUser,cnpj,crn,senha); 
			dao.atualizar(nutri);

			request.setAttribute("msg", "Nutricionista atualizado!");
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
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dtNasc = Calendar.getInstance();
			dtNasc.setTime(format.parse(request.getParameter("dtNasc")));
			String sexo = request.getParameter("sexo");
			String email = request.getParameter("email");
			String tipoUser = request.getParameter("tipoUser");
			String cnpj = request.getParameter("cnpj");
			String crn = request.getParameter("crn");
			String senha = request.getParameter("senha");
			
			Nutri nutri = new Nutri(0, nome, dtNasc,sexo,email,tipoUser,cnpj,crn,senha); 
			dao.cadastrar(nutri);

			request.setAttribute("msg", "Nutricionista cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-nutri.jsp").forward(request, response);
	}

}
