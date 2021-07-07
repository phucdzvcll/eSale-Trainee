package com.hqsoft.esales.trainee.features.add_item_popup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.InventoryDAO;
import com.hqsoft.esales.data.mapper.InventoryLocalMapper;
import com.hqsoft.esales.data.repository.InventoryRepositoryImpl;
import com.hqsoft.esales.domain.repository.InventoryRepository;
import com.hqsoft.esales.domain.use_cases.InventoryListUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListActivity;
import com.hqsoft.esales.trainee.features.login.LoginActivity;
import com.hqsoft.esales.trainee.features.model.InventorySelected;
import com.hqsoft.esales.trainee.features.order.OrderActivity;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddItemPopup extends DialogFragment {
    final Style style;
    AddItemPopupAdapter addItemPopupAdapter = new AddItemPopupAdapter();
    private Button closeBtn;
    private Button acceptBtn;

    public AddItemPopup(Style style) {
        this.style = style;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(getDialog()).setCancelable(true);
        Objects.requireNonNull(getDialog()).setCanceledOnTouchOutside(true);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.fragment_add_item_popup, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setSizeDialog();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        requestData();
    }

    private void requestData() {
        createListItem()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Inventory>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Inventory> inventories) {
                        addItemPopupAdapter.addData(inventories);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        //TODO handle error
                    }
                });
    }

    private void setSizeDialog() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;
        WindowManager.LayoutParams params;
        params = Objects.requireNonNull(getDialog()).getWindow().getAttributes();
        params.width = (int) width * 90 / 100;
        params.height = (int) height * 90 / 100;
        getDialog().getWindow().setAttributes(params);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
        acceptBtn = view.findViewById(R.id.btnAccept);
        closeBtn = view.findViewById(R.id.btnClose);
        handleBtnDialog();
    }

    void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(addItemPopupAdapter);
    }

    private Single<List<Inventory>> createListItem() {
        AppDatabase appDatabase = AppDatabase.getInstance(requireContext());
        InventoryDAO inventoryDAO = appDatabase.inventoryDAO();
        InventoryLocalMapper inventoryLocalMapper = new InventoryLocalMapper();
        InventoryRepository inventoryRepository = new InventoryRepositoryImpl(inventoryDAO, inventoryLocalMapper);
        InventoryListUseCase inventoryListUseCase = new InventoryListUseCase(inventoryRepository);
        Single<InventoryListUseCase.Result> result = inventoryListUseCase.execute(new UseCaseParam.EmptyParam());
        InventoryMapper inventoryMapper = new InventoryMapper();
        return result.flatMap((Function<InventoryListUseCase.Result, SingleSource<List<Inventory>>>) result1 ->
                Single.just(inventoryMapper.mapList(result1.getInventoryEntities()))
        );
    }

    private void handleBtnDialog() {
        closeBtn.setOnClickListener(v -> dismissDialog());
        acceptBtn.setOnClickListener(v -> {
            dismissDialog();
            if (style.equals(Style.OrderList)) {
                dismissDialog();
                Bundle bundle = new Bundle();
                OrderListActivity customerListActivity = (OrderListActivity) getActivity();
                Intent intent = Objects.requireNonNull(customerListActivity).getIntent();
                String slsperId = intent.getStringExtra(LoginActivity.KEY);
                String customer = intent.getStringExtra(CustomerListActivity.KEY);
                if (slsperId != null) {
                    bundle.putString(OrderListActivity.KEY_SLSPERID, slsperId);
                }
                if (customer != null) {
                    bundle.putString(OrderListActivity.KEY_CUSTOMER, customer);
                }
                bundle.putParcelableArrayList(OrderListActivity.KEY, addItemPopupAdapter.getInventoriesSelected());
                startActivity(new Intent(getActivity(), OrderActivity.class).putExtras(bundle));
            } else {
                dismissDialog();
                OrderActivity activity = (OrderActivity) getActivity();
                Objects.requireNonNull(activity).setListInventoriesFromAdapter(addItemPopupAdapter.getInventoriesSelected());
            }
        });

    }

    private void dismissDialog() {
        Objects.requireNonNull(getDialog()).dismiss();
    }

    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }

    public void addListInventoriesSelected(ArrayList<InventorySelected> inventorySelected) {
        addItemPopupAdapter.addListInventoriesSelected(inventorySelected);
    }

    public enum Style {
        OrderList,
        Order
    }
}