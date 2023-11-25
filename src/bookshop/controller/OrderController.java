package bookshop.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bookshop.entity.Product;
import bookshop.entity.Cart;
import bookshop.entity.Order;
import bookshop.entity.User;
import bookshop.service.ProductService;
import bookshop.service.OrderService;
import bookshop.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	@Autowired
    private UserService userService;
	
    @GetMapping("/checkout")
    public String checkout(HttpSession session) throws IOException {
        User auth = (User) session.getAttribute("account");
        if (auth == null) {
            return "redirect:/user/login";
        } else {
            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
            if (cartList != null) {
                LocalDateTime now = LocalDateTime.now();
                orderService.checkout(auth, cartList, now);
                return "redirect:/products/list"; // Assuming the URL for the BookController is "/bookController"
            } else {
                return "redirect:/cart/list"; // Assuming the URL for the CartController is "/cartController"
            }
        }
    }
    
    @GetMapping("/list")
    public String getOrderHistory(Model model, HttpSession session) throws IOException, ServletException {
        User auth = (User) session.getAttribute("account");
        if (auth != null) {
            List<Order> orderList = orderService.getOrders();
            List<Product> productList = productService.getProductsByList(orderList);
            model.addAttribute("orderlist", orderList);
            model.addAttribute("productList", productList);
            return "order-history";
        } else {
        	return "redirect:/user/login";
        }
    }
    
    @GetMapping("/confirm-list")
    public String getOrderConfirm(Model model, HttpSession session) throws IOException, ServletException {
        User auth = (User) session.getAttribute("account");
        if (auth != null) {
            List<Order> orderList = userService.getOrdersConfirm(auth.getUsername());
            List<Product> productList = productService.getProductsByList(orderList);
            model.addAttribute("orderlist", orderList);
            model.addAttribute("productList", productList);
            return "order-confirm";
        } else {
        	return "redirect:/user/login";
        }
    }
    
    @GetMapping("/confirm-list/{id}")
    public String confirmOrder(@PathVariable String id, Model model, HttpSession session) throws IOException, ServletException {
        User auth = (User) session.getAttribute("account");
        if (auth != null) {
            orderService.confirmOrder(id);
            session.removeAttribute("orderConfirmTotal");
        	// Xóa session cũ
        	
        	List<Order> orders = userService.getOrdersConfirm(auth.getUsername());
        	session.setAttribute("orderConfirmTotal", orders.size());
        	return "redirect:/order/confirm-list";
        } else {
        	return "redirect:/user/login";
        }
    }
    
    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable String id, HttpSession session) throws IOException, ServletException {
        User auth = (User) session.getAttribute("account");
        if (auth != null) {
            orderService.cancelOrder(id);
            session.removeAttribute("orderConfirmTotal");
        	// Xóa session cũ
        	
        	List<Order> orders = userService.getOrdersConfirm(auth.getUsername());
        	session.setAttribute("orderConfirmTotal", orders.size());
            return "redirect:/order/confirm-list";
        } else {
        	return "redirect:/user/login";
        }
    }
}
