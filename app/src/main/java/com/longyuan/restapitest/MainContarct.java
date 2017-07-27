package com.longyuan.restapitest;

import com.longyuan.restapitest.data.Promotion;

import java.util.List;

/**
 * Created by loxu on 26/07/2017.
 */

public class MainContarct {

    interface View{

        void setPresenter(Presenter presenter);

        void displayPromnotions(List<Promotion> promotionList);

    }

    interface Presenter{

        void start();

        void loadPromotions();

        void deletePromotions(String promotionId);


    }

}
