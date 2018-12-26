package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Config;
import dao.CartDAO;
import model.Cart;

public class CartDAOImpl implements CartDAO {
	
	public void delete(String username) {
		String query = "delete from Cart where username=?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCount(String username) {
		
		String query = "select * from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);
			
			ResultSet rs = p.executeQuery();

			int count = 0;
			
			while (rs.next()) {
				count++;
			}
			
			return count;
		}
		catch (Exception e) {

		e.printStackTrace();
		}
		
		return 0;
	}

	public String getBillingAddress(String username) {

		String query = "select billingaddress from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			ResultSet rs = p.executeQuery();
			if (rs.next()) {

				return rs.getString("billingaddress");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getShippingAddress(String username) {
		String query = "select shippingaddress from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			ResultSet rs = p.executeQuery();
			if (rs.next()) {

				return rs.getString("shippingaddress");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void updateBillingAndShippingAddress(String username, String billingAddress, String shippingAddress) {
		String query = "update Cart set shippingaddress=? ,billingaddress= ? where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(3, username);
			p.setString(2, billingAddress);
			p.setString(1, shippingAddress);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Cart c) {
		// TODO Auto-generated method stub
		String query = "insert into Cart (username,productid,shippingaddress,billingaddress,quantity) values (?,?,?,?,?)";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, c.getUsername());
			p.setInt(2, c.getProductid());
			p.setString(3, c.getShippingaddress());
			p.setString(4, c.getBillingaddress());
			p.setInt(5, c.getQuantity());

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int c) {
		// TODO Auto-generated method stub
		String query = "delete from Cart where id=?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, c);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Cart> getCart(String Username) {
		// TODO Auto-generated method stub
		List<Cart> list = new ArrayList<Cart>();
		String query = "select * from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, Username);
			
			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				Cart c = new Cart();

				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setShippingaddress(rs.getString("shippingaddress"));
				c.setBillingaddress(rs.getString("billingaddress"));
				c.setQuantity(rs.getInt("quantity"));
				c.setProductid(rs.getInt("productid"));

				c.setProduct(new ProductDAOImpl().getProduct(c.getProductid()));
				
				list.add(c);

			}
		}
		catch (Exception e) {

		e.printStackTrace();
		}
		
		return list;
	}

	public Cart getCart(int cid) {
		// TODO Auto-generated method stub
		Cart c = new Cart();

		String query = "select * from Cart where id= ?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, cid);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("Username"));
				c.setShippingaddress(rs.getString("Shippingaddress"));
				c.setBillingaddress(rs.getString("Billingaddress"));
				c.setQuantity(rs.getInt("quantity"));
				c.setProductid(rs.getInt("Productid"));


				return c;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return null;
	}


	}