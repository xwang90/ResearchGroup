/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 *
 * <p>This class is used by the {@link CardFlipActivity} and {@link
 * ScreenSlideActivity} samples.</p>
 */
public class ComputerArchitectureScreenSlidePageFragment extends Fragment {
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
    public static ComputerArchitectureScreenSlidePageFragment create(int pageNumber) {
    	ComputerArchitectureScreenSlidePageFragment fragment = new ComputerArchitectureScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ComputerArchitectureScreenSlidePageFragment() {
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
        	final String name_str="Christos Kozyrakis\n";
        	final String position_str="Associate Professor\n";
        	final String department_str="Department of Electrical Engineering\n";
        	final String university_str="Stanford University\n";
        	final String interest_str="Professor Kozyrakis current research focuses on resource efficient cloud computing, energy efficient multicore systems, and architectural support for security.\n";
            
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
        	    		1, mPageNumber, 3);
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
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(1,0);
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
        	final String name_str="Krste Asanovic\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="University of California, Berkeley\n";
        	final String interest_str="Professor Asanovic's My main research areas are computer architecture, VLSI design, parallel programming and operating system design.\n";
            
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
        	    		1, mPageNumber, 3);
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
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(1,1);
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
        	final String name_str="Hari Balakrishnan\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="Massachusetts Institute of Technology\n";
        	final String interest_str="Professor Balakrishnan's research is in the area of networked computer systems, with current interests in networking, data management, and sensing for a world of truly mobile devices connected to cloud services running in datacenters\n";
            
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
            	myIntent.putExtra("ResearchArea",1);
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
        	    		1, mPageNumber, 3);
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
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(1,2);
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
