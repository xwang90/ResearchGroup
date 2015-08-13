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

//import android.R;
import com.example.android.animationsdemo.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The launchpad activity for this sample project. This activity launches other activities that
 * demonstrate implementations of common animations.
 */
public class MainActivity extends ListActivity {
	
	public static FavoriteDataSource datasource;
	
    /**
     * This class describes an individual sample (the sample title, and the activity class that
     * demonstrates this sample).
     */
    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

    /**
     * The collection of all samples in the app. This gets instantiated in {@link
     * #onCreate(android.os.Bundle)} because the {@link Sample} constructor needs access to {@link
     * android.content.res.Resources}.
     */
    private static Sample[] mSamples;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println( "MainActivity onCreate");
        
        setContentView(R.layout.activity_main);
        
        datasource = new FavoriteDataSource(this);
        datasource.open();

        // Instantiate the list of samples.
        mSamples = new Sample[]{
                new Sample(R.string.Analog, ScreenSlideAnalogActivity.class),
                new Sample(R.string.ComputerArchitecture, ScreenSlideComputerArchitectureActivity.class),
                new Sample(R.string.ComputerVision, ScreenSlideComputerVisionActivity.class),
                new Sample(R.string.InformationSecurity, ScreenSlideInformationSecurityActivity.class),
                new Sample(R.string.PhysicalElectronics, ScreenSlidePhysicalElectronicsActivity.class),
                new Sample(R.string.Favorite, ScreenSlideFavoriteActivity.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mSamples));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }
    
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        
        System.out.println( "MainActivity onDestroy");
        
        datasource.close();
        
    }
}
