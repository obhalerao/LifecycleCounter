package trap1.bhaleraoomkar.lifecyclecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int created = 0;
    int started = 0;
    int resumed = 0;
    int paused = 0;
    int stopped = 0;
    int restarted = 0;
    int destroyed = 0;

    int totalCreated = 0;
    int totalStarted = 0;
    int totalResumed = 0;
    int totalPaused = 0;
    int totalStopped = 0;
    int totalRestarted = 0;
    int totalDestroyed = 0;

    String[] names;

    String[] spnames;

    Counter[] variables = new Counter[7];

    TextView text1;
    Button button;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            for(int i = 0; i < 7; i++){
                variables[i].setTotalCount(0);
                variables[i].setCount(0);
            }
            editor.putInt(getString(R.string.sp6), variables[5].getTotalCount());
            editor.apply();
            text1.setText(getString(R.string.template,
            getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
            getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
            getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
            getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
            getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
            getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
            getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new String[]{"onCreate()", "onStart()", "onResume()", "onPause()", "onStop()", "onRestart()", "onDestroy()"};
        spnames = new String[]{getString(R.string.sp1), getString(R.string.sp2),getString(R.string.sp3),getString(R.string.sp4),getString(R.string.sp5),getString(R.string.sp6),getString(R.string.sp7)};


        sharedPref = getSharedPreferences(getString(R.string.sharedprefs), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        for(int i = 0; i < 7; i++){
            variables[i] = new Counter(names[i]);
            variables[i].setTotalCount(sharedPref.getInt(spnames[i], 0));
        }



        totalCreated = sharedPref.getInt(getString(R.string.sp1), 0);
        totalStarted = sharedPref.getInt(getString(R.string.sp2), 0);
        totalResumed = sharedPref.getInt(getString(R.string.sp3), 0);
        totalPaused = sharedPref.getInt(getString(R.string.sp4), 0);
        totalStopped = sharedPref.getInt(getString(R.string.sp5), 0);
        totalRestarted = sharedPref.getInt(getString(R.string.sp6), 0);
        totalDestroyed = sharedPref.getInt(getString(R.string.sp7), 0);

        text1 = (TextView)findViewById(R.id.text1);
        button = (Button)findViewById(R.id.button);

        variables[0].incrCount();
        variables[0].incrTotalCount();
        editor.putInt(getString(R.string.sp1), variables[0].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
                getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
                getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
                getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
                getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
                getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
                getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
                getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
        button.setOnClickListener(reset);


    }

    @Override
    protected void onStart(){
        super.onStart();
        variables[1].incrCount();
        variables[1].incrTotalCount();
        editor.putInt(getString(R.string.sp2), variables[1].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }

    @Override
    protected void onResume(){
        super.onResume();
        variables[2].incrCount();
        variables[2].incrTotalCount();
        editor.putInt(getString(R.string.sp3), variables[2].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }

    @Override
    protected void onPause(){
        super.onPause();
        variables[3].incrCount();
        variables[3].incrTotalCount();
        editor.putInt(getString(R.string.sp4), variables[3].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }

    @Override
    protected void onStop(){
        super.onStop();
        variables[4].incrCount();
        variables[4].incrTotalCount();
        editor.putInt(getString(R.string.sp5), variables[4].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        variables[5].incrCount();
        variables[5].incrTotalCount();
        editor.putInt(getString(R.string.sp6), variables[5].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        variables[6].incrCount();
        variables[6].incrTotalCount();
        editor.putInt(getString(R.string.sp7), variables[6].getTotalCount());
        editor.apply();
        text1.setText(getString(R.string.template,
        getString(R.string.text2, variables[0].getName(), variables[0].getCount(), variables[0].getTotalCount()),
        getString(R.string.text2, variables[1].getName(), variables[1].getCount(), variables[1].getTotalCount()),
        getString(R.string.text2, variables[2].getName(), variables[2].getCount(), variables[2].getTotalCount()),
        getString(R.string.text2, variables[3].getName(), variables[3].getCount(), variables[3].getTotalCount()),
        getString(R.string.text2, variables[4].getName(), variables[4].getCount(), variables[4].getTotalCount()),
        getString(R.string.text2, variables[5].getName(), variables[5].getCount(), variables[5].getTotalCount()),
        getString(R.string.text2, variables[6].getName(), variables[6].getCount(), variables[6].getTotalCount())));
    }
}
