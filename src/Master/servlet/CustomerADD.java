package Master.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Master.DAO.customerDAO;
import Master.DTO.customerDTO;

/**
 * Servlet implementation class CustomerADD
 */
public class CustomerADD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String name = request.getParameter("nm");
		String city = request.getParameter("ct");
		int idx = Integer.parseInt(id);
		
		customerDTO cdto = new customerDTO();
		cdto.setId(idx);
		cdto.setName(name);
		cdto.setCity(city);
		
		customerDAO cdao = new customerDAO();
		cdao.insertEn(cdto);
		ArrayList results=cdao.fetchEn();
		HttpSession session=request.getSession();
		session.setAttribute("res",results);
		response.sendRedirect("Show_jstl.jsp");
		
		//response.sendRedirect("insert_entity_response.jsp");
	}

}
