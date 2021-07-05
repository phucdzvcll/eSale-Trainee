package com.hqsoft.esales.trainee.features.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopup;
import com.hqsoft.esales.trainee.features.model.InventorySelected;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {
    private final OrderAdapter orderAdapter = new OrderAdapter();
    private TextView totalOrderPrice;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setupView();
        Bundle bundle = getIntent().getExtras();
        setupActionBar();
        getInventoriesSelectedFromBundle(bundle);
        eventClickAddMore();
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderAdapter);
    }

    public void setListInventoriesFromAdapter(ArrayList<InventorySelected> inventories) {
        orderAdapter.addData(inventories);
        setTotalPrice(inventories);
    }

    private void eventClickAddMore() {
        Button btnAddMore = findViewById(R.id.btnAddMore);
        btnAddMore.setOnClickListener(v -> {
            AddItemPopup dialogFragment = new AddItemPopup(AddItemPopup.Style.Order);
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            dialogFragment.addListInventoriesSelected(orderAdapter.getListInventoriesSelected());
            dialogFragment.show(fragmentManager, "Dialog");
        });
    }

    private void setupView() {
        totalOrderPrice = findViewById(R.id.totalOrderPrice);
        recyclerView = findViewById(R.id.listOrderItem);
    }

    private void setTotalPrice(List<InventorySelected> inventorySelectedList) {
        if (inventorySelectedList.size() > 0) {
            int price = 0;
            for (int i = 0; i < inventorySelectedList.size(); i++) {
                price += (inventorySelectedList.get(i).getInventory().getPrice() * inventorySelectedList.get(i).getAmount());
            }
            totalOrderPrice.setText(MessageFormat.format("{0}", price));
        }
    }

    private void getInventoriesSelectedFromBundle(Bundle bundle) {
        if (bundle != null) {
            orderAdapter.addData(bundle.getParcelableArrayList(AddItemPopup.KEY));
            setTotalPrice(bundle.getParcelableArrayList(AddItemPopup.KEY));
        }
    }

    private void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}