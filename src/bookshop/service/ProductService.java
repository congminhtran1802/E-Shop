package bookshop.service;

import java.util.List;

import bookshop.entity.Order;
import bookshop.entity.Product;

public interface ProductService {
	List<Product> getProducts();
    Product findProductById(int id);
	List<Product> getProductsByList(List<Order> orderList);
	List<Product> searchProducts(String theSearchName);
	List<Product> filterProduct(String filter);
	void deleteProduct(int theId);
	List<Product> getProductsBySeller(String username);
}
