package terminalApp.service;

import java.sql.SQLException;
import java.util.List;

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
	
	public boolean isLoggedIn(String username) throws ClassNotFoundException, SQLException {
		return userDao.isLoggedIn(username);
	}

	public boolean doesUserExist(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDao.doesUserExist(username);
	}

	public boolean logout(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDao.logoutUser(username);
	}

	public List<User> showAllUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	public void resetPass(User user1) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		userDao.changePassword(user1);
	}
}
