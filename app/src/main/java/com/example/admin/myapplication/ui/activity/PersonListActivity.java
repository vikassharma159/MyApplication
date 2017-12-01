package com.example.admin.myapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.backend.presenter.InformationPresenter;
import com.example.admin.myapplication.ui.adapter.InformationAdapter;

public class PersonListActivity extends BaseActivity {
    private InformationAdapter informationAdapter = null;
    private RecyclerView personRecyclerView;
    private InformationPresenter informationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list_item);
        setTitle(getString(R.string.person_list));
        displayToolbar();
        findAllID();
        setUpRecyclerView();
        initialization();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        personRecyclerView.setLayoutManager(linearLayoutManager);
        personRecyclerView.setNestedScrollingEnabled(true);
    }

    private void findAllID() {
        personRecyclerView = findViewById(R.id.person_list_recycler_view);
    }

    private void initialization() {
        informationPresenter = new InformationPresenter();
        informationAdapter = new InformationAdapter(this, informationPresenter.getPersonInformationList());
        personRecyclerView.setAdapter(informationAdapter);
    }
}
