package com.example.gaurav.source.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gaurav on 19/10/16.
 */

public interface ApiInterface {
    @GET("starships")
    Call<ShipInfoResponse> getShipInfo(@Query("page") int page);
}
