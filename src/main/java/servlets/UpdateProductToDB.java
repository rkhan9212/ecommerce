package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import impl.ProductDAOImpl;
import model.Product;

@WebServlet(urlPatterns="/UpdateProductToDB")
public class UpdateProductToDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt( req.getParameter("id") );
		String Category = req.getParameter("category");
		String Name = req.getParameter("name");
		String Quantity = req.getParameter("quantity");
		String Price = req.getParameter("price");
		String Description = req.getParameter("description");
		
		
		ProductDAO cdao = new ProductDAOImpl();
		
		Product c = cdao.getProduct(id);
		
		c.setName(Name);
		c.setQuantity(Quantity);
		c.setPrice(Price);
		c.setDescription(Description);
		c.setCategory(Category);
		
		
		cdao.update(c);
		
		resp.sendRedirect("ViewProduct.jsp");
		
	}

	
	
}
