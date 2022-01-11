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

import br.com.fiap.devpremium.bean.Treinador;
import br.com.fiap.devpremium.dao.TreinadorDAO;
import br.com.fiap.devpremium.exception.DBException;

@WebServlet("/treinador")
public class TreinadorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TreinadorDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = TreinadorDAO.getTreinadorDAO();
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
		Treinador treinador = dao.buscar(id);
		request.setAttribute("treinador", treinador);
		request.getRequestDispatcher("edicao-treinador.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Treinador> lista = dao.listar();
		request.setAttribute("treinador", lista);
		request.getRequestDispatcher("lista-treinador.jsp").forward(request, response);
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
			request.setAttribute("msg", "Treinador removido!");
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
			String cref = request.getParameter("cref");
			String senha = request.getParameter("senha");
			
			Treinador treinador = new Treinador(codigo,nome,dtNasc,sexo,email,tipoUser,cnpj,cref,senha); 
			dao.atualizar(treinador);

			request.setAttribute("msg", "Treinador atualizado!");
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
			String cref = request.getParameter("cref");
			String senha = request.getParameter("senha");
			
			Treinador treinador = new Treinador(0, nome, dtNasc,sexo,email,tipoUser,cnpj,cref,senha); 
			dao.cadastrar(treinador);

			request.setAttribute("msg", "Treinador cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-treinador.jsp").forward(request, response);
	}

}