package com.hqsoft.esales.trainee.features.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.database.SalesOrderDetDAO;
import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;
import com.hqsoft.esales.data.mapper.SalesOrderDeMapper;
import com.hqsoft.esales.data.mapper.SalesOrderEntityMapper;
import com.hqsoft.esales.data.repository.SaveToSalesOrderRepositoryImpl;
import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;
import com.hqsoft.esales.domain.use_cases.SaveOderUseCase;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.AddItemPopup;
import com.hqsoft.esales.trainee.features.model.InventorySelected;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {
    private final OrderAdapter orderAdapter = new OrderAdapter();
    private TextView totalOrderPrice;
    private RecyclerView recyclerView;
    private EditText remark;
    private double orderAmt = 0;
    private int orderQty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setupView();
        Bundle bundle = getIntent().getExtras();
        setupActionBar();
        getInventoriesSelectedFromBundle(bundle);
        eventClickAddMore();
        eventClickBuy(bundle);
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderAdapter);
    }

    public void setListInventoriesFromAdapter(ArrayList<InventorySelected> inventories) {
        orderAdapter.addData(inventories);
        setOrderAmt(inventories);
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

    private void eventClickBuy(Bundle bundle) {
        Button btnBuy = findViewById(R.id.btnBuy);
        String slsperId = bundle.getString(OrderListActivity.KEY_SLSPERID);
        String customerId = bundle.getString(OrderListActivity.KEY_CUSTOMER);
        btnBuy.setOnClickListener(v -> {
            if (slsperId != null && customerId != null && orderQty > 0) {
                OrderDetMapper orderDetMapper = new OrderDetMapper();
                AppDatabase appDatabase = AppDatabase.getInstance(this);
                SalesOrderDAO salesOrderDAO = appDatabase.salesOrderDAO();
                SalesOrderDetDAO salesOrderDetDAO = appDatabase.salesOrderDetDAO();
                SalesOrderEntityMapper salesOrderEntityMapper = new SalesOrderEntityMapper();
                SalesOrderDeMapper salesOrderDeMapper = new SalesOrderDeMapper();
                SaveToSalesOrdRepository saveToSalesOrdRepository = new SaveToSalesOrderRepositoryImpl(salesOrderDAO, salesOrderDetDAO, salesOrderEntityMapper, salesOrderDeMapper);
                SaveOderUseCase saveOderUseCase = new SaveOderUseCase(saveToSalesOrdRepository);
                saveOderUseCase.execute(new SaveOderUseCase.Param(new OrderEntity(
                        new OrderEntity.SalesOrderEntity(slsperId, customerId, orderAmt, orderQty, remark.getText().toString()), orderDetMapper.mapList(orderAdapter.getListInventoriesSelected()))));
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                orderAdapter.addData(new ArrayList<>());
                totalOrderPrice.setText("0");
                salesOrderDetDAO.getListSalesOrder();
                remark.setText("");
                remark.clearFocus();
            } else if (orderQty <= 0) {
                Toast.makeText(this, "Vui lòng thêm ít nhất một sản phẩm", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupView() {
        totalOrderPrice = findViewById(R.id.totalOrderPrice);
        recyclerView = findViewById(R.id.listOrderItem);
        remark = findViewById(R.id.remark);
    }

    private void setOrderAmt(List<InventorySelected> inventorySelectedList) {
        if (inventorySelectedList.size() > 0) {
            for (int i = 0; i < inventorySelectedList.size(); i++) {
                orderAmt += (inventorySelectedList.get(i).getInventory().getPrice() * inventorySelectedList.get(i).getAmount());
                orderQty += inventorySelectedList.get(i).getAmount();
            }
            totalOrderPrice.setText(MessageFormat.format("{0}", orderAmt));
        }
    }

    private void getInventoriesSelectedFromBundle(Bundle bundle) {
        if (bundle != null) {
            orderAdapter.addData(bundle.getParcelableArrayList(OrderListActivity.KEY));
            setOrderAmt(bundle.getParcelableArrayList(OrderListActivity.KEY));
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