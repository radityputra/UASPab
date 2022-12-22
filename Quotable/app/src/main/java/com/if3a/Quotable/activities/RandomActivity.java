package com.if3a.Quotable.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.if3a.Quotable.R;
import com.if3a.Quotable.adapters.MainViewAdapter;
import com.if3a.Quotable.adapters.RandomViewAdapter;
import com.if3a.Quotable.api.APIRequestData;
import com.if3a.Quotable.api.RetroServer;
import com.if3a.Quotable.model.Random;
import com.if3a.Quotable.model.results;
import com.if3a.Quotable.model.rootQuote;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomActivity extends AppCompatActivity {

    private TextView tvcontent, tvauthor;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        ImageButton imgbutton;

        imgbutton = findViewById(R.id.ib_balik);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RandomActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        tvcontent = findViewById(R.id.tv_content);
        tvauthor = findViewById(R.id.tv_author);


//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CreateActivity.class));
//            }
//        });
        linearLayoutManager = new LinearLayoutManager(RandomActivity.this);

        retrieveQuote();
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveQuote();
    }



    private void retrieveQuote() {
//        pbQuote.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<Random>retrieveProcess = ardData.getRandom();
        retrieveProcess.enqueue(new Callback<Random>() {
            @Override
            public void onResponse(Call<Random> call, Response<Random> response)
            {
                tvcontent.setText(response.body().getContent());
                tvauthor.setText("''" +response.body().getAuthor() +"''");
            }

            @Override
            public void onFailure(Call<Random> call, Throwable t)
            {
                Toast.makeText(RandomActivity.this, "Gagal menghubungi server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("CEK :", t.getMessage());


            }
        });


    }
}
