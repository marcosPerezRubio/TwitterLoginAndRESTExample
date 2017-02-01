package com.example.marcos.twitterloginandrestexample;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.foaas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    FOAASInterface service = retrofit.create(FOAASInterface.class);

    final Context context =  this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVersion();
            }
        });

    }

    private void getVersion() {
        Log.d("sup","suuuuup");
        service.getVersion().enqueue(new Callback<FOOASMessage>() {
            @Override
            public void onResponse(Call<FOOASMessage> call, Response<FOOASMessage> response) {
                Log.d("sup","success");
                String version = response.body().getMessage();
                String subtitle = response.body().getSubtitle();
                Toast.makeText(context,"Version is " + version + " subtitle " + subtitle,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<FOOASMessage> call, Throwable t) {
                Toast.makeText(context,"Error on request",Toast.LENGTH_LONG).show();
            }
        });
    }

}
