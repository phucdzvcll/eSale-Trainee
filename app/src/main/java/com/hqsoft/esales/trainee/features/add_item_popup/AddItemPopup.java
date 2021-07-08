package com.hqsoft.esales.trainee.features.add_item_popup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.viewmodel.PopupViewModel;
import com.hqsoft.esales.trainee.features.add_item_popup.viewmodel.PopupViewModelFactory;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListActivity;
import com.hqsoft.esales.trainee.features.login.LoginActivity;
import com.hqsoft.esales.trainee.features.model.InventorySelected;
import com.hqsoft.esales.trainee.features.order.OrderActivity;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.util.ArrayList;
import java.util.Objects;

public class AddItemPopup extends DialogFragment {
    final Style style;
    AddItemPopupAdapter addItemPopupAdapter = new AddItemPopupAdapter();
    private Button closeBtn;
    private Button acceptBtn;
    private PopupViewModel popupViewModel;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPopupViewModel();
        popupViewModel.getListLiveData().observe(requireActivity(), inventories -> addItemPopupAdapter.addData(inventories));
    }

    private void createPopupViewModel() {
        popupViewModel = new ViewModelProvider(requireActivity(), new PopupViewModelFactory(getContext())).get(PopupViewModel.class);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        requestData();
    }

    private void requestData() {
        popupViewModel.requestData();
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
        EditText search = view.findViewById(R.id.searchProduct);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                popupViewModel.getDataBySearch(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(addItemPopupAdapter);
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