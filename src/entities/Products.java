package entities;

public class Products {

		private String name;
		private double price;
		private int quantity;
		
		
		public Products(String name, double price, int quantity){
			
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}
		
		
		public String getName() {
			return name;
		}


		public double totalPrice() {
			return quantity * price;
		}
}
