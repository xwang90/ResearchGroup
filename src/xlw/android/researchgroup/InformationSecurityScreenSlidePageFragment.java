package xlw.android.researchgroup;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class InformationSecurityScreenSlidePageFragment extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static InformationSecurityScreenSlidePageFragment create(int pageNumber) {
    	InformationSecurityScreenSlidePageFragment fragment = new InformationSecurityScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public InformationSecurityScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);
        
        //ImageView image = (ImageView) rootView.findViewById(R.id.homeicon);

        /*
        TextView textView =(TextView) rootView.findViewById(android.R.id.text1);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.google.com'> Google </a>";
        textView.setText(Html.fromHtml(text));
        */
        if(mPageNumber==0)
        {
        	final String name_str="Dan Boneh\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering\n";
        	final String university_str="Stanford University\n";
        	final String interest_str="Professor Boneh's main research focus is applied cryptography and computer security\n";
            
        TextView name_textView =(TextView) rootView.findViewById(R.id.name);
        name_textView.setText(name_str);
        
        TextView position_textView =(TextView) rootView.findViewById(R.id.position);
        position_textView.setText(position_str);
        	
        SpannableString department_ss = new SpannableString(department_str);
        ClickableSpan department_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 1);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        department_ss.setSpan(department_clickableSpan,0,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView department_textView =(TextView) rootView.findViewById(R.id.department);
        department_textView.setText(department_ss);
        department_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        SpannableString university_ss = new SpannableString(university_str);
        ClickableSpan university_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 2);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        university_ss.setSpan(university_clickableSpan,0,19,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView university_textView =(TextView) rootView.findViewById(R.id.university);
        university_textView.setText(university_ss);
        university_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        TextView interest_textView =(TextView) rootView.findViewById(R.id.interest);
        interest_textView.setText(interest_str);
        
        ImageView image = (ImageView) rootView.findViewById(R.id.homepageicon);
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        final Button button_add = (Button) rootView.findViewById(R.id.add);
        final Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_add.setVisibility(View.GONE);
                	button_delete.setVisibility(View.VISIBLE);
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    //Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		3, mPageNumber, 3);
        	  } 
        }); 
        
        
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_delete.setVisibility(View.GONE);
                	button_add.setVisibility(View.VISIBLE);
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    //Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(3,0);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        }); 
        
        Cursor name_cursor=MainActivity.datasource.queryfromFavorite_Name(name_str);
        if (name_cursor.moveToFirst()) {
        	button_add.setVisibility(View.GONE);
        	button_delete.setVisibility(View.VISIBLE);
        }
        else{
        	button_delete.setVisibility(View.GONE);
        	button_add.setVisibility(View.VISIBLE);
        }
        name_cursor.close();
        
        }
        else if(mPageNumber==1)
        {
        	final String name_str="David Wagner\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="University of California, Berkeley\n";
        	final String interest_str="Research interests:Computer security, systems security, usable security, and program analysis for security. I am currently working on security for wearable devices, smartphone security, and other topics in computer security. I have worked on software security, electronic voting, wireless security, sensor network security, and applied cryptography.\n";
            
        TextView name_textView =(TextView) rootView.findViewById(R.id.name);
        name_textView.setText(name_str);
        
        TextView position_textView =(TextView) rootView.findViewById(R.id.position);
        position_textView.setText(position_str);
        	
        SpannableString department_ss = new SpannableString(department_str);
        ClickableSpan department_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 1);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        department_ss.setSpan(department_clickableSpan,0,57,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView department_textView =(TextView) rootView.findViewById(R.id.department);
        department_textView.setText(department_ss);
        department_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        SpannableString university_ss = new SpannableString(university_str);
        ClickableSpan university_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 2);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        university_ss.setSpan(university_clickableSpan,0,34,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView university_textView =(TextView) rootView.findViewById(R.id.university);
        university_textView.setText(university_ss);
        university_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        TextView interest_textView =(TextView) rootView.findViewById(R.id.interest);
        interest_textView.setText(interest_str);
        
        ImageView image = (ImageView) rootView.findViewById(R.id.homepageicon);
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        final Button button_add = (Button) rootView.findViewById(R.id.add);
        final Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_add.setVisibility(View.GONE);
                	button_delete.setVisibility(View.VISIBLE);
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    //Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		3, mPageNumber, 3);
        	  } 
        }); 
        
        
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_delete.setVisibility(View.GONE);
                	button_add.setVisibility(View.VISIBLE);
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    //Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(3,1);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        }); 
        
        Cursor name_cursor=MainActivity.datasource.queryfromFavorite_Name(name_str);
        if (name_cursor.moveToFirst()) {
        	button_add.setVisibility(View.GONE);
        	button_delete.setVisibility(View.VISIBLE);
        }
        else{
        	button_delete.setVisibility(View.GONE);
        	button_add.setVisibility(View.VISIBLE);
        }
        name_cursor.close();
        
        }
        else if(mPageNumber==2)
        {
        	final String name_str="Shafi Goldwasser\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="Massachusetts Institute of Technology\n";
        	final String interest_str="Cryptography,Distributed Computing,Complexity Theory & Algorithms\n";
            
        TextView name_textView =(TextView) rootView.findViewById(R.id.name);
        name_textView.setText(name_str);
        
        TextView position_textView =(TextView) rootView.findViewById(R.id.position);
        position_textView.setText(position_str);
        	
        SpannableString department_ss = new SpannableString(department_str);
        ClickableSpan department_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 1);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        department_ss.setSpan(department_clickableSpan,0,57,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView department_textView =(TextView) rootView.findViewById(R.id.department);
        department_textView.setText(department_ss);
        department_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        SpannableString university_ss = new SpannableString(university_str);
        ClickableSpan university_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
            	
            	
            	//Uri uri = Uri.parse("http://bingweb.binghamton.edu/~xwang90/");
            	 //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            	 //startActivity(intent);
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 2);
            	startActivity(myIntent);            	
            	
            	
            }
        };
        university_ss.setSpan(university_clickableSpan,0,37,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView university_textView =(TextView) rootView.findViewById(R.id.university);
        university_textView.setText(university_ss);
        university_textView.setMovementMethod(LinkMovementMethod.getInstance());
        
        TextView interest_textView =(TextView) rootView.findViewById(R.id.interest);
        interest_textView.setText(interest_str);
        
        ImageView image = (ImageView) rootView.findViewById(R.id.homepageicon);
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent myIntent = new Intent(getActivity(), WebViewActivity.class);
            	myIntent.putExtra("ResearchArea",3);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        final Button button_add = (Button) rootView.findViewById(R.id.add);
        final Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_add.setVisibility(View.GONE);
                	button_delete.setVisibility(View.VISIBLE);
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    //Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		3, mPageNumber, 3);
        	  } 
        }); 
        
        
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		  button_delete.setVisibility(View.GONE);
                	button_add.setVisibility(View.VISIBLE);
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    //Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(3,2);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        });
        
        Cursor name_cursor=MainActivity.datasource.queryfromFavorite_Name(name_str);
        if (name_cursor.moveToFirst()) {
        	button_add.setVisibility(View.GONE);
        	button_delete.setVisibility(View.VISIBLE);
        }
        else{
        	button_delete.setVisibility(View.GONE);
        	button_add.setVisibility(View.VISIBLE);
        }
        name_cursor.close();
        
        }
        
        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
