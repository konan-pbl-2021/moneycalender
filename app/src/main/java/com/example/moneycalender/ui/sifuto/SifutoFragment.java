package com.example.moneycalender.ui.sifuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView workname = (TextView)root.findViewById(R.id.WorkName);
        workname.setText("バイト名");
        TextView workmoney = (TextView)root.findViewById(R.id.WorkMoney);
        workmoney.setText("時給");

        /*詳細*/
        TextView day = (TextView)root.findViewById(R.id.Day);
        day.setText("日付");
        TextView name = (TextView)root.findViewById(R.id.Name);
        name.setText("バイト名");
        TextView time = (TextView)root.findViewById(R.id.Time);
        time.setText("時間");
        TextView money = (TextView)root.findViewById(R.id.Money);
        money.setText("金額");

        shiftViewModel = ViewModelProviders.of(this).get(ShiftViewModel.class);
        return root;
    }
}