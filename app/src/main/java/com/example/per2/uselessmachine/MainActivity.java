package com.example.per2.uselessmachine;

import android.content.pm.FeatureInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruc;
    private Switch switchUseeless;
    
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

        switchUseeless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if(checked){
                    startSwitchOffTImer();
                    //Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startSwitchOffTImer() {
        new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(!switchUseeless.isChecked()){
                    //Log.d(TAG, "onTick: cancelling");
                    cancel();

                }
            }

            @Override
            public void onFinish() {
                switchUseeless.setChecked(false);
                //Log.d(TAG, "onFinish: switch set to false");
            }
        }.start();
    }

    private void wireWidgets() {
        buttonSelfDestruc = findViewById(R.id.button_main_selfdestruct);
        switchUseeless = findViewById(R.id.switch_main_useless);
    }
}
