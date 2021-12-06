package com.example.app;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Foodlist extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private RecyclerView rcv;
    private FoodAdater mFoodAdapter;
    private List<Food_Infor> mListFood;

    //EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist);
        findId();
        Bundle bundle = new Bundle();
        getListFoodFromDataBase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Foodlist.this,ThanhToan.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    private void findId() {
        btn=findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        rcv=findViewById(R.id.rcv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcv.addItemDecoration(dividerItemDecoration);

        mListFood = new ArrayList<>();
        mFoodAdapter = new FoodAdater(mListFood);

        rcv.setAdapter(mFoodAdapter);
    }

    private void getListFoodFromDataBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Food_Infor");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(mListFood != null){
                    mListFood.clear();
                }

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Food_Infor food_infor = dataSnapshot.getValue(Food_Infor.class);
                    mListFood.add(food_infor);
                }

                mFoodAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Foodlist.this,"Get Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }


}