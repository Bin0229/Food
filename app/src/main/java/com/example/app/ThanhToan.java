package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThanhToan extends AppCompatActivity {
    private TextView tv;
    private ArrayList<String> Result;
    private List<Food_Infor> mListFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        tv = findViewById(R.id.HoaDon);
        Result =new ArrayList<>();
        tv.setEnabled(false);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

    }
}