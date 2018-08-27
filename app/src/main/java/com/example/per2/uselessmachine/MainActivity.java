package com.example.per2.uselessmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruc;
    private Switch switchUseeless;
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
                    Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void wireWidgets() {
        buttonSelfDestruc = findViewById(R.id.button_main_selfdestruct);
        switchUseeless = findViewById(R.id.switch_main_useless);
    }
}
