package com.hqsoft.esales.trainee.features.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalespersonDAO;
import com.hqsoft.esales.data.mapper.SalespersonLocalMapper;
import com.hqsoft.esales.data.repository.LoginRepositoryImpl;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;
import com.hqsoft.esales.domain.use_cases.LoginUseCase;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListActivity;
import com.hqsoft.esales.trainee.features.login.viewmodel.LoginViewModel;
import com.hqsoft.esales.trainee.features.login.viewmodel.LoginViewModelFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    public static String KEY = "username_key";
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView warningUserName;
    private TextView warningPassword;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createLoginViewModel();
        setInformationApp();
        eventBtnExit();
        getView();
        eventBtnLogin();
    }

    private void createLoginViewModel() {
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory(this)).get(LoginViewModel.class);
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
                warningUserName.setText(R.string.username_warning);
                if (password.equals("")) {
                    warningPassword.setVisibility(View.VISIBLE);
                    warningPassword.setText(R.string.password_warning);
                } else {
                    warningPassword.setVisibility(View.INVISIBLE);
                }
            } else {
                loginViewModel.requestSales(userName);
                loginViewModel.getSalesPersonEntityLiveData().observe(this, salesPersonEntity -> {
                    if (salesPersonEntity != null) {
                        warningUserName.setVisibility(View.INVISIBLE);
                        if (password.equals("")) {
                            warningPassword.setVisibility(View.VISIBLE);
                            warningPassword.setText(R.string.password_warning);
                        } else if (password.equals(salesPersonEntity.getPassword())) {
                            warningPassword.setVisibility(View.INVISIBLE);
                            warningPassword.setVisibility(View.GONE);
                            warningUserName.setVisibility(View.GONE);
                            Intent intent = new Intent(this, CustomerListActivity.class);
                            startActivity(intent.putExtra(KEY, userName));
                        } else {
                            warningPassword.setVisibility(View.VISIBLE);
                            warningPassword.setText(R.string.password_not_correct);
                        }
                    } else {
                        warningUserName.setVisibility(View.VISIBLE);
                        warningUserName.setText(R.string.username_not_exist);
                    }
                });

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