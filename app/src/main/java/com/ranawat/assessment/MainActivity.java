package com.ranawat.assessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ranawat.assessment.adapter.DataAdapter;
import com.ranawat.assessment.model.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ShareActivity.class);
                startActivity(intent);
                finish();
            }
        });


        recyclerView=findViewById(R.id.recycleName);


        apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getmarvel().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.body().size()>0){

                    List<Model> modelList=response.body();
                    dataAdapter=new DataAdapter(MainActivity.this, (ArrayList<Model>) modelList);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(dataAdapter);

                }else {
                    Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}