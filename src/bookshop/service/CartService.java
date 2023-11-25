package bookshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import bookshop.entity.Cart;

public interface CartService {
	List<Cart> createCart(int itemId, HttpSession session);
	void addItemToCart(List<Cart> cartList, int itemId);
	List<Cart> retrieveCartList(HttpSession session);
	double getTotalCartPrice(List<Cart> cartList);
	void updateQuantity(String action, int id, HttpSession session);
	void removeFromCard(int productId, HttpSession session);
}
