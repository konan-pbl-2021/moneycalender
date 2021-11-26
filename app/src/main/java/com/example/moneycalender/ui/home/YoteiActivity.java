package com.example.moneycalender.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import com.example.moneycalender.R;

import java.util.ArrayList;
import java.util.HashMap;

public class YoteiActivity extends AppCompatActivity {

    Button newbutton;
    Button rebutton;
    MemoOpenHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yotei);


        //データベースから値を所得する
        if(helper == null){
            helper = new MemoOpenHelper(YoteiActivity.this);
        }

        final ArrayList<HashMap<String, String>> memoList = new ArrayList<>();


        //データベースを所得する
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            Cursor c = db.rawQuery("select uuid, body from MEMO_TABLE order by id", null);
            boolean next = c.moveToFirst();


            while (next) {
                HashMap<String, String> data = new HashMap<>();
                String uuid = c.getString(0);
                String body = c.getString(1);
                if (body.length() > 10) {
                    body = body.substring(0, 11) + "...";
                }

                data.put("body", body);
                data.put("id", uuid);
                memoList.add(data);
                next = c.moveToNext();
            }
        }finally {
            db.close();
        }

        //Adapterの作成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this,memoList, android.R.layout.simple_list_item_2,
                new String[]{"body","id"},new int[]{android.R.id.text1,android.R.id.text2});

        ListView listView = (ListView) findViewById(R.id.memoList);
        listView.setAdapter(simpleAdapter);



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                TwoLineListItem two = (TwoLineListItem) view;
                TextView idTextView = (TextView) two.getText2();
                String idstr = (String) idTextView.getText();
                SQLiteDatabase db = helper.getWritableDatabase();
                try {
                    db.execSQL("DELETE FROM MEMO_TABLE WHERE uuid = '" + idstr + "'");
                }finally {
                    db.close();
                }

                memoList.remove(position);
                simpleAdapter.notifyDataSetChanged();



                return true;
            }
        });



        newbutton = findViewById(R.id.newbutton1);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoteiActivity.this, YoteiInActivity.class);
                startActivity(intent);
            }
        });

        rebutton = findViewById(R.id.rehomebutton);
        rebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}