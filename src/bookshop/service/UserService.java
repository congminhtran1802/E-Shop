package bookshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import bookshop.entity.Order;
import bookshop.entity.User;

public interface UserService {
	User userLogin(String username, String password);

	void logout(HttpSession session);
	
	boolean orderProduct(User auth, int productId);

	List<Order> getOrdersConfirm(String username);
}
