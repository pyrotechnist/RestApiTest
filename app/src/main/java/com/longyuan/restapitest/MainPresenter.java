package com.longyuan.restapitest;

import com.longyuan.restapitest.data.Promotion;
import com.longyuan.restapitest.data.PromotionsRepository;
import com.longyuan.restapitest.utils.LoadDataCallback;

import java.io.IOException;
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
    public void loadPromotions() {

        try {
            mPromotionsRepository.getPromotions(new LoadDataCallback() {
                @Override
                public void onTasksLoaded(List<Promotion> promotions) {
                    mMainView.displayPromnotions(promotions);
                }
            });
        }catch (IOException ie){
        }

    }

    @Override
    public void deletePromotions(String promotionId) {
        mPromotionsRepository.deletePromotion(promotionId);
    }

    @Override
    public void start() {
        loadPromotions();
    }
}
