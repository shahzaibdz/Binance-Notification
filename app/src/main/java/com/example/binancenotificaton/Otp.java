package com.example.binancenotificaton;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Otp extends AppCompatActivity {
    Button btnSubmit , btnGetCode;
    EditText etVerificationCode;
    private static final String KEY_TEXT_REPLY = "key_text_reply";
    private static final String KEY_TEXT = "CH2";

    private static final String CHANNEL_ID = "1";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        btnSubmit = findViewById(R.id.btnSubmit);
        etVerificationCode = findViewById(R.id.etVerificationCode);
        btnGetCode = findViewById(R.id.getCode);
        Intent intent = new Intent(this, NotificationResponse.class);
        PendingIntent pendingIntent  = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_IMMUTABLE);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = etVerificationCode.getText().toString();
                if (otp.length() == 6 && otp.matches("[0-9]+")){
                    Intent intent = new Intent(Otp.this, vedio_binance.class);
                    startActivity(intent);
                }else{
                    etVerificationCode.setError("Enter valid OTP");
                }
            }
        });

        String bigText = "Your verification code: \n" +
                "121156\n" +
                "The verification code will be valid for 30 minutes. Please do not share this code with anyone. Don’t recognize this activity? Please  reset your password and contact  customer support immediately. \n" +
                "This is an automated message, please do not reply";

//        String replyLabel = getResources().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Binance")
                .setSmallIcon(R.drawable.img)
                .setContentText( "Your verification code: \n" +
                        "121156\n")
                .addAction(R.drawable.img, "Archive", pendingIntent)
                .addAction(R.drawable.img, "Reply", pendingIntent)
                .setColor(getResources().getColor(R.color.yellow))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                notificationManager.notify(1, notification);
            }
        });
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Binance")
                .setContentText("Down")
                .setSmallIcon(R.drawable.img)
                .setOngoing(true)
                .addAction(R.drawable.img, "Cancel", pendingIntent)
                .addAction(R.drawable.img, "Manage Notification", pendingIntent)
                .setColor(getResources().getColor(R.color.yellow))
                .setPriority(NotificationCompat.PRIORITY_HIGH);
                builder.setCategory(NotificationCompat.CATEGORY_PROGRESS);


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);


        }

// Issue the initial notification with zero progress.
        int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 0;
        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, true);
        notificationManager.notify(1, builder.build());

// Do the job that tracks the progress here.
// Usually, this is in a worker thread.
// To show progress, update PROGRESS_CURRENT and update the notification with:
// builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
// notificationManager.notify(notificationId, builder.build());

// When done, update the notification once more to remove the progress bar.
        builder.setContentText("28 seconds left")
                .setProgress(PROGRESS_MAX,PROGRESS_CURRENT,true);
        notificationManager.notify(1, builder.build());
    }
}