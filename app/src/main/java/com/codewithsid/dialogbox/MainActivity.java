package com.codewithsid.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.codewithsid.dialogbox.models.Models;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // https://backend-test-zypher.herokuapp.com




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CallRerofit();



    }

    private void CallRerofit() {

        DialogBoxe dialogBoxe = DialogBoxe.getInstance();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://backend-test-zypher.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


       PostRetrofitApi postRetrofitApi = retrofit.create(PostRetrofitApi.class);


        Call<Models> call = postRetrofitApi.postDataIntoServer();
        call.enqueue(new Callback<Models>() {
            @Override
            public void onResponse(Call<Models> call, Response<Models> response) {


                Models models = response.body();

                //Display the result

                Log.d("tag","yess"+models.getTitle());


                   dialogBoxe.showDialogBox(MainActivity.this,models);

            }

            @Override
            public void onFailure(Call<Models> call, Throwable t) {

            }
        });


    }





}