package com.example.uicomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.*;
import android.widget.Toast;

public class Listview_Text extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adapter_init);
        listView=(ListView)findViewById(R.id.lv);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.simple_adapter_detail,new String[]{"pic","text"},new int[]{R.id.iv,R.id.tv});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }
    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String,Object> map=new HashMap<String, Object>() ;
        map.put("pic",R.drawable.lion);
        map.put("text","Lion");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.drawable.tiger);
        map.put("text","Tiger");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.drawable.monkey);
        map.put("text","Monkey");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.drawable.dog);
        map.put("text","Dog");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.drawable.cat);
        map.put("text","Cat");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.drawable.elephant);
        map.put("text","Elephant");
        list.add(map);
        return list;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*adapterView是指当前的listview；
         *view是当前listview中的item的view的布局,就是可用这个view获取里面控件id后操作控件
         * i是当前item在listview中适配器的位置
         * l是当前item在listview里第几行的位置
         */
        //获得选中项中的HashMap对象
        HashMap<String,String> map=(HashMap<String,String>)adapterView.getItemAtPosition(i);
        String Text=map.get("text");
        Toast.makeText(this,Text,Toast.LENGTH_SHORT).show();
    }

}

