package bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.dao.ProductDAO;
import bookshop.entity.Order;
import bookshop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDAO.findProductById(id);
	}

	@Override
	@Transactional
	public List<Product> getProductsByList(List<Order> orderList) {
		// TODO Auto-generated method stub
		return productDAO.getProductsByList(orderList);
	}

	@Override
	@Transactional
	public List<Product> searchProducts(String theSearchName) {
		// TODO Auto-generated method stub
		return productDAO.searchProducts(theSearchName);
	}

	@Override
	@Transactional
	public List<Product> filterProduct(String filter) {
		// TODO Auto-generated method stub
		return productDAO.filterProduct(filter);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(theId);
	}

	@Override
	@Transactional
	public List<Product> getProductsBySeller(String username) {
		// TODO Auto-generated method stub
		return productDAO.getProductsBySeller(username);
	}
	
	
}
