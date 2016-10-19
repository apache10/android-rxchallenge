package com.example.gaurav.source;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaurav.source.rest.ApiInterface;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
