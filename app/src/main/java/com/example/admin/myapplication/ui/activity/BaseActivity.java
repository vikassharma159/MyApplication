package com.example.admin.myapplication.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.admin.myapplication.R;

/**
 * Created by admin on 05/11/17.
 */

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        RelativeLayout baseView = (RelativeLayout) getLayoutInflater().inflate(R.layout.base_activity_layout, null);
        FrameLayout container = baseView.findViewById(R.id.container);
        toolbar = baseView.findViewById(R.id.toolbar);

        toolbar.setTitle("");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white_text));
        setSupportActionBar(toolbar);
        getLayoutInflater().inflate(layoutResID, container, true);
        setContentView(baseView);
    }

    protected void setTitle(String title) {
        if (null != getSupportActionBar()) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void displayToolbar() {
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
