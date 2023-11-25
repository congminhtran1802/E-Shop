package bookshop.dao;

import java.util.List;

import bookshop.entity.Review;

public interface ReviewDAO {

	List<Review> getReviews(int id);

	void addReview(Review review);

}
