package com.example.statemanagmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    CheckBox ch;
    EditText editText;
    private CountViewModel countViewModel;
    private TextView textViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch=(CheckBox)findViewById(R.id.checkBox);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);

        countViewModel = new ViewModelProvider(this) .get(CountViewModel.class);
        updateCountText();
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countViewModel.incrementCount();

                updateCountText();
            }
        });

    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getCount());

    }
}
