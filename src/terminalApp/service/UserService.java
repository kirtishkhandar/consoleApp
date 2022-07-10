package terminalApp.service;

import java.sql.SQLException;

import terminalApp.dao.UserDAO;
import terminalApp.daoImpl.UserDAOImpl;
import terminalApp.model.User;

public class UserService {

	UserDAO userDao = new UserDAOImpl();

	public boolean register(User user) throws ClassNotFoundException, SQLException {
		return userDao.registerUser(user);
	}

	public boolean login(User user) throws ClassNotFoundException, SQLException {
		return userDao.loginUser(user);
	}
}
