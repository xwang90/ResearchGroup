package xlw.android.researchgroup;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.webkit.WebView;


public class WebViewActivity extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Intent mIntent = getIntent();
	        int mPageNumber = mIntent.getIntExtra("mPageNumber", 0);
	        int element= mIntent.getIntExtra("element", 0);
	        int ResearchArea=mIntent.getIntExtra("ResearchArea", 0);
	        WebView webview = new WebView(this);
	        setContentView(webview);
	        
	        if(ResearchArea==0)
	        {
	        if(mPageNumber==0)
	        {
              if(element==1)
              webview.loadUrl("http://ee.stanford.edu/");
              else if(element==2)
              webview.loadUrl("http://www.stanford.edu/");
              else if(element==3)
              webview.loadUrl("http://smirc.stanford.edu/tom.html");
	        }
	        else if(mPageNumber==1)
	        {
	              if(element==1)
	              webview.loadUrl("http://www.eecs.berkeley.edu/");
	              else if(element==2)
	              webview.loadUrl("http://www.berkeley.edu/");
	              else if(element==3)
	              webview.loadUrl("http://rfic.eecs.berkeley.edu/~niknejad/");
		    }
	        else if(mPageNumber==2)
	        {
	              if(element==1)
	              webview.loadUrl("https://www.eecs.mit.edu/");
	              else if(element==2)
	              webview.loadUrl("http://web.mit.edu/");
	              else if(element==3)
		          webview.loadUrl("http://www.mit.edu/~dluca/");
		    }
	        }
	        else if(ResearchArea==1)
	        {

		        if(mPageNumber==0)
		        {
	              if(element==1)
	              webview.loadUrl("http://ee.stanford.edu/");
	              else if(element==2)
	              webview.loadUrl("http://www.stanford.edu/");
	              else if(element==3)
			      webview.loadUrl("http://csl.stanford.edu/~christos/");
	              
		        }
		        else if(mPageNumber==1)
		        {
		        	if(element==1)
			        webview.loadUrl("http://www.eecs.berkeley.edu/");
			        else if(element==2)
			        webview.loadUrl("http://www.berkeley.edu/");
			        else if(element==3)
					webview.loadUrl("http://www.eecs.berkeley.edu/~krste/");
			    }
		        else if(mPageNumber==2)
		        {
		              if(element==1)
		              webview.loadUrl("https://www.eecs.mit.edu/");
		              else if(element==2)
		              webview.loadUrl("http://web.mit.edu/");
		              else if(element==3)
			          webview.loadUrl("http://nms.csail.mit.edu/~hari/");
			    }
		        
	        	
	        }
	        else if(ResearchArea==2)
	        {

		        if(mPageNumber==0)
		        {
	              if(element==1)
	              webview.loadUrl("http://ee.stanford.edu/");
	              else if(element==2)
	              webview.loadUrl("http://www.stanford.edu/");
	              else if(element==3)
			      webview.loadUrl("http://vision.stanford.edu/feifeili/");
	              
		        }
		        else if(mPageNumber==1)
		        {
		        	if(element==1)
			        webview.loadUrl("http://www.eecs.berkeley.edu/");
			        else if(element==2)
			        webview.loadUrl("http://www.berkeley.edu/");
			        else if(element==3)
					webview.loadUrl("http://www.eecs.berkeley.edu/~trevor/");
			    }
		        else if(mPageNumber==2)
		        {
		              if(element==1)
		              webview.loadUrl("https://www.eecs.mit.edu/");
		              else if(element==2)
		              webview.loadUrl("http://web.mit.edu/");
		              else if(element==3)
			          webview.loadUrl("http://people.csail.mit.edu/fredo/");
			    }
		        
	        	
	        }
	        else if(ResearchArea==3)
	        {

		        if(mPageNumber==0)
		        {
	              if(element==1)
	              webview.loadUrl("http://ee.stanford.edu/");
	              else if(element==2)
	              webview.loadUrl("http://www.stanford.edu/");
	              else if(element==3)
			      webview.loadUrl("http://crypto.stanford.edu/~dabo/");
	              
		        }
		        else if(mPageNumber==1)
		        {
		        	if(element==1)
			        webview.loadUrl("http://www.eecs.berkeley.edu/");
			        else if(element==2)
			        webview.loadUrl("http://www.berkeley.edu/");
			        else if(element==3)
					webview.loadUrl("https://www.eecs.berkeley.edu/~daw/");
			    }
		        else if(mPageNumber==2)
		        {
		              if(element==1)
		              webview.loadUrl("https://www.eecs.mit.edu/");
		              else if(element==2)
		              webview.loadUrl("http://web.mit.edu/");
		              else if(element==3)
			          webview.loadUrl("http://people.csail.mit.edu/shafi/");
			    }
		        
	        	
	        }
	        else if(ResearchArea==4)
	        {

		        if(mPageNumber==0)
		        {
	              if(element==1)
	              webview.loadUrl("http://ee.stanford.edu/");
	              else if(element==2)
	              webview.loadUrl("http://www.stanford.edu/");
	              else if(element==3)
			      webview.loadUrl("http://web.stanford.edu/~jela/");
	              
		        }
		        else if(mPageNumber==1)
		        {
		        	if(element==1)
			        webview.loadUrl("http://www.eecs.berkeley.edu/");
			        else if(element==2)
			        webview.loadUrl("http://www.berkeley.edu/");
			        else if(element==3)
					webview.loadUrl("http://www.eecs.berkeley.edu/~jbokor/");
			    }
		        else if(mPageNumber==2)
		        {
		              if(element==1)
		              webview.loadUrl("https://www.eecs.mit.edu/");
		              else if(element==2)
		              webview.loadUrl("http://web.mit.edu/");
		              else if(element==3)
			          webview.loadUrl("http://www.rle.mit.edu/sclaser/team/professor-rajeev-ram/");
			    }
		        
	        	
	        }

	    }
	 
	 
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case android.R.id.home:
	                // Navigate "up" the demo structure to the launchpad activity.
	                // See http://developer.android.com/design/patterns/navigation.html for more.
	                //NavUtils.navigateUpTo(this, new Intent(this, ScreenSlideAnalogActivity.class));
	            	finish();
	            	
	            	return true;

	            }

	        return super.onOptionsItemSelected(item);
	    }

        
}
