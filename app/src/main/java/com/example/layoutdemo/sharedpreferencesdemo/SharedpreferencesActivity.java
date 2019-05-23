package com.example.layoutdemo.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.layoutdemo.R;

public class SharedpreferencesActivity extends AppCompatActivity {
    Button btnExit;
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        txtUser=(TextView)findViewById(R.id.txt_user);
        SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
        String username = pref.getString("username","");
        txtUser.setText(username);

        btnExit=(Button)findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SharedpreferencesActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
