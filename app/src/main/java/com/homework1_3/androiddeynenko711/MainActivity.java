package com.homework1_3.androiddeynenko711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSync = findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                ZoneId zoneId = ZoneOffset.UTC;
                LocalTime localTime = LocalTime.now(zoneId);
                if ((localTime.isAfter(LocalTime.of(6, 0)) ||
                        (localTime.isBefore(LocalTime.of(14, 0))))) {
                    intent.setData(Uri.parse("http://morning"));
                }
                if ((localTime.isAfter(LocalTime.of(14, 0)) ||
                        (localTime.isBefore(LocalTime.of(20, 0))))) {
                    intent.setData(Uri.parse("http://afternoon"));
                }
                if ((localTime.isAfter(LocalTime.of(20, 0)) ||
                        (localTime.isBefore(LocalTime.of(6, 0))))) {
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });
    }
}