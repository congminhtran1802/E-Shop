package bookshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookshop.entity.Order;
import bookshop.entity.User;
import bookshop.service.CartService;
import bookshop.service.OrderService;
import bookshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	
	
	@GetMapping("/login")
	public String showLoginPage()
	{
		return "login";
	}
	
	@PostMapping("/login")
    public String userLogin(HttpServletRequest request, Model model, HttpSession session) throws IOException {
        String username = request.getParameter("login-username");
        String password = request.getParameter("login-password");
        
        
        User user = userService.userLogin(username, password);
         

        if (user != null) {
        	session.removeAttribute("account");
        	session.removeAttribute("orderConfirmTotal");
        	// Xóa session cũ
        	
        	List<Order> orders = userService.getOrdersConfirm(user.getUsername());
        	session.setAttribute("orderConfirmTotal", orders.size());
        		
        	
        	// Ghi đè session với tài khoản mới
        	session.setAttribute("account", user);
        	System.out.println(session.getAttribute("account"));


            return "redirect:/products/list";
        } else {
            // Nếu user là null, hiển thị lại trang login với thông báo lỗi
            model.addAttribute("loginError", true);
            return "login";
        }
    }
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		userService.logout(session);
		return "redirect:/index";
	}
}
