package com.longyuan.restapitest.data;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.util.Log;

import com.longyuan.restapitest.utils.LoadDataCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;

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

    public List<Promotion> getPromotions() throws IOException{

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




        return mPromotions;
    }

    /**
     *
     */
    public class OkHttpHandler extends AsyncTask<String,String,String> {

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

       /* protected void onProgressUpdate(String... progress) {
            Log.d("ANDRO_ASYNC", progress[0]);
            mMainFragment.updateDialog(Integer.parseInt(progress[0]));
        }
*/

        @Override
        protected void onPostExecute(String s) {
            //mMainFragment.dismissProgressDialog();
            //mMainFragment.showTestcases(s);

        }
    }

}
