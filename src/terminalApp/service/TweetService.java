package terminalApp.service;

import java.sql.SQLException;
import java.util.List;

import terminalApp.dao.TweetDAO;
import terminalApp.daoImpl.TweetDAOImpl;
import terminalApp.model.Tweet;

public class TweetService {

	TweetDAO tweetDao = new TweetDAOImpl();

	public List<Tweet> showAllTweets() throws ClassNotFoundException, SQLException {
		return tweetDao.getAllTweets();
	}

	public List<Tweet> showMyTweets(String username) throws ClassNotFoundException, SQLException {
		return tweetDao.getMyTweets(username);
	}

}
