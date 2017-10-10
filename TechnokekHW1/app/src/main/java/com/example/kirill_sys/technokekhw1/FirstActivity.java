package com.example.kirill_sys.technokekhw1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private int currentTime = 0;
    private int extraTime = 0;

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        currentTime = 0;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        timer = new CountDownTimer(2000 - extraTime, 100) {
            public void onTick(long millisUntilFinished) {
                currentTime = 2000 - (int) millisUntilFinished;
            }

            public void onFinish() {
                extraTime = 0;
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (currentTime != 0)
            timer.cancel();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(ConstData.STATE_TIME_1, currentTime);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        extraTime = savedInstanceState.getInt(ConstData.STATE_TIME_1);
    }
}
