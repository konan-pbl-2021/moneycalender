package com.example.moneycalender.ui.sifuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.moneycalender.R;

public class SifutoFragment extends Fragment {

    private ShiftViewModel shiftViewModel;
    private static int i = 10;
    private static int sum=0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_sifuto, container, false);

        /*月入力*/
        TextView Month = (TextView)root.findViewById(R.id.Month);
        Month.setText(String.valueOf(i) + "月");
        ImageButton ButtonLeft = (ImageButton)root.findViewById(R.id.ButtonLeft);
        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView Month = (TextView)root.findViewById(R.id.Month);
                if(i > 1){
                    i --;
                    Month.setText(String.valueOf(i) + "月");
                }
            }
        });
        ButtonLeft.setRotation(180f);

        ImageButton ButtonRight = (ImageButton)root.findViewById(R.id.ButtonRight);
        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView Month = (TextView)root.findViewById(R.id.Month);
                if(i < 12){
                    i ++;
                    Month.setText(String.valueOf(i) + "月");
                }
            }
        });

        /*合計収入*/
        TextView Sum = (TextView)root.findViewById(R.id.Sum);
        Sum.setText("合計収入"+ String.valueOf(sum) + "円");

        /*バイト名・時給*/
        TextView Workname = (TextView)root.findViewById(R.id.WorkName);
        Workname.setText("バイト名");
        TextView Workmoney = (TextView)root.findViewById(R.id.WorkMoney);
        Workmoney.setText("時給");

        EditText workname1 = (EditText)root.findViewById(R.id.WorkName1);
        String inpuStr_n1 = workname1.getText().toString();
        EditText workmoney1 = (EditText)root.findViewById(R.id.WorkMoney1);
        String inpuStr_m1 = workmoney1.getText().toString();
        workmoney1.setText(String.valueOf(inpuStr_m1) + "円");

        EditText workname2 = (EditText)root.findViewById(R.id.WorkName2);
        String inpuStr_n2 = workname2.getText().toString();
        EditText workmoney2 = (EditText)root.findViewById(R.id.WorkMoney2);
        String inpuStr_m2 = workmoney2.getText().toString();
        workmoney2.setText(String.valueOf(inpuStr_m2) + "円");

        EditText workname3 = (EditText)root.findViewById(R.id.WorkName3);
        String inpuStr_n3 = workname3.getText().toString();
        EditText workmoney3 = (EditText)root.findViewById(R.id.WorkMoney3);
        String inpuStr_m3 = workmoney3.getText().toString();
        workmoney3.setText(String.valueOf(inpuStr_m3) + "円");


        /*詳細*/
        TextView day = (TextView)root.findViewById(R.id.Day);
        day.setText("日付");
        TextView name = (TextView)root.findViewById(R.id.Name);
        name.setText("バイト名");
        TextView time = (TextView)root.findViewById(R.id.Time);
        time.setText("時間");
        TextView money = (TextView)root.findViewById(R.id.Money);
        money.setText("金額");

        EditText day1 = (EditText)root.findViewById(R.id.Day1);
        String inpuStr_day1 = day1.getText().toString();
        EditText name1 = (EditText)root.findViewById(R.id.Name1);
        String inpuStr_name1 = name1.getText().toString();
        EditText time1 = (EditText)root.findViewById(R.id.Time1);
        String inpuStr_time1 = time1.getText().toString();
        workmoney1.setText(String.valueOf(inpuStr_time1) + "時間");
        EditText money1 = (EditText)root.findViewById(R.id.Money1);
        String inpuStr_money1 = money1.getText().toString();
        workmoney1.setText(String.valueOf(inpuStr_money1) + "円");


        shiftViewModel = ViewModelProviders.of(this).get(ShiftViewModel.class);
        return root;
    }
}