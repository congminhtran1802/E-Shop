package bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookshop.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("FROM User WHERE UserName = :username AND Password = :password",User.class);
		theQuery.setParameter("username", username);
	    theQuery.setParameter("password", password);
	    
	    User user = theQuery.uniqueResult();

	    return user;
	}

}
