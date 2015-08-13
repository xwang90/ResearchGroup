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

import java.util.List;

import xlw.android.researchgroup.FavoriteDataSource;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.animationsdemo.R;

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 *
 * <p>This class is used by the {@link CardFlipActivity} and {@link
 * ScreenSlideActivity} samples.</p>
 */
public class FavoriteScreenSlidePageFragment extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";
    
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
  		  MySQLiteHelper.COLUMN_NAME,
  		  MySQLiteHelper.COLUMN_POSITION,
            MySQLiteHelper.COLUMN_DEPARTMENT,
            MySQLiteHelper.COLUMN_UNIVERSITY,
            MySQLiteHelper.COLUMN_INTEREST,
            MySQLiteHelper.COLUMN_RESEARCHAREA,
            MySQLiteHelper.COLUMN_PAGENUMBER,
            MySQLiteHelper.COLUMN_ELEMENT,	  
            MySQLiteHelper.COLUMN_COMMENT };

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static FavoriteScreenSlidePageFragment create(int pageNumber) {
    	FavoriteScreenSlidePageFragment fragment = new FavoriteScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FavoriteScreenSlidePageFragment() {
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
     
        //List<Favorite> favorites=MainActivity.datasource.getAllFavorites();
        
        Cursor cursor = MainActivity.datasource.queryfromFavorite_Element(3);
        
        //Cursor cursor = MainActivity.datasource.queryfromFavorite(mPageNumber+1);
        
        cursor.moveToFirst();
        
        for(int page=0;page<mPageNumber;page++)
        {
        	cursor.moveToNext();
        }
        
        Favorite newFavorite = MainActivity.datasource.cursorToFavorite(cursor);
        
        String name_str=newFavorite.getname().toString();
    	String position_str=newFavorite.getposition().toString();
    	String department_str=newFavorite.getdepartment().toString();
    	String university_str=newFavorite.getuniversity().toString();
    	String interest_str=newFavorite.getinterest().toString();
    	final int ResearchArea=newFavorite.getResearchArea();
    	final int PageNumber=newFavorite.getPageNumber();
    	
    	Button button_add = (Button) rootView.findViewById(R.id.add);
    	Button button_delete = (Button) rootView.findViewById(R.id.delete);
    	button_add.setVisibility(View.GONE);
    	button_delete.setVisibility(View.GONE);
        
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
            	myIntent.putExtra("ResearchArea",ResearchArea);
            	myIntent.putExtra("mPageNumber", PageNumber);
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
            	myIntent.putExtra("ResearchArea",ResearchArea);
            	myIntent.putExtra("mPageNumber", PageNumber);
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
        
        
        
        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
