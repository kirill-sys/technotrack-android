package com.example.kirill_sys.technokekhw1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        new CountDownTimer(2000, 100) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
//                Toast.makeText(FirstActivity.this, "Finish", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }


}
