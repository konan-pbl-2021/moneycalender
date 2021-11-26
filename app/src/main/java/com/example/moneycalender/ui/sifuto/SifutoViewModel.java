package com.example.moneycalender.ui.sifuto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SifutoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SifutoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}