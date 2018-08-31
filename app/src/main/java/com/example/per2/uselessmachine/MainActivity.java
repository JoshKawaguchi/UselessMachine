package com.example.per2.uselessmachine;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruct;
    private Switch switchUseless;
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
    }

    private void setListeners() {
        //TODO self destruct button
        buttonSelfDestruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSelfDestructSequence();
            }
        });

        switchUseless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if(checked){
                    startSwitchOffTImer();
                    //Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startSelfDestructSequence() {
        //Disable the button
        buttonSelfDestruct.setEnabled(false);
        //Start a 10 second countdown timer that updates
        //the display every second
        startDestructTimer();
        //Want the button to show the countdown
        //Self Destruct in 10 etc

        //at the end close the activity
        //cal the finish() method
    }

    private void startDestructTimer() {
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonSelfDestruct.setText("Self Destruct in " +  millisUntilFinished/1000 + " seconds");
            }

            @Override
            public void onFinish() {
                finish();

            }
        }.start();

    }

    private void startSwitchOffTImer() {
        new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(!switchUseless.isChecked()){
                    //Log.d(TAG, "onTick: cancelling");
                    cancel();

                }
            }

            @Override
            public void onFinish() {
                switchUseless.setChecked(false);
                //Log.d(TAG, "onFinish: switch set to false");
            }
        }.start();
    }

    private void wireWidgets() {
        buttonSelfDestruct = findViewById(R.id.button_main_selfdestruct);
        switchUseless = findViewById(R.id.switch_main_useless);
    }
}
