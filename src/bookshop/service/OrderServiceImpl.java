package bookshop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.dao.ProductDAO;
import bookshop.dao.OrderDAO;
import bookshop.entity.Product;
import bookshop.entity.Cart;
import bookshop.entity.Order;
import bookshop.entity.User;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
    private OrderDAO orderDAO;

	@Override
	@Transactional
	public void checkout(User auth, ArrayList<Cart> cartList, LocalDateTime now) {
		// TODO Auto-generated method stub
		for (Cart cart : cartList) {
            Order order = new Order();
            Product theProduct = productDAO.findProductById(cart.getId());
            order.setBuyer(auth.getUsername());
            order.setProductId(cart.getId());
            order.setSeller(theProduct.getSeller());
            order.setQuantity(cart.getQuantity());
            order.setOrderDate(now.toLocalDate());
            order.setShippingAddress("123 ABC Street");
            order.setStatus(false);
            order.setTotalAmount(theProduct.getPrice() * cart.getQuantity());

            boolean result = orderDAO.addOrder(order);
            if (!result) {
                break;
            }
        }
        cartList.clear();
	}

	@Override
	@Transactional
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getOrders();
	}

	@Override
	@Transactional
	public void confirmOrder(String id) {
		// TODO Auto-generated method stub
		orderDAO.confirmOrder(id);
	}

	@Override
	@Transactional
	public void cancelOrder(String id) {
		orderDAO.cancelOrder(id);
		
	}

	

}
