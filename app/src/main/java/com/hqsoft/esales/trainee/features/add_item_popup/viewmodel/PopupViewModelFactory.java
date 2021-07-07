package com.hqsoft.esales.trainee.features.add_item_popup.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PopupViewModelFactory implements ViewModelProvider.Factory {
    final private Context context;

    public PopupViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PopupViewModel(context);
    }
}
