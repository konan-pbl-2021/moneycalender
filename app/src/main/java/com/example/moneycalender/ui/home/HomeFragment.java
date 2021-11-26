package com.example.moneycalender.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.moneycalender.R;

import java.text.BreakIterator;

public class HomeFragment extends Fragment {

    private int cnt = 0;

    private CalendarView calendar;

    public HomeFragment() {
        this.calendar = calendar;
    }

    public static HomeFragment newInstance(int count) {
        HomeFragment homefragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putInt("Counter",count);
        homefragment.setArguments(args);

        return homefragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null){
            int count = args.getInt("Counter");
            String str = "HomeFragment:"+String.valueOf(count);
            cnt = count +1;

            EditText eidtText = view.findViewById(R.id.editTextNumber);

        }
        EditText ediText = view.findViewById(R.id.editTextNumber5);
        ediText = view.findViewById(R.id.editTextNumber6);
    }

    public void setArguments(Bundle args) {
    }


}