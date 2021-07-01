package com.hqsoft.esales.trainee.features;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hqsoft.esales.trainee.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setInformationApp();
        eventBtnExit();
    }

    private void eventBtnLogin() {
        Button btnExit = findViewById(R.id.buttonLogin);
        btnExit.setOnClickListener(v -> {
            //todo
        });
    }

    private void eventBtnExit() {
        Button btnExit = findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(v -> finish());
    }

    private void setInformationApp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmm", Locale.US);
        String strDate = formatter.format(date);
        String str = getResources().getString(R.string.version_date) + " " + strDate;
        TextView informationTextview = findViewById(R.id.information);
        informationTextview.setText(str);
    }
}