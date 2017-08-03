package com.longyuan.restapitest.utils;

import com.longyuan.restapitest.data.Promotion;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;
import rx.Single;

/**
 * Created by loxu on 02/08/2017.
 */

public interface PromotionRxAPI {

    String BASE_URL = "http://10.0.2.2:1337";

    @GET("/promotion")
    //Observable<List<Promotion>> getPromotions();
    //Observable<List<Promotion>> getPromotions();
    Single<List<Promotion>> getPromotions();

}
