package com.example.moneycalender.ui.sifuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.moneycalender.R;

public class SifutoFragment extends Fragment {

    private ShiftViewModel shiftViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sifuto, container, false);
        ImageButton ButtonLeft = (ImageButton)root.findViewById(R.id.ButtonLeft);

        shiftViewModel = ViewModelProviders.of(this).get(ShiftViewModel.class);
        return root;
    }
}