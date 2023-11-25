package bookshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookshop.entity.Product;
import bookshop.entity.Review;
import bookshop.entity.User;
import bookshop.service.ProductService;
import bookshop.service.OrderService;
import bookshop.service.ReviewService;
import bookshop.service.UserService;
import bookshop.entity.Order;

@Controller
@RequestMapping("/products")
public class ProductControllerBussiness {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private ReviewService reviewService;

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("productList", products);
        return "list-product"; // View name
    }

    @GetMapping("/{id}")
    public String loadProduct(@PathVariable String id, Model model, HttpSession session) {
    	int tempId = Integer.parseInt(id);
    	User auth = (User) session.getAttribute("account");
        Product product = productService.findProductById(tempId);
        boolean checkOrder = userService.orderProduct(auth, tempId);
        List<Review> reviews = reviewService.getReviews(tempId);
        model.addAttribute("product", product);
        model.addAttribute("checkOrder", checkOrder);
        model.addAttribute("reviews", reviews);
        return "detail-product"; // View name
    }
    
    @GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
	// search customers from the service
	List<Product> theProducts = productService.searchProducts(theSearchName);
	// add the customers to the model
	theModel.addAttribute("productList", theProducts);
	return "list-product";
	}
    
    @GetMapping("/filter/{filter}")
    public String filter(@PathVariable String filter, Model model) {
    	List<Product> products = productService.filterProduct(filter);
        model.addAttribute("productList", products);
        return "list-product";// View name
    }
}
