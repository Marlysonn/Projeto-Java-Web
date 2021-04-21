package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.service.ClientServiceImpl;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public ListServlet() {
		this.service = new ClientServiceImpl();
	}
	
	RequestDispatcher rDispatcher;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setAttribute("clients", this.service.getAll());
			rDispatcher = request.getRequestDispatcher("list.jsp");
			rDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			long idClient= Long.parseLong(request.getParameter("idClient"));
			this.service.deleteById(idClient);
			this.doGet(request, response);
			

	}

}
