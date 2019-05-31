package com.example.layoutdemo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layoutdemo.BroadCastReceiver.BroadcastReceiverActivity;
import com.example.layoutdemo.ContentProvider.ContentProviderActivity;
import com.example.layoutdemo.LayoutActivity.LayoutActivity;
import com.example.layoutdemo.LayoutActivity.RelativeLayoutActivity;
import com.example.layoutdemo.MyView.MyViewActivity;
import com.example.layoutdemo.R;
import com.example.layoutdemo.Service.ServiceActivity;
import com.example.layoutdemo.sharedpreferencesdemo.SharedpreferencesActivity;

import butterknife.BindView;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_textview)
    Button btntextview;
    @BindView(R.id.btn_edittext)
    Button btnedittext;
    @BindView(R.id.btn_button)
    Button btnbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
    }

    private void initView() {
        btntextview = (Button) findViewById(R.id.btn_textview);
        btnedittext = (Button) findViewById(R.id.btn_edittext);
        btnbutton = (Button) findViewById(R.id.btn_button);
        btntextview.setOnClickListener(this);
        btnedittext.setOnClickListener(this);
        btnbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent mintent = new Intent();
        switch (v.getId()) {
            case R.id.btn_textview:
                mintent.setClass(this, TextViewActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_edittext:
                mintent.setClass(this, EditTextActivity.class);
                startActivity(mintent);
                break;
            case R.id.btn_button:
                mintent.setClass(this, ButtonAndImageButtonActivity.class);
                startActivity(mintent);
                break;
            default:
                break;
        }
    }
}
