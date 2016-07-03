package rungame.stantarun;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int  initial = 1;
    private final int  running_time = 2;
    private final int  setting = 3;
    private final int  exit = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch(getIntent().getIntExtra("fragment_id",1)){
            case initial:
                Initial initial = new Initial();
                fragmentTransaction.add(R.id.fragment_container, initial);
                break;
            case running_time:
                RunningTimeFragment runningTimeFragment = new RunningTimeFragment();
                fragmentTransaction.add(R.id.fragment_container, runningTimeFragment);
                break;
            case setting:
                SettingFragment settingFragment = new SettingFragment();
                fragmentTransaction.add(R.id.fragment_container, settingFragment);
                break;
            case exit:
                System.exit(0);
                break;
        }
        fragmentTransaction.commit();
    }
}
