package com.example.moneycalender.ui.sifuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.moneycalender.R;

public class SifutoFragment extends Fragment {

    private ShiftViewModel shiftViewModel;
    private static int i = 11;
    private static int sum=0;
    private static int t = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_sifuto, container, false);

        /*月入力*/
        TextView Month = (TextView)root.findViewById(R.id.Month);
        Month.setText(String.valueOf(i) + "月");
        /*ImageButton ButtonLeft = (ImageButton)root.findViewById(R.id.ButtonLeft);
        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView Month = (TextView)root.findViewById(R.id.Month);
                if(i > 1){
                    i --;
                    Month.setText(String.valueOf(i) + "月");
                }
                else{
                    i = 12;
                    Month.setText(String.valueOf(i) + "月");
                }

            }
        });
        ImageButton ButtonRight = (ImageButton)root.findViewById(R.id.ButtonRight);
        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView Month = (TextView)root.findViewById(R.id.Month);
                if(i < 12){
                    i ++;
                    Month.setText(String.valueOf(i) + "月");
                }
                else {
                    i = 1;
                    Month.setText(String.valueOf(i) + "月");
                }
            }
        });*/


        /*合計収入*/
        TextView Sum = (TextView)root.findViewById(R.id.Sum);
        Sum.setText("合計収入"+ String.valueOf(sum) + "円");


        /*バイト名・時給*/
        TextView Workname = (TextView)root.findViewById(R.id.WorkName);
        Workname.setText("バイト名");
        final TextView Workmoney = (TextView)root.findViewById(R.id.WorkMoney);
        Workmoney.setText("時給");

        EditText workname1 = (EditText)root.findViewById(R.id.WorkName1);
        String inpuStr_n1 = workname1.getText().toString();
        final EditText workmoney1 = (EditText)root.findViewById(R.id.WorkMoney1);
        String inpuStr_m1 = workmoney1.getText().toString();
        workmoney1.setText(String.valueOf(inpuStr_m1) );

        EditText workname2 = (EditText)root.findViewById(R.id.WorkName2);
        String inpuStr_n2 = workname2.getText().toString();
        EditText workmoney2 = (EditText)root.findViewById(R.id.WorkMoney2);
        String inpuStr_m2 = workmoney2.getText().toString();
        workmoney2.setText(String.valueOf(inpuStr_m2));

        EditText workname3 = (EditText)root.findViewById(R.id.WorkName3);
        String inpuStr_n3 = workname3.getText().toString();
        EditText workmoney3 = (EditText)root.findViewById(R.id.WorkMoney3);
        String inpuStr_m3 = workmoney3.getText().toString();
        workmoney3.setText(String.valueOf(inpuStr_m3));




        /*詳細*/
        TextView day = (TextView)root.findViewById(R.id.Day);
        day.setText("日付");
        TextView name = (TextView)root.findViewById(R.id.Name);
        name.setText("時給");
        TextView time = (TextView)root.findViewById(R.id.Time);
        time.setText("時間");
        TextView money = (TextView)root.findViewById(R.id.Money);
        money.setText("金額");

        EditText day1 = (EditText)root.findViewById(R.id.Day1);
        final String inpuStr_day1 = day1.getText().toString();
        day1.setText(String.valueOf(inpuStr_day1));
        EditText name1 = (EditText)root.findViewById(R.id.Name1);
        String inpuStr_name1 = name1.getText().toString();
        EditText time1 = (EditText)root.findViewById(R.id.Time1);
        String inpuStr_time1 = time1.getText().toString();
        time1.setText(String.valueOf(inpuStr_time1));
        TextView money1 = (TextView)root.findViewById(R.id.Money1);

        EditText day2 = (EditText)root.findViewById(R.id.Day2);
        String inpuStr_day2 = day2.getText().toString();
        day2.setText(String.valueOf(inpuStr_day2));
        EditText name2 = (EditText)root.findViewById(R.id.Name2);
        String inpuStr_name2 = name2.getText().toString();
        EditText time2 = (EditText)root.findViewById(R.id.Time2);
        String inpuStr_time2 = time2.getText().toString();
        time2.setText(String.valueOf(inpuStr_time2));
        TextView money2 = (TextView)root.findViewById(R.id.Money2);


        Button syukei = (Button)root.findViewById(R.id.syukei);
        syukei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name1 = (EditText)root.findViewById(R.id.Name1);
                String inpuStr_name1 = name1.getText().toString();
                EditText time1 = (EditText)root.findViewById(R.id.Time1);
                String inpuStr_time1 = time1.getText().toString();
                int num1 = Integer.parseInt(inpuStr_name1) * Integer.parseInt(inpuStr_time1);
                TextView money1 = (TextView)root.findViewById(R.id.Money1);
                money1.setText(String.valueOf(num1));

                EditText name2 = (EditText)root.findViewById(R.id.Name2);
                String inpuStr_name2 = name2.getText().toString();
                EditText time2 = (EditText)root.findViewById(R.id.Time2);
                String inpuStr_time2 = time2.getText().toString();
                int num2 = Integer.parseInt(inpuStr_name2) * Integer.parseInt(inpuStr_time2);
                TextView money2 = (TextView)root.findViewById(R.id.Money2);
                money2.setText(String.valueOf(num2));

                int sum = num1 + num2;
                TextView Sum = (TextView)root.findViewById(R.id.Sum);
                Sum.setText("合計収入"+ String.valueOf(sum) + "円");

            }
        });





        shiftViewModel = ViewModelProviders.of(this).get(ShiftViewModel.class);
        return root;
    }
}