package com.example.kontak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kontak.Adapter.KontakAdapter;
import com.example.kontak.Model.GetKontak;
import com.example.kontak.Model.Kontak;
import com.example.kontak.Rest.ApiClient;
import com.example.kontak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAEdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }
        });
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }
    public void refresh(){
        final Call<GetKontak> kontakCall = mApiInterface.getKontak();
        kontakCall.enqueue(new Callback<GetKontak>() {
            @Override
            public void onResponse(Call<GetKontak> call, Response<GetKontak> response) {
                List<Kontak> KontakList = response.body().getListDataKontak();
                Log.d("Retrofit Get ","Jumlah Data Kontak: "+String.valueOf(KontakList.size()));
                mAEdapter = new KontakAdapter(KontakList);
                mRecyclerview.setAdapter(mAEdapter);
            }

            @Override
            public void onFailure(Call<GetKontak> call, Throwable t) {
                Log.e("Retrofit Get",t.toString());
            }
        });
    }
}
