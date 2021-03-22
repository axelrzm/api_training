package fr.esiea.ex4A.service;

import fr.esiea.ex4A.data.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AgifyClient {
    @GET("/?")
    Call<List<User>> getUser(@Query("name") String name, @Query("country_id") String country_id);
}
