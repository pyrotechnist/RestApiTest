package com.longyuan.restapitest.data;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.longyuan.restapitest.utils.ApiAction;
import com.longyuan.restapitest.utils.LoadDataCallback;
import com.longyuan.restapitest.utils.PromotionAPI;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by loxu on 26/07/2017.
 */

public class PromotionsRepository {

    private static List<Promotion> mPromotions;

    private static LoadDataCallback mLoadDataCallback;

    private ApiAction action;

    private PromotionAPI mPromotionAPI;

    private static Map<String, Promotion> mCachedPromotions = new LinkedHashMap<>();

    static {
        mPromotions = new ArrayList<Promotion>();
        mPromotions.add(new Promotion("1", "Better 1"));
        mPromotions.add(new Promotion("2", "Good 1"));
        mPromotions.add(new Promotion("3", "Good 2"));

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

    public void getPromotions(LoadDataCallback callback) throws IOException {
        getPromotions(callback, false);

    }

    public void getPromotions(LoadDataCallback callback, boolean forceUpdate) throws IOException {

        mLoadDataCallback = callback;

        action = ApiAction.Find;


     /*   OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder()
                    .url("http://localhost:1337/promotion")
                    .build();

            Response response = client.newCall(request).execute();
            String res =  response.body().string();*/

       /* OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.d("TAG",response.body().string());
                //callback.onDataNotAvailable();

                callback.onTasksLoaded(response.body().toString());
            }
        });*/


        // OKHTTP solution
        /*if (!forceUpdate && !mCachedPromotions.isEmpty()) {

            callback.onTasksLoaded(new ArrayList<Promotion>(mCachedPromotions.values()));
        } else {

            OkHttpHandler okHttpHandler = new OkHttpHandler();

            okHttpHandler.execute("http://10.0.2.2:1337/promotion");
        }*/


        createPromotionsAPI();
        mPromotionAPI.getPromotions().enqueue(promotionCallback);


    }

    public void deletePromotion(String promotionId, LoadDataCallback callback) {

        action = ApiAction.Destroy;

        mLoadDataCallback = callback;

        //OkHttpHandler okHttpHandler = new OkHttpHandler();

        ///okHttpHandler.execute("http://10.0.2.2:1337/promotion/destroy/" + promotionId);

    }


    private void createPromotionsAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PromotionAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mPromotionAPI = retrofit.create(PromotionAPI.class);
    }

    Callback<List<Promotion>> promotionCallback = new Callback<List<Promotion>>() {
        @Override
        public void onFailure(Call<List<Promotion>> call, Throwable t) {

        }

        @Override
        public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {
            if (response.isSuccessful()) {
                List<Promotion> data = new ArrayList<>();
                data.addAll(response.body());
                mLoadDataCallback.onTasksLoaded(data);
                //recyclerView.setAdapter(new RecyclerViewAdapter(data));
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }
    };




    /*
    public class OkHttpHandler extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //mMainFragment.showProgressDialog();
        }

        @Override
        protected String doInBackground(String... params) {

            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();
            OkHttpClient client = new OkHttpClient();
            try {

                Response response = client.newCall(request).execute();
                ResponseBody body = response.body();

                String dd = response.body().string();


                return dd;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            String promotionJson = s;

            Gson gson = new GsonBuilder().create();

            if (action == ApiAction.Find) {

                List<Promotion> promotions = gson.fromJson(s, new TypeToken<List<Promotion>>() {
                }.getType());

                mCachedPromotions.clear();
                for (Promotion promotion : promotions) {
                    mCachedPromotions.put(promotion.getId(), promotion);
                }

                mLoadDataCallback.onTasksLoaded(promotions);

            } else if (action == ApiAction.Destroy) {
                Promotion promotion = gson.fromJson(s, Promotion.class);

                if (promotion != null) {
                    mCachedPromotions.remove(promotion.getId());
                    mLoadDataCallback.onTasksLoaded(new ArrayList<Promotion>(mCachedPromotions.values()));
                }
            }
        }
    }*/


}
