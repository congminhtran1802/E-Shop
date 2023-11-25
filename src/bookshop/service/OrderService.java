package bookshop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bookshop.entity.Cart;
import bookshop.entity.Order;
import bookshop.entity.User;

public interface OrderService {

	void checkout(User auth, ArrayList<Cart> cartList, LocalDateTime now);

	List<Order> getOrders();

	void confirmOrder(String id);

	void cancelOrder(String id);

}
