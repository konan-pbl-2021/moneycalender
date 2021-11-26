package com.example.moneycalender.ui.kakeibou;

import android.app.Activity;
import android.content.Intent;
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

import com.example.moneycalender.MainActivity;
import com.example.moneycalender.R;
import com.example.moneycalender.ui.sifuto.SifutoFragment;

public class KakeibouFragment extends Fragment {

    private KakeibouViewModel kakeibouViewModel;
    private  static int i = 11;
    private static int sum = 0, num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0;
    private static String result;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_kakeibou, container, false);
        kakeibouViewModel =
                ViewModelProviders.of(this).get(KakeibouViewModel.class);


        TextView month = (TextView)root.findViewById(R.id.month);
        month.setText(String.valueOf(i) + "月");
        /*ImageButton leftbutton = (ImageButton)root.findViewById(R.id.leftbutton);
        leftbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView month = (TextView)root.findViewById(R.id.month);
                if(i > 1){
                    i --;
                    month.setText(String.valueOf(i) + "月");
                }
            }
        });*/
        /*ImageButton rightbutton = (ImageButton)root.findViewById(R.id.rightbutton);
        rightbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView month = (TextView)root.findViewById(R.id.month);
                if(i < 12){
                    i ++;
                    month.setText(String.valueOf(i) + "月");
                }
            }
        });*/

        /*TextView goukei_zankin = (TextView)root.findViewById(R.id.goukei_zankin);
        goukei_zankin.setText("合計残金                                            " + String.valueOf(sum) + "円");
        TextView goukei_syunyu = (TextView)root.findViewById(R.id.goukei_syunyu);
        goukei_syunyu.setText("合計収入                                            " + String.valueOf(sum) + "円");*/
        TextView goukei_sisyutsu = (TextView)root.findViewById(R.id.goukei_sisyutsu);
        goukei_sisyutsu.setText("合計支出                                            " + String.valueOf(sum) + "円");


        Button syukei = (Button)root.findViewById(R.id.syukei);
        syukei.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText kingaku1 = (EditText)root.findViewById(R.id.kingaku1);
                String inputStr1 = kingaku1.getText().toString();
                EditText kingaku2 = (EditText)root.findViewById(R.id.kingaku2);
                String inputStr2 = kingaku2.getText().toString();
                EditText kingaku3 = (EditText)root.findViewById(R.id.kingaku3);
                String inputStr3 = kingaku3.getText().toString();
                EditText kingaku4 = (EditText)root.findViewById(R.id.kingaku4);
                String inputStr4 = kingaku4.getText().toString();
                EditText kingaku5 = (EditText)root.findViewById(R.id.kingaku5);
                String inputStr5 = kingaku5.getText().toString();


                num1 = Integer.parseInt(inputStr1);
                num2 = Integer.parseInt(inputStr2);
                num3 = Integer.parseInt(inputStr3);
                num4 = Integer.parseInt(inputStr4);
                num5 = Integer.parseInt(inputStr5);
                sum = num1 + num2 + num3 + num4 + num5;

                /*TextView goukei_zankin = (TextView)root.findViewById(R.id.goukei_zankin);
                goukei_zankin.setText("合計残金                                      " + String.valueOf(sum) + "円");
                TextView goukei_syunyu = (TextView)root.findViewById(R.id.goukei_syunyu);
                goukei_syunyu.setText("合計収入                                      " + String.valueOf(sum) + "円");*/
                TextView goukei_sisyutsu = (TextView)root.findViewById(R.id.goukei_sisyutsu);
                goukei_sisyutsu.setText("合計支出                                      " + String.valueOf(sum) + "円");
            }
        });

        return root;
    }





    /*public void showMessage(View view){
        sum = num1 + num2 + num3 + num4 + num5;
        result = String.valueOf(sum);

        Activity root = null;

        TextView goukei_zankin = (TextView)root.findViewById(R.id.goukei_zankin);
        goukei_zankin.setText("合計残金                                            " + result + "円");
        TextView goukei_syunyu = (TextView)root.findViewById(R.id.goukei_syunyu);
        goukei_syunyu.setText("合計収入                                            " + result + "円");
        TextView goukei_sisyutsu = (TextView)root.findViewById(R.id.goukei_sisyutsu);
        goukei_sisyutsu.setText("合計支出                                            " + result + "円");
        TextView zankin = (TextView)root.findViewById(R.id.zankin);
        zankin.setText("先月の残金                                        " + result + "円");

    }*/
}

