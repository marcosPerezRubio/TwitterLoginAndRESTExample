package com.example.marcos.twitterloginandrestexample;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTActivity extends AppCompatActivity implements View.OnClickListener {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.foaas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    FOAASInterface service = retrofit.create(FOAASInterface.class);

    Button version;
    Button nugget;
    Button fascinating;
    Button that;
    EditText et_from;
    EditText et_name;
    TextView tv_result;
    final Context context =  this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        version = (Button) findViewById(R.id.button_version);
        nugget = (Button) findViewById(R.id.button_nugget);
        fascinating = (Button) findViewById(R.id.button_fascinating);
        that = (Button) findViewById(R.id.button_that);

        et_from = (EditText) findViewById(R.id.edit_from);
        et_name = (EditText) findViewById(R.id.edit_name);

        tv_result = (TextView) findViewById(R.id.tv_result);

        version.setOnClickListener(this);
        nugget.setOnClickListener(this);
        fascinating.setOnClickListener(this);
        that.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        String from = et_from.getText().toString();
        switch (v.getId()){
            case R.id.button_version:
                getVersion();
                break;
            case R.id.button_that:
                getThat(from);
                break;
            case R.id.button_fascinating:
                getFascinating(from);
                break;
            case R.id.button_nugget:
                getNugget(name,from);
                break;
        }
    }

    private void getVersion() {
        service.getVersion().enqueue(new Callback<FOOASMessage>() {
            @Override
            public void onResponse(Call<FOOASMessage> call, Response<FOOASMessage> response) {
                String version = response.body().getMessage();
                tv_result.setText(version);
            }

            @Override
            public void onFailure(Call<FOOASMessage> call, Throwable t) {
                Toast.makeText(context,"Error on request",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getThat(String from) {
        service.getThat(from).enqueue(new Callback<FOOASMessage>() {
            @Override
            public void onResponse(Call<FOOASMessage> call, Response<FOOASMessage> response) {
                String message = response.body().getMessage();
                String subtitle = response.body().getSubtitle();
                tv_result.setText(message + subtitle);
            }

            @Override
            public void onFailure(Call<FOOASMessage> call, Throwable t) {
                Toast.makeText(context,"Error on request",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getNugget(String name, String from) {
        service.getNugget(name,from).enqueue(new Callback<FOOASMessage>() {
            @Override
            public void onResponse(Call<FOOASMessage> call, Response<FOOASMessage> response) {
                String message = response.body().getMessage();
                String subtitle = response.body().getSubtitle();
                tv_result.setText(message + subtitle);
            }

            @Override
            public void onFailure(Call<FOOASMessage> call, Throwable t) {
                Toast.makeText(context,"Error on request",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getFascinating(String from) {
        service.getFascinating(from).enqueue(new Callback<FOOASMessage>() {
            @Override
            public void onResponse(Call<FOOASMessage> call, Response<FOOASMessage> response) {
                String message = response.body().getMessage();
                String subtitle = response.body().getSubtitle();
                tv_result.setText(message + subtitle);
            }

            @Override
            public void onFailure(Call<FOOASMessage> call, Throwable t) {
                Toast.makeText(context,"Error on request",Toast.LENGTH_LONG).show();
            }
        });
    }

}
