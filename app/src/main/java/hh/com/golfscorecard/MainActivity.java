package hh.com.golfscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private Hole[] mHoles = new Hole[18];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize holes
        int strokes = 0;
        for(int i=0 ; i< mHoles.length ;i++) {
            mHoles[i] = new Hole("Hole" + (i + 1) + " :", 0);
        }

    }
}
