package com.example.gaurav.source;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gaurav.source.adapter.ShipAdapter;
import com.example.gaurav.source.model.ShipInfo;
import com.example.gaurav.source.model.ShipInfoResponse;
import com.example.gaurav.source.rest.ApiClient;
import com.example.gaurav.source.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiService;
    private List<ShipInfo> AllResults =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        SpaceApi(1);
    }

    public void SpaceApi(final int page){
        Call<ShipInfoResponse> call= apiService.getShipInfo(page);//type of api
        call.enqueue(new Callback<ShipInfoResponse>() {
            @Override
            public void onResponse(Call<ShipInfoResponse> call, Response<ShipInfoResponse> response) {
                Log.d("Response size ship"," " + response.body().getResults().toString());
                Log.d("Response "," " + response.body().getResults().get(0).getName());
                for(int i=0;i<response.body().getResults().size();i++){
                    AllResults.add(response.body().getResults().get(i));
                }
                if(page<4)
                    SpaceApi(page+1);
                else {
                    Log.d("Response Size", "" + AllResults.get(0).getName());
                    //sortArray();
                    initRecycler();
                }
            }

            @Override
            public void onFailure(Call<ShipInfoResponse> call, Throwable t) {
                t.printStackTrace();

                Log.d("Response ship", "Error");
            }
        });

    }



    void initRecycler(){
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ShipAdapter(AllResults.subList(0,15)));

    }

}
