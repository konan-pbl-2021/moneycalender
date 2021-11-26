package com.example.moneycalender.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moneycalender.R;

import java.util.UUID;

public class YoteiInActivity extends AppCompatActivity {

    //helperデータベースにnullを入れる
    MemoOpenHelper helper = null;
    Button savebutton;
    Button backbutton;
    EditText body;
    String id = "id";
    boolean newFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yotei_in);



        if(helper == null){
            helper = new MemoOpenHelper(YoteiInActivity.this);
        }

        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");


        if(id == null) {
            newFlag = true;
        }else{
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                Cursor c = db.rawQuery("select body from MEMO_TABLE where uuid = '"+ id + "'",null);
                boolean next = c.moveToFirst();
                while (next){
                    String dispBody = c.getString(0);
                    EditText body = findViewById(R.id.editText);
                    body.setText(dispBody, TextView.BufferType.NORMAL);
                    next = c.moveToNext();
                }
            }finally {
                db.close();
            }
        }


        savebutton = findViewById(R.id.savebutton1);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body = findViewById(R.id.editText);
                String bodyStr = body.getText().toString();

                SQLiteDatabase db = helper.getWritableDatabase();
                try {
                    if(newFlag) {
                        id = UUID.randomUUID().toString();

                        db.execSQL("insert into MEMO_TABLE(uuid,body) VALUES('" + id + "','" + bodyStr + "')");
                    }else{
                        db.execSQL("update MEMO_TABLE set body = '" + bodyStr+ "' where uuid = '" + id + "'");
                    }
                }finally {
                    db.close();
                }

                Intent intent = new Intent(YoteiInActivity.this, YoteiActivity.class);
                startActivity(intent);
            }
        });


        backbutton = findViewById(R.id.returnbutton1);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoteiInActivity.this, YoteiActivity.class);
                intent.putExtra("id", "");
                startActivity(intent);
            }
        });



    }
}