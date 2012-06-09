package ifpi.main;

import ifpi.main.adapter.TwitterAdapter;
import ifpi.main.task.TwitterTask;

import java.util.ArrayList;

import twitter4j.Tweet;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TwitterMapsActivity extends ListActivity {
	static ArrayList<Tweet> lista = new ArrayList<Tweet>();	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.i("twitter", "ta no onCreate,  manolo");
     
        lista = (ArrayList<Tweet>) getLastNonConfigurationInstance();
        
        if(lista != null){
        	
        	Toast.makeText(this, lista.get(0).toString(), Toast.LENGTH_LONG).show();
        	Log.i("twitter","o valor é pra tá aqui"+lista.size());
        	
        	setListAdapter(new TwitterAdapter(lista, this));
        }else{
        	
        	Log.i("twitter","ta nulo");
        	TwitterTask task = (TwitterTask) new TwitterTask(this).execute("florianoAndroid");
        }     
    }
    
	@Override
	public Object onRetainNonConfigurationInstance() {
		return lista;
	}
}