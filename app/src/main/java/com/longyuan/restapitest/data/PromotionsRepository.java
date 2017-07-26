package com.longyuan.restapitest.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loxu on 26/07/2017.
 */

public class PromotionsRepository {

    private static  List<Promotion> mPromotions;

    static {
        mPromotions = new ArrayList<Promotion>();
        mPromotions.add(new Promotion("1","Better 1"));
        mPromotions.add(new Promotion("2","Good 1"));
        mPromotions.add(new Promotion("3","Good 2"));

    }

    private static PromotionsRepository INSTANCE = null;

    private PromotionsRepository() {
    }

    public static PromotionsRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PromotionsRepository();
        }
        return INSTANCE;
    }

    public List<Promotion> getPromotions(){

        return mPromotions;
    }

}
