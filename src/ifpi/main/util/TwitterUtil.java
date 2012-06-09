package ifpi.main.util;

import java.util.ArrayList;

import android.util.Log;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterUtil {
	
	Twitter twitter;
	
	public TwitterUtil(){
		
		this.twitter = getTwitter();
	}
	
	public ArrayList<Tweet> getTweetsFromSearch(String hashtag){
		
		ArrayList<Tweet> tweets  = new ArrayList<Tweet>();
		Query query = new Query(hashtag);
		QueryResult result = null;
		
		try {
			
			Twitter twitter = getTwitter();
			
			result = twitter.search(query);
	
			Log.i("twitter", "url: "+result.getRefreshUrl());
			Log.i("twitter", "resultados: "+result.getTweets().size());
			Log.i("twitter", "query: "+result.getQuery());
			
			if(result.getTweets().size() > 0){
				
				tweets = new ArrayList<Tweet>();
				tweets.addAll(result.getTweets());
			}		
		} catch (TwitterException e) {
			
			e.printStackTrace();

			Log.i("twitter", "url: "+result.getRefreshUrl());
			Log.i("twitter", "resultados: "+result.getTweets().size());
			Log.i("twitter", "query: "+result.getQuery());
		}
		
		return tweets;
	}
	
	public void getTweets(String hashTag){
		
		Query query = new Query(hashTag);
		Twitter twitter = getTwitter();
		
		QueryResult result = null;
		
		try {
			
			result = twitter.search(query);
		} catch (TwitterException e) {
		
		}
	}
	
	public Twitter getTwitter(){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		TwitterFactory twitterFactory = new TwitterFactory();
		
		return twitterFactory.getInstance();
	}
}
