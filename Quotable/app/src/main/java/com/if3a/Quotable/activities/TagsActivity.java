package com.if3a.Quotable.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.if3a.Quotable.R;
import com.if3a.Quotable.adapters.MainViewAdapter;
import com.if3a.Quotable.adapters.TagsViewAdapter;
import com.if3a.Quotable.api.APIRequestData;
import com.if3a.Quotable.api.RetroServer;
import com.if3a.Quotable.model.results;
import com.if3a.Quotable.model.rootQuote;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TagsActivity extends AppCompatActivity {

    private RecyclerView rvtags;

    private ArrayList<results> listQuote;
    private TagsViewAdapter adapterQuote;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        ImageButton imgbutton;

        imgbutton = findViewById(R.id.ib_balik);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TagsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        rvtags = findViewById(R.id.rv_tags);

//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CreateActivity.class));
//            }
//        });
        linearLayoutManager = new LinearLayoutManager(TagsActivity.this);
        rvtags.setLayoutManager(linearLayoutManager);

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
        Call <ArrayList<results>> retrieveProcess = ardData.getTags();
        retrieveProcess.enqueue(new Callback <ArrayList<results>>() {
            @Override
            public void onResponse(Call<ArrayList<results>> call, Response<ArrayList<results>> response)
            {
                listQuote = response.body();
                adapterQuote = new TagsViewAdapter(listQuote);
                rvtags.setAdapter(adapterQuote);
            }

            @Override
            public void onFailure(Call <ArrayList<results>>call, Throwable t)
            {
                Toast.makeText(TagsActivity.this, "Gagal menghubungi server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("CEK :", t.getMessage());


            }
        });


    }
}
