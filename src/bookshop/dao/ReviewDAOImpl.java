package bookshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookshop.entity.Review;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Review> getReviews(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Review> theQuery=currentSession.createQuery("from Review where productId = :productId order by reviewDate",Review.class);
		// execute query and get result list
		theQuery.setParameter("productId", id);
		List<Review> reviews = theQuery.getResultList();
		// return the results
		
		return reviews;
	}

	@Override
	public void addReview(Review review) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(review);
		
	}

}
