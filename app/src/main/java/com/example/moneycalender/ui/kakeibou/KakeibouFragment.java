package com.example.moneycalender.ui.kakeibou;

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

public class KakeibouFragment extends Fragment {

    private KakeibouViewModel kakeibouViewModel;
    private  static int i = 10;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_kakeibou, container, false);
        kakeibouViewModel =
                ViewModelProviders.of(this).get(KakeibouViewModel.class);

        TextView textView1 = (TextView)root.findViewById(R.id.month);
        textView1.setText(String.valueOf(i) + "月");

        ImageButton leftbutton = (ImageButton)root.findViewById(R.id.leftbutton);
        leftbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView textView1 = (TextView)root.findViewById(R.id.month);
                if(i > 1){
                    i --;
                    textView1.setText(String.valueOf(i) + "月");
                }
            }
        });
        leftbutton.setRotation(180f);

        ImageButton rightbutton = (ImageButton)root.findViewById(R.id.rightbutton);
        rightbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView textView1 = (TextView)root.findViewById(R.id.month);
                if(i < 12){
                    i ++;
                    textView1.setText(String.valueOf(i) + "月");
                }
            }
        });

        EditText kingaku1 = (EditText)root.findViewById(R.id.kingaku1);
        String inputStr1 = kingaku1.getText().toString();
        kingaku1.setText(inputStr1 + "円");

        EditText kingaku2 = (EditText)root.findViewById(R.id.kingaku2);
        String inputStr2 = kingaku2.getText().toString();
        kingaku2.setText(inputStr2 + "円");

        EditText kingaku3 = (EditText)root.findViewById(R.id.kingaku3);
        String inputStr3 = kingaku3.getText().toString();
        kingaku3.setText(inputStr3 + "円");

        EditText kingaku4 = (EditText)root.findViewById(R.id.kingaku4);
        String inputStr4 = kingaku4.getText().toString();
        kingaku4.setText(inputStr4 + "円");

        EditText kingaku5 = (EditText)root.findViewById(R.id.kingaku5);
        String inputStr5 = kingaku5.getText().toString();
        kingaku5.setText(inputStr5 + "円");



        return root;
    }
}

