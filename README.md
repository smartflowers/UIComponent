# UIComponent
This is the third dormitory

# 实验内容
1.利用SimpleAdapter实现界面效果<br>
2.创建自定义布局的AlertDialog<br>
3.使用XML自定义菜单<br>
4.创建ActionMode的上下文菜单

# 关键代码
## （一）利用SimpleAdapter实现界面效果
1.SimpleAdapter装载listview
  ```
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adapter_init);
        listView=(ListView)findViewById(R.id.lv);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.simple_adapter_detail,new String[]{"pic","text"},new int[]{R.id.iv,R.id.tv});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }
  ```
2.Toast实现显示选中列表项信息
  ```
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
  ```
  ## （二）创建自定义布局的AlertDialog
  1.AlertDialog的创建及使用
  ```
  public void click(View view){
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(R.layout.loginview).
                setNegativeButton("Cancel", null).
                setPositiveButton("Sign in", null).create();
        alertDialog.show();
    }
  ```
  ## （三）使用XML自定义菜单
  1.菜单的xml建立
  ```
  <?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item1"
        android:title="字体大小" >
        <menu>
            <item
                android:id="@+id/inner1"
                android:title="小"/>
            <item
                android:id="@+id/inner2"
                android:title="中"/>
            <item
                android:id="@+id/inner3"
                android:title="大"/>
        </menu>
    </item>
    <item
        android:id="@+id/item2"
        android:title="普通菜单项" />
    <item
        android:id="@+id/item3"
        android:title="字体颜色" >
        <menu>
            <item
                android:id="@+id/inner4"
                android:title="红色"/>
            <item
                android:id="@+id/inner5"
                android:title="黑色"/>
        </menu>
    </item>
</menu>
  ```
  2.菜单点击事件改变
  ```
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
  ```
  ## （四）创建ActionMode的上下文菜单
  1.ActionMode在listview中创建
  ```
  listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                mode.setTitle(listView.getCheckedItemCount()+" selected");

            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.i1:
                        //deleteSelectedItems();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.action_mode, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
  ```
  2.选中列表项显示
  ```
  @Override
  public void onItemCheckedStateChanged(ActionMode mode, int position,
                                        long id, boolean checked) {
      // Here you can do something when items are selected/de-selected,
      // such as update the title in the CAB
      mode.setTitle(listView.getCheckedItemCount()+" selected");
  }
  ```
  3.颜色的改变<br>
  （1）建立一个xml文件
  ```
  <?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:state_activated="true"
        android:drawable="@color/blue"/>
</selector>
  ```
  （2）将该文件引入布局文件
  ```
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:background="@drawable/item"
    >
  ```
# 实验截图
（一）利用SimpleAdapter实现界面效果<br>
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/simple-adapter-listview.jpg)<br><br>
（二）创建自定义布局的AlertDialog<br>
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/AlretDialog.jpg)<br><br>
（三）使用XML自定义菜单<br>
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/XMLMenu.jpg)
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/XMLMenu1.jpg)
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/XMLMenu2.jpg)
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/XMLMenu3.jpg)<br><br>
（四）创建ActionMode的上下文菜单<br>
![无法加载](https://github.com/smartflowers/UIComponent/blob/master/pictures/ActionMode.jpg)


