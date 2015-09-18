package xlw.android.researchgroup;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	public static FavoriteDataSource datasource;
	
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

    private static Sample[] mSamples;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println( "MainActivity onCreate");
        
        setContentView(R.layout.activity_main);
        
        datasource = new FavoriteDataSource(this);
        datasource.open();

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
        
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }
    
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        
        System.out.println( "MainActivity onDestroy");
        
        datasource.close();
        
    }
}
