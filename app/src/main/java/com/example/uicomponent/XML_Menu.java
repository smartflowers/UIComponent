package com.example.uicomponent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class XML_Menu extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_menu);
        textView=(TextView)findViewById(R.id.tv1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.xml_menu, menu);
        return true;
    }
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.inner1:
                textView.setTextSize(10);
                break;
            case R.id.inner2:
                textView.setTextSize(16);
                break;
            case R.id.inner3:
                textView.setTextSize(20);
                break;
            case R.id.item2:
                Toast.makeText(this, "这是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.inner4:
                textView.setTextColor(Color.parseColor("#FF0000"));
                break;
            case R.id.inner5:
                textView.setTextColor(Color.parseColor("#000000"));
                break;
        }
        return true;
    }
}
