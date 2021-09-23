package com.ridoy.notificationserveradmin.API;

import com.ridoy.notificationserveradmin.Constants;
import com.ridoy.notificationserveradmin.Model.PushNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    @Headers({"Authorization: key="+ Constants.SERVER_KEY,"Content-Type:"+Constants.CONTENT_TYPE})
    @POST("fcm/send")
    Call<PushNotification> sendNotification(@Body PushNotification notification);
}
