package ifpi.main.task;

import ifpi.main.adapter.TwitterAdapter;
import ifpi.main.util.TwitterUtil;

import java.util.ArrayList;

import twitter4j.Tweet;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class TwitterTask extends AsyncTask<String, Void, ArrayList<Tweet>> {

	TwitterUtil twitter;
	ProgressDialog progressDialog;
	Context context;
	
	public TwitterTask(Context context){
		
		this.context = context;
	}
	
	@Override
	protected void onPreExecute() {
		
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage("Aguarde...");
		progressDialog.show();
	}

	@Override
	protected ArrayList<Tweet> doInBackground(String... params) {
		twitter = new ifpi.main.util.TwitterUtil();
		
		ArrayList<Tweet> resultado = new ArrayList<Tweet>();
		resultado = twitter.getTweetsFromSearch(params[0]);

		return resultado;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(ArrayList<Tweet> result) {

		if(result != null && result.size() > 0){
			
			//lista = (ArrayList<Tweet>) result;
			((ListActivity) context).setListAdapter(new TwitterAdapter(result, context));
		}
		
		progressDialog.dismiss();
	}
}
