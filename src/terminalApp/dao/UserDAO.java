package terminalApp.dao;

import java.sql.SQLException;

import terminalApp.model.User;

public interface UserDAO {

	public boolean registerUser(User user) throws SQLException, ClassNotFoundException;

	public boolean loginUser(User user) throws SQLException, ClassNotFoundException;

	public boolean logoutUser();

	public boolean changePassword();

}