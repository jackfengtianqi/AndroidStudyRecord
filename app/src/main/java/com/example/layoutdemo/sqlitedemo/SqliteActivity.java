package com.example.layoutdemo.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.layoutdemo.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SqliteActivity extends AppCompatActivity {
    StuDBHelper dbHelper;
    SQLiteDatabase db;
    String Result = "";
    @BindView(R.id.btn_createdb)
    Button btnCreatedb;
    @BindView(R.id.btn_updatedb)
    Button btnUpdatedb;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.btn_deletedb)
    Button btnDeletedb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }
    @OnClick({R.id.btn_createdb, R.id.btn_updatedb, R.id.btn_deletedb,R.id.btn_query, R.id.btn_insert, R.id.btn_delete, R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_createdb:
                dbHelper = new StuDBHelper(this, "School.db", null, 1);
                db = dbHelper.getReadableDatabase();
                break;
            case R.id.btn_updatedb:
                dbHelper = new StuDBHelper(this, "School.db", null, 2);
                db = dbHelper.getReadableDatabase();
                break;
            case R.id.btn_deletedb:
                deleteDatabase("School.db");
                deleteDatabase("Teacher.db");
                Toast.makeText(this,"数据库已删除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                editText.setText("");
                Result="";
                db = dbHelper.getReadableDatabase();
                Cursor cursor = db.query("student", null, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String password = cursor.getString(cursor.getColumnIndex("password"));
                        Result = Result +"id "+id+ "姓名 " + name + " " + "密码 " + password +"\n";
                    } while (cursor.moveToNext());
                }
                cursor.close();
                editText.setText(Result);
                break;
            case R.id.btn_insert:
                db = dbHelper.getReadableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "ming");
                values.put("password", "ming");
                db.insert("student", null, values);
                values.clear();
                values.put("name", "fang");
                values.put("password", "fang");
                db.insert("student", null, values);
                Toast.makeText(this,"数据已插入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
                db = dbHelper.getReadableDatabase();
                db.delete("student", "name=?", new String[]{"ming"});
                Toast.makeText(this,"数据已删除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                db = dbHelper.getReadableDatabase();
                ContentValues values1 = new ContentValues();
                values1.put("password", "hello");
                db.update("student", values1, "name=?", new String[]{"fang"});
                Toast.makeText(this,"数据已更新",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
