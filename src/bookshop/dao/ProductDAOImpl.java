package bookshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookshop.entity.Order;
import bookshop.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Product> theQuery=currentSession.createQuery("from Product order by Id",Product.class);
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
		// return the results
		
		return products;
	}

	@Override
	public Product findProductById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Product.class, id);
	}

	@Override
	public void addProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
	}

	@Override
	public List<Product> getProductsByList(List<Order> orderList) {
		// TODO Auto-generated method stub
		List<Product> productTemp = new ArrayList<>();
		for (Order order : orderList) {
			Session currentSession = sessionFactory.getCurrentSession();
			//create a query
			Query<Product> theQuery=currentSession.createQuery("from Product where id = :id order by Id",Product.class);
			// execute query and get result list
			theQuery.setParameter("id", order.getProductId());
			productTemp.add(theQuery.getSingleResult());
			// return the results
		}
		return productTemp;
	}

	@Override
	public List<Product> searchProducts(String theSearchName) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				Query theQuery = null;
				//
				// only search by name if theSearchName is not empty
				//
				if (theSearchName != null && theSearchName.trim().length() > 0) {
				// search for firstName or lastName ... case insensitive
				theQuery =currentSession.createQuery("from Product where lower(name) like :theName", Product.class);
				theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() +
				"%");
				}
				else {
				// theSearchName is empty ... so just get all customers
				theQuery =currentSession.createQuery("from Product", Product.class);
				}
				// execute query and get result list
				List<Product> products = theQuery.getResultList();
				// return the results
				return products;
	}

	@Override
	public List<Product> filterProduct(String filter) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		//
		// only search by name if theSearchName is not empty
		//
		if (filter != null && filter.trim().length() > 0) {
		// search for firstName or lastName ... case insensitive
		theQuery =currentSession.createQuery("from Product where lower(category) like :theCategory", Product.class);
		theQuery.setParameter("theCategory", "%" + filter.toLowerCase() +
		"%");
		}
		else {
		// theSearchName is empty ... so just get all customers
		theQuery =currentSession.createQuery("from Product", Product.class);
		}
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
		// return the results
		return products;
	}

	@Override
	public void deleteProduct(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Product> getProductsBySeller(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Product> theQuery=currentSession.createQuery("from Product where seller=:seller order by Id",Product.class);
		// execute query and get result list
		theQuery.setParameter("seller", username);
		List<Product> products = theQuery.getResultList();
		// return the results
		
		return products;
	}
	
	
}
