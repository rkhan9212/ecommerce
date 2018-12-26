package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import impl.CartDAOImpl;
import impl.UsersDAOImpl;
import model.Cart;

@WebServlet(urlPatterns = "/AddProductToCart")
public class AddProductToCart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		int quantity = Integer.parseInt(req.getParameter("qty"));
		int productid = Integer.parseInt(req.getParameter("productid"));
		System.out.printf("username: %s,quantity: %s, productid: %s", username, quantity, productid);

		Cart c = new Cart();
		
		c.setBillingaddress(new UsersDAOImpl().getUserAddress(username));
		c.setShippingaddress(new UsersDAOImpl().getUserAddress(username));
		

		c.setUsername(username);
		c.setQuantity(quantity);
		c.setProductid(productid);

		System.out.println(c);

		CartDAO cdao = new CartDAOImpl();

		cdao.insert(c);

		System.out.println("INSERTED SUCCESSFULLY");

		resp.sendRedirect("ViewCart.jsp");
	}

}
