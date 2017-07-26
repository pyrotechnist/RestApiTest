package com.longyuan.restapitest;

import com.longyuan.restapitest.data.Promotion;
import com.longyuan.restapitest.data.PromotionsRepository;

import java.util.List;

/**
 * Created by loxu on 26/07/2017.
 */

public class MainPresenter implements MainContarct.Presenter{


    private MainContarct.View mMainView;

    private PromotionsRepository mPromotionsRepository;

    public MainPresenter(PromotionsRepository promotionsRepository,MainContarct.View view){

        mPromotionsRepository = promotionsRepository;
        mMainView = view;
        view.setPresenter(this);
    }

    @Override
    public List<Promotion> loadPromotions() {
        List<Promotion> promotionList =  mPromotionsRepository.getPromotions();
        return  promotionList;
    }


    @Override
    public void start() {
        mMainView.displayPromnotions(loadPromotions());

    }
}
