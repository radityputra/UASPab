package com.if3a.Quotable.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.if3a.Quotable.R;
import com.if3a.Quotable.adapters.MainViewAdapter;
import com.if3a.Quotable.api.APIRequestData;
import com.if3a.Quotable.api.RetroServer;
import com.if3a.Quotable.model.results;
import com.if3a.Quotable.model.rootQuote;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView rvMain;

    private ArrayList<results> listQuote;
    private MainViewAdapter adapterQuote;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imgbutton;

        imgbutton = findViewById(R.id.ib_balik);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        rvMain = findViewById(R.id.rv_quote);
//        pbQuote = findViewById(R.id.pb_quote);
//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CreateActivity.class));
//            }
//        });
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvMain.setLayoutManager(linearLayoutManager);

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
        Call<rootQuote> retrieveProcess = ardData.getQuotes();
        retrieveProcess.enqueue(new Callback<rootQuote>() {
            @Override
            public void onResponse(Call<rootQuote> call, Response<rootQuote> response) {
                listQuote = response.body().getResults();
                adapterQuote = new MainViewAdapter(listQuote);
                rvMain.setAdapter(adapterQuote);
//                pbQuote.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<rootQuote> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal menghubungi server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("CEK :", t.getMessage());
//                pbQuote.setVisibility(View.INVISIBLE);
            }



            {
            }
        });


    }
}