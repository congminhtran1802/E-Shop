package bookshop.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookshop.entity.Review;
import bookshop.entity.User;
import bookshop.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
    private ReviewService reviewService;
	
	
	@PostMapping("/add/{id}")
	public String addReview(HttpSession session,@ModelAttribute("review") Review review,@PathVariable String id) {
		int tempId = Integer.parseInt(id);
		LocalDateTime now = LocalDateTime.now();
    	User auth = (User) session.getAttribute("account");
    	review.setProductId(tempId);
    	review.setUserName(auth.getUsername());
    	LocalDate orderDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
    	review.setReviewDate(orderDate);
    	System.out.println(review.getContent());
    	reviewService.addReview(review);
		return "redirect:/products/"+id;
	}
}
