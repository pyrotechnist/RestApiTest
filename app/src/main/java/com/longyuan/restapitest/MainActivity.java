package com.longyuan.restapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.longyuan.restapitest.data.PromotionsRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_content);

        if(mainFragment == null)
        {
            mainFragment  = MainFragment.getInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_content,mainFragment).commit();

        }

        new MainPresenter(PromotionsRepository.getInstance(),mainFragment);

    }
}
