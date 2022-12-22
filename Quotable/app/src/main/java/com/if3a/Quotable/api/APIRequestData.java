package com.if3a.Quotable.api;

import com.if3a.Quotable.model.Random;
import com.if3a.Quotable.model.results;
import com.if3a.Quotable.model.rootAuthors;
import com.if3a.Quotable.model.rootQuote;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIRequestData

{
    @GET("quotes")
    Call<rootQuote> getQuotes();

    @GET("authors")
    Call<rootAuthors> getAuthors();

    @GET("random")
    Call<Random> getRandom();

//    @GET("tags")
//    Call<ArrayList<results>> getTags();

        @GET("tags")
    Call<ArrayList<results>> getTags();



}
