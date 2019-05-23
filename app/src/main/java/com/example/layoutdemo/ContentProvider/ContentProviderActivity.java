package com.example.layoutdemo.ContentProvider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layoutdemo.R;

public class ContentProviderActivity extends AppCompatActivity implements View.OnClickListener {



    Button btnContacts;

    Button btnMycontentprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        init();
    }
    public void init(){
        btnContacts=(Button)findViewById(R.id.btn_contacts);
        btnContacts.setOnClickListener(this);
//        btnMycontentprovider=(Button)findViewById(R.id.btn_mycontentprovider);
//        btnMycontentprovider.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent =new Intent();
        switch (view.getId()) {
            case R.id.btn_contacts:
                intent.setClass(ContentProviderActivity.this,ContactsActivity.class);
                startActivity(intent);
                break;
//            case R.id.btn_mycontentprovider:
//                intent.setClass(MainActivity.this,MyCpActivity.class);
//                startActivity(intent);
//                break;
        }
    }
}
