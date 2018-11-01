package com.smartron.sid.bytridgesample.network;


import com.smartron.sid.bytridgesample.model.GetCompleteResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface NetworkApi {
    String BASE_URL = "http://www.mocky.io";


    @GET("/v2/59a66706100000fb0408fbb3")
    Observable<GetCompleteResponse> getDetails();


    /*@GET("/api/auth/user/details")
    Observable<String> userDetails(@Header("User-Agent") String userAgent,
                                   @Header("X-DeviceId") String deviceId,
                                   @Header("X-UserId") String email,
                                   @Header("X-RequestId") String requestID,
                                   @Header("X-Authorization") String sessionID,
                                   @Header("X-ProtocolVersion")String protocolVersion);*/

}
