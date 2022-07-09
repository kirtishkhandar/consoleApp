package terminalApp.daoImpl;

import java.sql.*;

import terminalApp.dao.UserDAO;
import terminalApp.model.User;

public class UserDAOImpl implements UserDAO {

	String driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver";
	String url = "jdbc:odbc:XE";
	String username = "scott";
	String password = "tiger";

	@Override
	public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setString(1, user.getFirstName());
		stmt.setString(2, user.getLastName());
		stmt.setString(3, user.getGender());
		stmt.setLong(4, user.getDob());
		stmt.setString(5, user.getEmail());
		stmt.setString(6, user.getPassword());
		boolean result = stmt.execute();
		con.close();
		
		return result;
	}

	@Override
	public boolean loginUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logoutUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword() {
		// TODO Auto-generated method stub
		return false;
	}

}
