package com.hqsoft.esales.trainee.features.order_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopup;
import com.hqsoft.esales.trainee.features.order_list.viewmodel.OrderListViewModel;
import com.hqsoft.esales.trainee.features.order_list.viewmodel.OrderListViewModelFactory;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;


public class OrderListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView dateVisit;
    OrderListAdapter orderListAdapter = new OrderListAdapter();
    public static String KEY = "key";
    public static String KEY_SLSPERID = "slsperID";
    public static String KEY_CUSTOMER = "customer";
    private OrderListViewModel orderListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        createOrderListViewModel();
        setupActionBar();
        setupDateVisit();
        setupRecyclerView();
        setupBtnAdd();
        orderListViewModel.getListMutableLiveData().observe(this,salesOrders -> {
            orderListAdapter.addData(salesOrders);
            int total = 0;
            for (int i = 0; i < Objects.requireNonNull(salesOrders).size(); i++) {
                total += salesOrders.get(i).getOrderQty() * salesOrders.get(i).getOrderAmt();
            }
            TextView totalPrice = findViewById(R.id.total);
            totalPrice.setText(MessageFormat.format("{0}", total));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        Date date = c.getTime();
        requestData(date);
    }

    private void requestData(Date date) {
        orderListViewModel.requestData(date);
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

    private void createOrderListViewModel() {
        orderListViewModel = new ViewModelProvider(this, new OrderListViewModelFactory(this)).get(OrderListViewModel.class);
    }

    private void setupBtnAdd() {
        ImageView btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            DialogFragment dialogFragment = new AddItemPopup(AddItemPopup.Style.OrderList);
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
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        c.set(Calendar.MILLISECOND,0);
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        Date date = c.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String strDate = formatter.format(date);
        requestData(date);
        dateVisit.setText(strDate);

    }
}