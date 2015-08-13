package xlw.android.researchgroup;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

public class SearchableActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	System.out.println( "SearchableActivity onCreate");
    	
        handleIntent(getIntent());
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            Intent intent1 = new Intent(Intent.ACTION_WEB_SEARCH);     
        	intent1.putExtra(SearchManager.QUERY, query);    
        	startActivity(intent1);
        }
    }
 
}
