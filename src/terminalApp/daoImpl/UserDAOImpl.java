package terminalApp.daoImpl;

import java.sql.*;

import terminalApp.dao.UserDAO;
import terminalApp.model.User;

public class UserDAOImpl implements UserDAO {

	String driverClassName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/terminal_app_db";
	String username = "root";
	String password = "root";
	/*
	 * String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 * String url =
	 * "jdbc:sqlserver://LTIN287346\\MSSQLSERVERNEW:1433;databaseName=consoleApp";
	 * String username = "ConsoleAppUser"; String password = "Ok";
	 */

	@Override
	public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
		final int count;
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement stmt1 = con.prepareStatement("select count(*) from Users where email = ? ");
		stmt1.setString(1, user.getEmail());
		ResultSet rs = stmt1.executeQuery();
		int result;
		if (rs.next()) {
			count = rs.getInt(1);

			if (count == 0) {
				PreparedStatement stmt = con.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?, ?)");
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getLastName());
				stmt.setString(3, user.getGender());
				stmt.setLong(4, user.getDob());
				stmt.setString(5, user.getEmail());
				stmt.setString(6, user.getPassword());
				stmt.setBoolean(7, false);
				result = stmt.executeUpdate();
				con.close();
				if (result == 0)
					return false;
				else
					return true;
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

		PreparedStatement stmt = con.prepareStatement("select * from Users where email = ? ");
		stmt.setString(1, user.getEmail());
		ResultSet rs = stmt.executeQuery();
		System.out.println("resultset: " + rs.toString());
		rs.next();
		String extractedEmail = rs.getString("email");
		System.out.println(extractedEmail);
		String extractedPass = rs.getString("password");
		System.out.println(extractedPass);

		if (extractedEmail.equalsIgnoreCase(user.getEmail()) && extractedPass.equalsIgnoreCase(user.getPassword())) {
			stmt = con.prepareStatement("update Users set is_logged_in = 1 where email = ? ");
			stmt.setString(1, user.getEmail());
			stmt.execute();
			return true;
		} else
			return false;
	}

	@Override
	public boolean changePassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLoggedIn(String email) throws SQLException, ClassNotFoundException {
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		PreparedStatement stmt = con.prepareStatement("select * from Users where email = ? ");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		if (rs.next() && rs.getBoolean(7))
			return true;
		return false;
	}

	@Override
	public boolean doesUserExist(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement stmt1 = con.prepareStatement("select count(*) from Users where email = ? ");
		stmt1.setString(1, email);
		ResultSet rs = stmt1.executeQuery();
		rs.next();
		if (rs.getInt(1) == 0) {
			return false;
		} else
			return true;
	}

	@Override
	public boolean logoutUser(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement stmt = con.prepareStatement("update Users set is_logged_in = 0 where email = ? ");
		stmt.setString(1, email);
		stmt.execute();
		return false;
	}

}
