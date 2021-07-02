package com.hqsoft.esales.trainee.features.add_item_popup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;
import com.hqsoft.esales.trainee.features.order.OrderActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddItemPopup extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_item_popup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
        handleBtnDialog(view);
    }

    void setupRecyclerView(View view) {
        AddItemPopupAdapter addItemPopupAdapter = new AddItemPopupAdapter();
        addItemPopupAdapter.addData(createListItem());
        RecyclerView recyclerView = view.findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(addItemPopupAdapter);
    }

    private List<Inventory> createListItem() {
        ArrayList<Inventory> inventories = new ArrayList<>();
        inventories.add(new Inventory("SP1", "Sản phẩm 1", "CHAI", "10000"));
        inventories.add(new Inventory("SP2", "Sản phẩm 2", "LON", "15000"));
        inventories.add(new Inventory("SP3", "Sản phẩm 3", "CHAI", "20000"));
        inventories.add(new Inventory("SP4", "Sản phẩm 4", "LON", "17000"));
        inventories.add(new Inventory("SP5", "Sản phẩm 5", "LON", "32000"));
        return inventories;
    }

    private void handleBtnDialog(View view) {
        Button closeBtn = view.findViewById(R.id.btnClose);
        Button acceptBtn = view.findViewById(R.id.btnAccept);
        closeBtn.setOnClickListener(v -> dismissDialog());
        acceptBtn.setOnClickListener(v -> {
            dismissDialog();
            startActivity(new Intent(getActivity(), OrderActivity.class));
        });

    }

    private void dismissDialog() {
        Objects.requireNonNull(getDialog()).dismiss();
    }

    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }

}