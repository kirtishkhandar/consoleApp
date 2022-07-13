package terminalApp.dao;

import java.sql.SQLException;
import java.util.List;

import terminalApp.model.Tweet;

public interface TweetDAO {

	List<Tweet> getAllTweets() throws ClassNotFoundException, SQLException;

	List<Tweet> getMyTweets(String email) throws ClassNotFoundException, SQLException;

}
