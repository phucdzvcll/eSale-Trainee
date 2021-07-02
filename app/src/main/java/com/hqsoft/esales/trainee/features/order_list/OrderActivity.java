package com.hqsoft.esales.trainee.features.order_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.order_list.model.Order;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, OnItemRecyclerViewClick {
    private TextView dateVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setupActionBar();
        setupDateVisit();
        setupRecyclerView();
        totalPrice();
        setupBtnAdd();
    }

    private void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupDateVisit() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String strDate = formatter.format(date);
        dateVisit = findViewById(R.id.dateVisit);
        dateVisit.setText(strDate);
        eventPickDate();
    }

    private void eventPickDate() {
        CardView visitDateCard = findViewById(R.id.visitDayCard);
        visitDateCard.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });
    }

    private void setupRecyclerView() {
        OrderListAdapter orderList = new OrderListAdapter(this);
        orderList.addData(createListOrder());
        RecyclerView recyclerView = findViewById(R.id.orderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderList);
    }

    private List<Order> createListOrder() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("Sales10001", "Sales1", "CustId1", 35000, 3, "2018-08-09", "Gi chú"));
        orders.add(new Order("Sales10002", "Sales1", "CustId1", 50000, 5, "2018-08-09", "Gi chú"));
        orders.add(new Order("Sales20001", "Sales2", "CustId2", 40000, 2, "2018-08-09", "Gi chú"));
        orders.add(new Order("Sales30001", "Sales3", "CustId3", 51000, 3, "2018-08-09", "Gi chú"));
        orders.add(new Order("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        return orders;
    }

    private void totalPrice() {
        int total = 0;
        List<Order> orders = createListOrder();
        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).getOrderQty() * orders.get(i).getOrderAmt();
        }
        TextView totalPrice = findViewById(R.id.total);
        totalPrice.setText(MessageFormat.format("{0}", total));
    }

    private void setupBtnAdd(){
        ImageView btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            //todo
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        dateVisit.setText(date);
    }

    @Override
    public void onClick(View view, int position) {

    }
}