package com.hqsoft.esales.trainee.features.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView warningUserName;
    private TextView warningPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setInformationApp();
        eventBtnExit();
        getView();
        eventBtnLogin();
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        CustomerDAO customerDAO =appDatabase.customerDAO();
    }

    private void getView() {
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        warningUserName = findViewById(R.id.warningUsername);
        warningPassword = findViewById(R.id.warningPassword);
    }

    private void eventBtnLogin() {

        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(v -> {
            String userName = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (userName.equals("")) {
                warningUserName.setVisibility(View.VISIBLE);
            } else {
                warningUserName.setVisibility(View.INVISIBLE);
            }
            if (password.equals("")) {
                warningPassword.setVisibility(View.VISIBLE);
            } else {
                warningPassword.setVisibility(View.INVISIBLE);
            }
            if (!userName.equals("") && !password.equals("")) {
                Intent intent = new Intent(this, CustomerListActivity.class);
                startActivity(intent);
            }
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