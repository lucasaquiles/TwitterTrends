package ifpi.main.adapter;

import java.util.ArrayList;

import twitter4j.Tweet;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TwitterAdapter extends BaseAdapter {

	ArrayList<Tweet> tweets  = null;
	Context context = null;
	
	public TwitterAdapter(ArrayList<Tweet> tweets, Context context) {
		super();
		this.tweets = tweets;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return tweets.size();
	}

	@Override
	public Object getItem(int index) {
		return tweets.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		View linha = view;
		
		if(linha == null){
		
			LayoutInflater inflater  = ((ListActivity) context).getLayoutInflater();
			linha = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
		}
		
		Tweet tweet = (Tweet) getItem(position);
		((TextView) linha).setText(tweet.getText());
		
		return linha;
	} 

}
