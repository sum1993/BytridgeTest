package com.smartron.sid.bytridgesample.infoMVP;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;


import com.smartron.sid.bytridgesample.BaseActivity;
import com.smartron.sid.bytridgesample.R;
import com.smartron.sid.bytridgesample.adapter.HorizontolScrollAdapter;
import com.smartron.sid.bytridgesample.adapter.SwaggeredScrollAdapter;

import com.smartron.sid.bytridgesample.model.HorizontalScrollLayout;
import com.smartron.sid.bytridgesample.model.SwaggeredLayout;


import java.util.ArrayList;
import java.util.List;


public class InformationActivity extends BaseActivity implements InfoView {

    private RecyclerView mHoriontolScrollRecyclerView, mSwaggeredRecyclerView;
    private HorizontolScrollAdapter horizontolScrollAdapter;
    private SwaggeredScrollAdapter swaggeredScrollAdapter;
    private InfoPresenter mInfoPresenter;
    private List<SwaggeredLayout> swaggeredLayoutList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        mHoriontolScrollRecyclerView = findViewById(R.id.horizontoll_scroll_layout);
        horizontolScrollAdapter = new HorizontolScrollAdapter(this);
        mHoriontolScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mHoriontolScrollRecyclerView.setAdapter(horizontolScrollAdapter);

        mSwaggeredRecyclerView = findViewById(R.id.swaggered_layout);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        mSwaggeredRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        swaggeredScrollAdapter = new SwaggeredScrollAdapter(this);
        mSwaggeredRecyclerView.setAdapter(swaggeredScrollAdapter);

        mInfoPresenter = new InfoPresenterImpl(this);
        mInfoPresenter.doNewtworkCall();


    }

    @Override
    public void showProgress() {
        showCustomProgressDialog();
    }

    @Override
    public void dismisProgress() {
        dismissCustomProgressDialog();
    }

    @Override
    public void horizontolLayoutDataFetchSuccess(List<HorizontalScrollLayout> horizontalScrollLayout) {
        horizontolScrollAdapter.setData(horizontalScrollLayout);

    }

    @Override
    public void swaggeredlayoutDataFetchSuccess(List<SwaggeredLayout> swaggeredLayout) {
        swaggeredScrollAdapter.setData(swaggeredLayout);
    }

    @Override
    public void onDetailsFetchFaliure(String message) {

        Toast.makeText(this, " "+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInfoPresenter.onDestroy();
    }
}
