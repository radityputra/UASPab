package com.if3a.Quotable.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.if3a.Quotable.R;

public class HomeActivity extends AppCompatActivity {

    private Button btnrandom, btnquote, btnauthor, btntags, btnabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnrandom = findViewById(R.id.btn_random);
        btnquote = findViewById(R.id.btn_quote);
        btnauthor = findViewById(R.id.btn_author);
        btntags = findViewById(R.id.btn_tags);
        btnabout = findViewById(R.id.btn_about);


        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RandomActivity.class);
                startActivity(intent);
            }
        });

        btnquote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnauthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AuthorActivity.class);
                startActivity(intent);
            }
        });

        btntags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TagsActivity.class);
                startActivity(intent);
            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });



    }
}