package bookshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bookshop.entity.Cart;
import bookshop.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartControllerBussiness {
	@Autowired
    private CartService cartService;
	
	@GetMapping("/list")
    public String listCarts(HttpSession session, Model model) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

        if (cartList != null) {
            double totalPrice = cartService.getTotalCartPrice(cartList);

            model.addAttribute("cartList", cartList);
            model.addAttribute("totalPrice", totalPrice);
        }

        return "cart";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("id") int id, HttpSession session, RedirectAttributes redirectAttributes) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        
        if (cartList == null) {
            cartList = cartService.createCart(id,session);
            session.setAttribute("cartList", cartList);
        } else {
        	System.out.print("truoc khi add : "+cartList.size());
        	cartService.addItemToCart(cartList, id);
        	System.out.print("sau khi add : "+cartList.size());
        }
        return "redirect:/products/list";
    }
    
    @RequestMapping("/updateQuantity")
    public String updateQuantity(@RequestParam String action, @RequestParam int id, HttpSession session) {
    	cartService.updateQuantity(action,id, session);

        return "redirect:/cart/list"; // Assuming the URL for the CartController is "/cart"
    }
    
    @RequestMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("id") int productId, HttpSession session) {
    	cartService.removeFromCard(productId, session);
    	
    	return "redirect:/cart/list";
    }
}
