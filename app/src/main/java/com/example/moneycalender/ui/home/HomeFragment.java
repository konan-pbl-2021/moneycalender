package com.example.moneycalender.ui.home;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

//    private CalendarView calendar;

    public HomeFragment() {
//        this.calendar = calendar;
    }

    public static HomeFragment newInstance(int count) {
        HomeFragment homefragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putInt("Counter",count);
        homefragment.setArguments(args);

        return homefragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        calendar = (CalendarView) root.findViewById(R.id.calendarView);


        //予定表へ行くbutton
        Button newbutton = (Button) root.findViewById(R.id.yoteibutton);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YoteiActivity.class);
                startActivity(intent);
            }
        });

        return root;
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

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_home);


//        calendar.setOnDateChangeListener(
//                new OnDateChangeListener(){
//                    @Override
//                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//
//                    }
//
//
//                    public void onSelectDayChange(@NonNull CalendarView
//                                                          calendarView, int year, int month, int date){
//                        String message = year + "/"+(month +1)+"/"+date;
//                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
//
//                    }
//                }
//        );
    }

    private Context getApplicationContext() {
        return null;
    }



    private void setContentView(int fragment_home) {
    }

    private HomeViewModel homeViewModel;
}