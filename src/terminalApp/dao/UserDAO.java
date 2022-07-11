package terminalApp.dao;

import java.sql.SQLException;

import terminalApp.model.User;

public interface UserDAO {

	public boolean registerUser(User user) throws SQLException, ClassNotFoundException;

	public boolean loginUser(User user) throws SQLException, ClassNotFoundException;
	
	public boolean isLoggedIn(String username) throws SQLException, ClassNotFoundException;

	public boolean logoutUser(String username) throws ClassNotFoundException, SQLException;

	public boolean changePassword();

	public boolean doesUserExist(String username) throws ClassNotFoundException, SQLException;

}
