package staticDemo;

public class ProductManager {
	public void add(Product product) {
		
		if (ProductValidator.isValid(product)) {
			System.out.println("Added.");
		} else {
			System.out.println("Product information is invalid.");
		}
		
		ProductValidator productValidator = new ProductValidator();
		productValidator.bisey();
	}
}
