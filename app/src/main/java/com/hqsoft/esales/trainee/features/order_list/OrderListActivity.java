package com.hqsoft.esales.trainee.features.order_list;

import androidx.annotation.NonNull;
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

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.mapper.OrderListLocalMapper;
import com.hqsoft.esales.data.repository.OrderListRepositoryImpl;
import com.hqsoft.esales.domain.repository.OrderListRepository;
import com.hqsoft.esales.domain.use_cases.OrderListUseCase;
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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OrderListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView dateVisit;
    OrderListAdapter orderListAdapter = new OrderListAdapter();
    public static String KEY = "key";
    public static String KEY_SLSPERID = "slsperID";
    public static String KEY_CUSTOMER = "customer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        setupActionBar();
        setupDateVisit();
        setupRecyclerView();
        totalPrice();
        setupBtnAdd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestData();
    }

    private void requestData() {
        createListOrder()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<SalesOrder>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<SalesOrder> salesOrders) {
                        orderListAdapter.addData(salesOrders);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        //TODO handle error
                    }
                });
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

    @NonNull
    private Single<List<SalesOrder>> createListOrder() {
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        SalesOrderDAO salesOrderDAO = appDatabase.salesOrderDAO();
        OrderListLocalMapper orderListLocalMapper = new OrderListLocalMapper();
        OrderListRepository orderListRepository = new OrderListRepositoryImpl(salesOrderDAO, orderListLocalMapper);
        OrderListMapper orderListMapper = new OrderListMapper();
        OrderListUseCase orderListUseCase = new OrderListUseCase(orderListRepository);
        Single<OrderListUseCase.Result> result = orderListUseCase.execute(new UseCaseParam.EmptyParam());
        return result.flatMap((Function<OrderListUseCase.Result, SingleSource<List<SalesOrder>>>) result1 ->
                Single.just(orderListMapper.mapList(result1.getCustomerEntityList()))
        );
    }

    private void totalPrice() {
        createListOrder().subscribe(new SingleObserver<List<SalesOrder>>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
            }

            @Override
            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<SalesOrder> salesOrders) {
                int total = 0;
                for (int i = 0; i < Objects.requireNonNull(salesOrders).size(); i++) {
                    total += salesOrders.get(i).getOrderQty() * salesOrders.get(i).getOrderAmt();
                }
                TextView totalPrice = findViewById(R.id.total);
                totalPrice.setText(MessageFormat.format("{0}", total));
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                //TODO handle error
            }
        });

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
        String date = dayOfMonth + "/" + month + "/" + year;
        dateVisit.setText(date);
    }
}