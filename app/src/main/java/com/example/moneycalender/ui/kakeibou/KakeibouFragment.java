package com.example.moneycalender.ui.kakeibou;

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


        return root;
    }
}

