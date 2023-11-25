package bookshop.dao;

import bookshop.entity.User;

public interface UserDAO {
	User userLogin(String username, String password );
}
