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
		final int count;
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		PreparedStatement stmt1 = con.prepareStatement("select count(*) from Users where email = ? ");
		stmt1.setString(1, user.getEmail());
		ResultSet rs = stmt1.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
			if (count == 0) {
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

			else
				return false;
		} else
			return false;
	}

	@Override
	public boolean loginUser(User user) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		PreparedStatement stmt = con.prepareStatement("select * from Users where user = ? ");
		stmt.setString(1, user.getEmail());
		ResultSet rs = stmt.executeQuery();
		String extractedEmail = rs.getString("email");
		String extractedPass = rs.getString("password");

		if (extractedEmail == user.getEmail() && extractedPass == user.getPassword())
			return true;
		else
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
