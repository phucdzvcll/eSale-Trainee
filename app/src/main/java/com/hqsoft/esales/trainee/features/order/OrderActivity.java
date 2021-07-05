package com.hqsoft.esales.trainee.features.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopup;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopupAdapter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {
    ArrayList<AddItemPopupAdapter.InventorySelected> newList = new ArrayList<>();
    private TextView totalOrderPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setupView();
        Bundle bundle = getIntent().getExtras();
        setupActionBar();
        getInventoriesSelectedFromBundle(bundle);
        setTotalPrice();
        eventClickAddMore();
    }

    public void setListInventoriesFromAdapter(ArrayList<AddItemPopupAdapter.InventorySelected> inventories) {
        newList.clear();
        newList.addAll(inventories);
        setTotalPrice();
    }

    private void eventClickAddMore() {
        Button btnAddMore = findViewById(R.id.btnAddMore);
        btnAddMore.setOnClickListener(v -> {
            AddItemPopup dialogFragment = new AddItemPopup(AddItemPopup.Style.Order);
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            dialogFragment.addListInventoriesSelected(newList);
            dialogFragment.show(fragmentManager, "Dialog");
        });
    }

    private void setupView() {
        totalOrderPrice = findViewById(R.id.totalOrderPrice);
    }

    private void setTotalPrice() {
        if (newList.size() > 0) {
            int price = 0;
            for (int i = 0; i < newList.size(); i++) {
                price += (newList.get(i).getInventory().getPrice() * newList.get(i).getAmount());
            }
            totalOrderPrice.setText(MessageFormat.format("{0}", price));
        }
    }

    private void getInventoriesSelectedFromBundle(Bundle bundle) {
        if (bundle != null) {
            newList.addAll(bundle.getParcelableArrayList(AddItemPopup.KEY));
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