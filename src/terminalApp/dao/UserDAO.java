package terminalApp.dao;

import java.sql.SQLException;
import java.util.List;

import terminalApp.model.User;

public interface UserDAO {

	public boolean registerUser(User user) throws SQLException, ClassNotFoundException;

	public boolean loginUser(User user) throws SQLException, ClassNotFoundException;
	
	public boolean isLoggedIn(String username) throws SQLException, ClassNotFoundException;

	public boolean logoutUser(String username) throws ClassNotFoundException, SQLException;

	public boolean changePassword(User user1) throws ClassNotFoundException, SQLException;

	public boolean doesUserExist(String username) throws ClassNotFoundException, SQLException;

	public List<User> getAllUsers() throws ClassNotFoundException, SQLException;

}
