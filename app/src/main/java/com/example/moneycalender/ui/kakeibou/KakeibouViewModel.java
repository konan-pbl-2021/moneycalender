package com.example.moneycalender.ui.kakeibou;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KakeibouViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KakeibouViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}