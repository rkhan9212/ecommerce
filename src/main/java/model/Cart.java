package model;

public class Cart {
	
		private int id,quantity,productid;
		private String username, shippingaddress ,billingaddress;
		private Product product;
		
		
		
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getProductid() {
			return productid;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getShippingaddress() {
			return shippingaddress;
		}
		public void setShippingaddress(String shippingaddress) {
			this.shippingaddress = shippingaddress;
		}
		public String getBillingaddress() {
			return billingaddress;
		}
		public void setBillingaddress(String billingaddress) {
			this.billingaddress = billingaddress;
		}
		
		
		
	}


