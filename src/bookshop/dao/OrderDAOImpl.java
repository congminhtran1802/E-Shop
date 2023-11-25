package bookshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookshop.entity.Order;
import bookshop.entity.User;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrder(Order order) {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.save(order);
			return true; // Return true if the order is added successfully
		} catch (Exception e) {
			// Handle any exceptions that may occur (e.g., database errors)
			e.printStackTrace();
			return false; // Return false in case of an error
		}
	}

	@Override
	public List<Order> getOrders() {
		Session currentSession = sessionFactory.getCurrentSession();

		// Tạo câu truy vấn SQL để lấy các đơn hàng có status = false và sắp xếp theo
		// orderDate
		Query<Order> theQuery = currentSession.createQuery("from Order where status = :status order by orderDate DESC",
				Order.class);
		theQuery.setParameter("status", true);

		// Thực hiện truy vấn và lấy danh sách kết quả
		List<Order> orders = theQuery.getResultList();

		return orders;
	}

	@Override
	public List<Order> getOrdersConfirm(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Tạo câu truy vấn SQL để lấy các đơn hàng có username tuong ung và sắp xếp
		// theo orderDate
		Query<Order> theQuery = currentSession.createQuery("from Order where seller = :seller and status = :status order by orderDate DESC",
				Order.class);
		theQuery.setParameter("seller", userName);
		theQuery.setParameter("status", false);

		// Thực hiện truy vấn và lấy danh sách kết quả
		List<Order> orders = theQuery.getResultList();

		return orders;
	}

	@Override
	public void confirmOrder(String id) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    
	    // Tìm đơn hàng theo id
	    int idUpdate = Integer.parseInt(id);
	    Query<Order> theQuery = currentSession.createQuery("from Order where id = :id", Order.class);
	    theQuery.setParameter("id", idUpdate);
	    Order order = theQuery.getSingleResult();
	    
	    // Cập nhật trạng thái của đơn hàng thành true
	    if (order != null) {
	        order.setStatus(true); // Đánh dấu đơn hàng đã được xác nhận
	        currentSession.update(order); // Cập nhật đơn hàng trong cơ sở dữ liệu
	    }
	}

	@Override
	public void cancelOrder(String id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		int idCancel = Integer.parseInt(id);
		Query theQuery = currentSession.createQuery("delete from Order where id=:productId");
		theQuery.setParameter("productId", idCancel);
		theQuery.executeUpdate();
	}

	@Override
	public boolean orderProduct(User auth, int productId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Tạo câu truy vấn SQL để lấy các đơn hàng có username tuong ung và sắp xếp
		// theo orderDate
		Query<Order> theQuery = currentSession.createQuery("from Order where productId =:productId and buyer = :buyer and status = :status order by orderDate DESC",
				Order.class);
		theQuery.setParameter("productId", productId);
		theQuery.setParameter("buyer", auth.getUsername());
		theQuery.setParameter("status", true);

		// Thực hiện truy vấn và lấy danh sách kết quả
		List<Order> orders = theQuery.getResultList();
		System.out.println("order 1111: "+orders);
		if (!orders.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}

}
