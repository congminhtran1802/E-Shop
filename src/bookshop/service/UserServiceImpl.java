package bookshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.dao.OrderDAO;
import bookshop.dao.UserDAO;
import bookshop.entity.Order;
import bookshop.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
    private OrderDAO orderDAO;
	
	@Override
	@Transactional
	public User userLogin(String username, String password) {
		return userDAO.userLogin(username, password);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.removeAttribute("account");
		session.removeAttribute("orderConfirmTotal");
	}

	@Override
	@Transactional
	public boolean orderProduct(User auth, int productId) {
		// TODO Auto-generated method stub
		if (auth != null) {
			return orderDAO.orderProduct(auth,productId);
		}else {
			return false;
		}
		
	}

	@Override
	@Transactional
	public List<Order> getOrdersConfirm(String username) {
		// TODO Auto-generated method stub
		return orderDAO.getOrdersConfirm(username);
	}

}
