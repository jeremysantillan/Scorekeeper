package tech.hyperdev.scorekeeper.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.Utils;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragment_1, mFragment_2;
    private int mFlag = 0;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nightmode) {
            if(mFlag==0) {
                item.setTitle(R.string.day_mode);
                Utils.changeToTheme(MainActivity.this, 1);
                mFlag = 1;
            }else{
                item.setTitle(R.string.night_mode);
                Utils.changeToTheme(MainActivity.this, 0);
                mFlag = 0;
            }



//                Utils.changeToTheme(MainActivity.this, 0);
//                item.setTitle(R.string.night_mode);
        }


        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main);


        mFragment_1 = ScoreFragment.newInstance("Team 1");
        mFragment_2 = ScoreFragment.newInstance("Team 2");


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_fragment_1, mFragment_1).replace(R.id.layout_fragment_2, mFragment_2).commit();


    }
}
