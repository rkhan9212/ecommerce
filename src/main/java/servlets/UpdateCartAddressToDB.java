package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dao.CategoryDAO;
import impl.CartDAOImpl;
import impl.CategoryDAOImpl;
import model.Category;

@WebServlet(urlPatterns="/UpdateCartAddressToDB")
public class UpdateCartAddressToDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartDAO cdao = new CartDAOImpl();
		
		System.out.println();
		
		cdao.updateBillingAndShippingAddress(req.getSession().getAttribute("username").toString(), req.getParameter("billingaddress"), req.getParameter("shippingaddress"));
		
		resp.sendRedirect("ConfirmAddress.jsp");
		
	}

	
	
}
