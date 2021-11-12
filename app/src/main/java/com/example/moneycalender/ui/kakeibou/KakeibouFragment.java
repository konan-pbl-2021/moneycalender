package com.example.moneycalender.ui.kakeibou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.moneycalender.R;

public class KakeibouFragment extends Fragment {

    private KakeibouViewModel kakeibouViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        kakeibouViewModel =
                ViewModelProviders.of(this).get(KakeibouViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kakeibou, container, false);
        return root;
    }
}