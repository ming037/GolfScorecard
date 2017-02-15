package hh.com.golfscorecard;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ListActivity {


    private static final String PREFS_FILE = "hh.com.golfscorecard.preferences";
    private static final String KEY_STROKEDCOUNT = "key_strokecount" ;
    private Hole[] mHoles = new Hole[18];
    private ListAdapter mListAdapter;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize SharedPreferences
        mSharedPreferences =  getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        //Initialize holes
        int strokes = 0;
        for(int i=0 ; i< mHoles.length ;i++) {
            strokes = mSharedPreferences.getInt(KEY_STROKEDCOUNT+i, 0);
            mHoles[i] = new Hole("Hole" + (i + 1) + " :", strokes);
        }

        mListAdapter = new ListAdapter(this, mHoles);
        setListAdapter(mListAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();

        for(int i=0; i<mHoles.length ;i++)
        {
            mEditor.putInt(KEY_STROKEDCOUNT+i, mHoles[i].getStrokeCount());
        }
        mEditor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_strokes) {
            //remove all SharedPreferences
            mEditor.clear();
            mEditor.apply();

            for(Hole hole: mHoles)
            {
                hole.setStrokeCount(0);
            }

            mListAdapter.notifyDataSetChanged();
            //이거 없으면 clear버튼 눌렀을 때 데이터는 초기화 되지만
            //화면에는 초기화 되지 않음
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
