package com.longyuan.restapitest.utils;

import com.longyuan.restapitest.data.Promotion;

import java.util.List;
import java.util.Map;

/**
 * Created by LONGYUAN on 2017/7/26.
 */

public interface LoadDataCallback {

    void onTasksLoaded(List<Promotion> promotionList);

   // void onDataNotAvailable();

}
