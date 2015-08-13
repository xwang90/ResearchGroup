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
import android.graphics.Color;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintStream;

import com.example.android.animationsdemo.R;

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 *
 * <p>This class is used by the {@link CardFlipActivity} and {@link
 * ScreenSlideActivity} samples.</p>
 */
public class AnalogScreenSlidePageFragment extends Fragment {
	
	
	
	private static final String TAG = "AnalogScreenSlidePageFragment";
	
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
    public static AnalogScreenSlidePageFragment create(int pageNumber) {
    	AnalogScreenSlidePageFragment fragment = new AnalogScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        //fragment.getView().setBackgroundColor(Color.CYAN);
        return fragment;
    }

    public AnalogScreenSlidePageFragment() {
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
        
        

        /*
        TextView textView =(TextView) rootView.findViewById(android.R.id.text1);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.google.com'> Google </a>";
        textView.setText(Html.fromHtml(text));
        */
        if(mPageNumber==0)
        {
        	final String name_str="Thomas H. Lee\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering\n";
        	final String university_str="Stanford University\n";
        	final String interest_str="Professor Lee's principal areas of professional interest include analog circuitry of all types, ranging from low-level DC instrumentation to high-speed RF communications systems. His present research focus is on CMOS RF integrated circuit design, and on extending operation into the terahertz realm.\n";
            
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        Button button_add = (Button) rootView.findViewById(R.id.add);
                
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		0, mPageNumber, 3);
        	    
        	  } 
        }); 
        
        Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(0,0);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        }); 
        
        Cursor name_cursor=MainActivity.datasource.queryfromFavorite_Name(name_str);
        if (name_cursor.moveToFirst()) {
        	button_add.setVisibility(View.GONE);        	
        }
        else{
        	button_delete.setVisibility(View.GONE);
        }
        name_cursor.close();
        
        }
        else if(mPageNumber==1)
        {
        	final String name_str="Ali Niknejad\n";
        	final String position_str="Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="University of California, Berkeley\n";
        	final String interest_str="Professor Niknejad's Primary research interests include analog integrated circuits, mm-wave CMOS, RF and microwave circuits, device modeling (BSIM), electromagnetics (ASITIC), communication systems, medical imaging, and scientific computing.\n";
            
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        Button button_add = (Button) rootView.findViewById(R.id.add);
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		0, mPageNumber, 3);
        	    
        	  } 
        }); 
        
        Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(0,1);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        }); 
        
        }
        else if(mPageNumber==2)
        {
        	final String name_str="Luca Daniel\n";
        	final String position_str="Associate Professor\n";
        	final String department_str="Department of Electrical Engineering and Computer Science\n";
        	final String university_str="Massachusetts Institute of Technology\n";
        	final String interest_str="Professor Daniel's research interests include development of integral equation solvers for very large complex systems, stochastic field solvers for large number of uncertainties, and automatic generation of parameterized stable compact models for linear and nonlinear dynamical systems. Applications of interest include simulation, modeling and optimization for mixed-signal/RF/mm-wave circuits, power electronics, MEMs, nanotechnologies, materials, MRI, and the human cardiovascular system.\n";
            
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
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
            	myIntent.putExtra("ResearchArea",0);
            	myIntent.putExtra("mPageNumber", mPageNumber);
            	myIntent.putExtra("element", 3);
            	startActivity(myIntent); 
            }
        });
        
        
        Button button_add = (Button) rootView.findViewById(R.id.add);
        button_add.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Favorite favorite = null;
        		System.out.println("ADD");
        	    Log.v(TAG, "ADD");
        	    favorite = MainActivity.datasource.createFavorite("Favorite", 
        	    		name_str, 
        	    		position_str, 
        	    		department_str, 
        	    		university_str, 
        	    		interest_str, 
        	    		0, mPageNumber, 3);
        	    
        	  } 
        }); 
        
        Button button_delete = (Button) rootView.findViewById(R.id.delete);
        button_delete.setOnClickListener(new OnClickListener()
        {
        	  @Override
        	  public void onClick(View v)
        	  {
        	    // do something
        		Cursor cursor=null;
        		System.out.println("DELETE");
        	    Log.v(TAG, "DELETE");
        	    cursor=MainActivity.datasource.queryfromFavorite_ResearchArea_PageNumber(0,2);
        	    cursor.moveToFirst();
        	    Favorite favorite = MainActivity.datasource.cursorToFavorite(cursor);
        	    MainActivity.datasource.deleteFavorite(favorite);
        	    cursor.close();
        	    
        	    
        	  } 
        }); 
        
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
