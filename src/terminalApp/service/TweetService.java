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

	public List<Tweet> showTweets(String username) throws ClassNotFoundException, SQLException {
		return tweetDao.getTweets(username);
	}

	public boolean post(Tweet tweet1) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tweetDao.postTweet(tweet1);
		
	}

}
