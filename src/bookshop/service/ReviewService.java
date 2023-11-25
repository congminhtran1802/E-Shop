package bookshop.service;

import java.util.List;

import bookshop.entity.Review;

public interface ReviewService {
	List<Review> getReviews(int id);
	void addReview(Review review);
}
