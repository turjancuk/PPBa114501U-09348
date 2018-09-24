package com.example.lenovo.biodata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openUrl(View v){
        EditText edtUrl = (EditText) findViewById(R.id.urlText);
        Uri uri = Uri.parse("http://"+edtUrl.getText().toString());
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public  void callNumber(View view){
        EditText edtPhone = (EditText) findViewById(R.id.phoneText);
        Uri uri = Uri.parse("tel:"+edtPhone.getText().toString());
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }
    public void showMap(View view){
        Uri uri = Uri.parse("geo:0,0?q=-7.033191,110.381221");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

}
