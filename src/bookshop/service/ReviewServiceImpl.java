package bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.dao.ReviewDAO;
import bookshop.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	@Transactional
	public List<Review> getReviews(int id) {
		// TODO Auto-generated method stub
		return reviewDAO.getReviews(id);
	}

	@Override
	@Transactional
	public void addReview(Review review) {
		reviewDAO.addReview(review);
		
	}

}
