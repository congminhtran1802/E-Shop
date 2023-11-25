package bookshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookshop.dao.ProductDAO;
import bookshop.entity.Product;
import bookshop.entity.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@Transactional
	@Override
	public List<Cart> createCart(int itemId, HttpSession session) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Product tempProduct = productDAO.findProductById(itemId);
        cart.setId(tempProduct.getId());
        cart.setName(tempProduct.getName());
        cart.setSeller(tempProduct.getSeller());
        cart.setCategory(tempProduct.getCategory());
        cart.setPrice(tempProduct.getPrice());
        cart.setDescription(tempProduct.getDescription());
        cart.setImage(tempProduct.getImage());
        cart.setQuantity(1);
        // Add the cart to a list of carts
        List<Cart> cartList = retrieveCartList(session);
        cartList.add(cart);
        System.out.print("cart is:"+cartList);
        return cartList;
	}
	
	@Transactional
	@Override
	public void addItemToCart(List<Cart> cartList, int itemId) {
		boolean itemExists = false;
	    for (Cart cart : cartList) {
	        if (cart.getId() == itemId) {
	            cart.setQuantity(cart.getQuantity() + 1);
	            itemExists = true;
	            break;
	        }
	    }

	    if (!itemExists) {
	        // Nếu mục chưa tồn tại, thêm một mục mới vào giỏ hàng
	        Cart cart = new Cart();
	        Product tempProduct = productDAO.findProductById(itemId);
	        cart.setId(tempProduct.getId());
	        cart.setName(tempProduct.getName());
	        cart.setSeller(tempProduct.getSeller());
	        cart.setCategory(tempProduct.getCategory());
	        cart.setPrice(tempProduct.getPrice());
	        cart.setDescription(tempProduct.getDescription());
	        cart.setImage(tempProduct.getImage());
	        cart.setQuantity(1);
	        cartList.add(cart);
	    }
		
	}

	@Override
	public List<Cart> retrieveCartList(HttpSession session) {
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        if (cartList == null) {
            // Nếu danh sách không tồn tại, tạo một danh sách mới
            cartList = new ArrayList<>();
            session.setAttribute("cartList", cartList);
        }
        return cartList;
	}

	@Override
	public double getTotalCartPrice(List<Cart> cartList) {
		double totalPrice = 0;
		for (Cart cart : cartList) {
			totalPrice += (cart.getQuantity() * cart.getPrice());
		}
		return totalPrice;
	}

	@Override
	public void updateQuantity(String action, int id, HttpSession session) {
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

        if (action != null && id >= 1) {
            if (action.equals("inc")) {
                for (Cart cart : cartList) {
                    if (cart.getId() == id) {
                        int quantity = cart.getQuantity();
                        quantity++;
                        cart.setQuantity(quantity);
                    }
                }
            }

            if (action.equals("dec")) {
                for (Cart cart : cartList) {
                    if (cart.getId() == id && cart.getQuantity() > 1) {
                        int quantity = cart.getQuantity();
                        quantity--;
                        cart.setQuantity(quantity);
                    }
                }
            }
        }
		
	}

	@Override
	public void removeFromCard(int productId, HttpSession session) {
		// TODO Auto-generated method stub
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

        if (cartList != null) {
            Cart cartToRemove = null;
            for (Cart cart : cartList) {
                if (cart.getId() == productId) {
                    cartToRemove = cart;
                    break;
                }
            }

            if (cartToRemove != null) {
                cartList.remove(cartToRemove);
            }
        }
		
	}

	

}
