package com.example.kirill_sys.technokekhw1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private int currentTime = 0;
    private int extraTime = 0;
    private String currentBtn = "start";
    private String currentTv = "";

    private final int maxTimeInSec = 1000;

    private CountDownTimer timer;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        currentTime = 0;

        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);

        tv.setText(currentTv);
        btn.setText(currentBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentBtn.equals(getString(R.string.btnStart))) {
                    currentBtn = getString(R.string.btnStop);
                    btn.setText(currentBtn);

                    startTimer();
                } else {
                    extraTime = 0;
                    currentTime = 0;
                    currentBtn = getString(R.string.btnStart);
                    btn.setText(currentBtn);
                    timer.cancel();
                }
            }
        });
    }

    private void startTimer() {
        timer = new CountDownTimer((maxTimeInSec - extraTime) * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTime = maxTimeInSec - (int) millisUntilFinished / 1000;
                currentTv = ConstData.numberToText(currentTime);
                tv.setText(currentTv);
            }

            public void onFinish() {
                extraTime = 0;
                currentTime = 0;
                currentTv = ConstData.thousand;
                tv.setText(currentTv);
                currentBtn = getString(R.string.btnStart);
                btn.setText(currentBtn);
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
        savedInstanceState.putString(ConstData.STATE_BTN, currentBtn);
        savedInstanceState.putString(ConstData.STATE_TV, currentTv);
        savedInstanceState.putInt(ConstData.STATE_TIME, currentTime);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        currentBtn = savedInstanceState.getString(ConstData.STATE_BTN);
        currentTv = savedInstanceState.getString(ConstData.STATE_TV);
        extraTime = savedInstanceState.getInt(ConstData.STATE_TIME);
    }

    @Override
    protected void onResume() {
        super.onResume();

        tv.setText(currentTv);
        btn.setText(currentBtn);
        if (extraTime != 0)
            startTimer();
    }
}
