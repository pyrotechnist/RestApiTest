package com.longyuan.restapitest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longyuan.restapitest.data.Promotion;
import com.longyuan.restapitest.utils.PromotionsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loxu on 26/07/2017.
 */

public class MainFragment extends Fragment implements MainContarct.View{

    private MainContarct.Presenter mPresenter;

    private PromotionsRecyclerViewAdapter mPromotionsRecyclerViewAdapter;

    private RecyclerView mRecyclerView;


    public static MainFragment getInstance() {
        return  new MainFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View roorView = inflater.inflate(R.layout.activity_frag,container,false);


        mRecyclerView = (RecyclerView) roorView.findViewById(R.id.promotions_list);

        mPromotionsRecyclerViewAdapter = new PromotionsRecyclerViewAdapter(new ArrayList<Promotion>());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(mPromotionsRecyclerViewAdapter);

        return roorView;
    }

    @Override
    public void displayPromnotions(List<Promotion> promotionList) {
        mPromotionsRecyclerViewAdapter.replaceData(promotionList);
    }

    @Override
    public void setPresenter(MainContarct.Presenter presenter) {

        mPresenter = presenter;
    }
}
