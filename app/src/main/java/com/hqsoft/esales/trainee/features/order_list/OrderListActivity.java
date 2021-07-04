package com.hqsoft.esales.trainee.features.order_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.use_cases.OrderListUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.order_list.model.SalesOrder;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopup;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class OrderListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView dateVisit;
    OrderListAdapter orderListAdapter = new OrderListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        setupActionBar();
        setupDateVisit();
        setupRecyclerView();
        requestData();
        totalPrice();
        setupBtnAdd();
    }

    private void requestData() {
        List<SalesOrder> listOrder = createListOrder();
        if (listOrder != null) {
            orderListAdapter.addData(listOrder);
        } else {
            //todo handle error case
        }
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
        RecyclerView recyclerView = findViewById(R.id.salesOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderListAdapter);
    }

    @Nullable
    private List<SalesOrder> createListOrder() {
        OrderListMapper orderListMapper = new OrderListMapper();
        OrderListUseCase orderListUseCase = new OrderListUseCase();
        ResultPair<OrderListUseCase.Result, UseCaseError> result = orderListUseCase.execute(new UseCaseParam.EmptyParam());
        OrderListUseCase.Result success = result.getSuccess();
        if (success != null) {
            return orderListMapper.mapList(success.getCustomerEntityList());
        } else {
            return null;
        }
    }

    private void totalPrice() {
        int total = 0;
        List<SalesOrder> salesOrders = createListOrder();
        for (int i = 0; i < Objects.requireNonNull(salesOrders).size(); i++) {
            total += salesOrders.get(i).getOrderQty() * salesOrders.get(i).getOrderAmt();
        }
        TextView totalPrice = findViewById(R.id.total);
        totalPrice.setText(MessageFormat.format("{0}", total));
    }

    private void setupBtnAdd() {
        ImageView btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            DialogFragment dialogFragment = new AddItemPopup();
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            dialogFragment.show(fragmentManager, "Dialog");
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
}