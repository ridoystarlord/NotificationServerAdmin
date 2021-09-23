package com.ridoy.notificationserveradmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ridoy.notificationserveradmin.API.APIUtilities;
import com.ridoy.notificationserveradmin.Model.NotificationData;
import com.ridoy.notificationserveradmin.Model.PushNotification;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> {

                PushNotification notification=new PushNotification(new NotificationData("title_Txt","message_Txt"),Constants.TOPIC);
                sendNotification(notification);

        });
    }
    private void sendNotification(PushNotification notification) {

        APIUtilities.getClient().sendNotification(notification).enqueue(new Callback<PushNotification>() {
            @Override
            public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PushNotification> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure:"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}