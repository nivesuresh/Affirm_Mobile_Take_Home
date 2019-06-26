package com.takehome.affirm.affirm_mobile_take_home;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nivesuresh on 6/23/19.
 */

public interface FlickrService {
    @GET("rest/?")
    Observable<Photos> getPhotosFromFlickr(@Query("method") String method, @Query("api_key") String apiKey,
                                           @Query("text") String searchText, @Query("extras") String extras,
                                           @Query("format") String format, @Query("nojsoncallback") int callback,
                                           @Query("page") int page);
}
