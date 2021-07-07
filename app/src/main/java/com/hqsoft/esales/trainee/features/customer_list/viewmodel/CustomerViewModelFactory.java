package com.hqsoft.esales.trainee.features.customer_list.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CustomerViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;
    public CustomerViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CustomerViewModel(context);
    }
}
