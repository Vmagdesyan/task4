package com.example.task4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;
public class MainActivity extends AppCompatActivity implements Main.OnBtnPress {
    private Main main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = new Main();
        setCurrentFragment(main, false);
    }
    private void setCurrentFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void btnPressed(int btn) {
        switch (btn){
            case Main.WEB_BUTTON:
                setCurrentFragment(new WebFragment(), true);
                break;
            case Main.IMAGE_BUTTON:
                setCurrentFragment(new ImageFragment(), true);
                break;
            case Main.TEXT_BUTTON_1:
                setCurrentFragment(FirstTextFragment.getInstance("Привет, это первая статья"), true);
                break;
            case Main.TEXT_BUTTON_2:
                setCurrentFragment(SecondTextFragment.getInstance("Привет, это вторая статья"), true);
                break;
        }
    }
    protected void onPause(){
        main.removeBtnPressListener();
        super.onPause();
    }
    protected void onResume(){
        super.onResume();
        main.setBtnPressListener(this);
    }
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            if (getFragmentManager().getBackStackEntryCount() == 1) {
                Toast toast = Toast.makeText(getApplicationContext(),"Приложение закроется", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
                super.onBackPressed();
    }

}
