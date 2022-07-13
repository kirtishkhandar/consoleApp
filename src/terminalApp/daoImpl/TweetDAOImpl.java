package terminalApp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import terminalApp.dao.TweetDAO;
import terminalApp.model.Tweet;

public class TweetDAOImpl implements TweetDAO {

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
	public List<Tweet> getAllTweets() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		PreparedStatement stmt = con.prepareStatement("select * from tweets");
		ResultSet rs = stmt.executeQuery();
		List<Tweet> tweets = new ArrayList<Tweet>();
		while (rs.next()) {
			Tweet tweet = new Tweet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			rs.getString(1);
			tweets.add(tweet);
		}
		con.close();
		return tweets;
	}

	@Override
	public List<Tweet> getTweets(String email) throws ClassNotFoundException, SQLException {
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		PreparedStatement stmt = con.prepareStatement("select * from  tweets where email = ?");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		List<Tweet> tweets = new ArrayList<Tweet>();
		while (rs.next()) {
			Tweet tweet = new Tweet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			rs.getString(1);
			tweets.add(tweet);
		}
		con.close();
		return tweets;
	}

}
