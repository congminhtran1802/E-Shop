package bookshop.dao;

import java.util.List;

import bookshop.entity.Order;
import bookshop.entity.User;

public interface OrderDAO {

	boolean addOrder(Order order);

	List<Order> getOrders();

	List<Order> getOrdersConfirm(String userName);

	void confirmOrder(String id);

	void cancelOrder(String id);

	boolean orderProduct(User auth, int productId);

}
