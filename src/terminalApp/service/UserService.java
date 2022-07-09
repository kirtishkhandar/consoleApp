package terminalApp.service;

import java.sql.SQLException;

import terminalApp.dao.UserDAO;
import terminalApp.daoImpl.UserDAOImpl;
import terminalApp.model.User;

public class UserService {

	public boolean register(User user) throws ClassNotFoundException, SQLException {
		UserDAO userDao = new UserDAOImpl();	
		return userDao.registerUser(user);
	}
}
