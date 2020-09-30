package com.example.volleylib;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String ImageUrl = null;
    private static final String TAG = "MainActivity";
    private TextView txtView;
    private Button btnShare;
    private ImageView imageView;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        btnShare = findViewById(R.id.btnShare);
        txtView = findViewById(R.id.txtView);
        imageView = findViewById(R.id.imageView);
        btnNext = findViewById(R.id.btnNext);

        getInfo();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfo();
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareInfo();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    private void shareInfo() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        if(ImageUrl != null) {
            intent.putExtra(Intent.EXTRA_TEXT, ImageUrl);
        }
        intent.setType("text/plain");
        startActivity(intent);

        getSupportActionBar().hide();
    }

    private void getInfo(){

        final Gson gson = new Gson();

        String url = "https://meme-api.herokuapp.com/gimme";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Posts post = gson.fromJson(response, Posts.class);
                Posts post = gson.fromJson(response, Posts.class);
                txtView.setText("subreddit: " + post.getSubreddit());
                ImageUrl = post.getUrl();
                Glide.with(getApplicationContext())
                        .asBitmap()
                        .load(post.getUrl())
                        .into(imageView);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> posts = new HashMap<>();
//                posts.put("userId", "4");
//                posts.put("id","5");
//                posts.put("title","shit is gonna get real.");
//                posts.put("body","hello my name is charan kotturi");
//                return posts;
//            }
//        }
        ;

        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d(TAG, "getInfo: >>>>>>>>>>>>>>>>>");
        queue.add(request);
        queue.start();
    }
}