package com.kaige.bofo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private ListView lv_contacts;
    private String[] mNumber;
    private Button bt_add;
    private TextView tv_number;
    private EditText et_search;
    private ImageView iv_clearText;
    private String s;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();
        contextBox();



        lv_contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                String s = mNumber[position];
                intent.putExtra("number", s);// 第一个参数指定name，android规范是以包名+变量名来命名，后面是各种类型的数据类型
                intent.setClass(MainActivity.this, ItemContent.class);
                startActivity(intent);
            }
        });
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                et_search = (EditText) findViewById(R.id.et_search);
                s = et_search.getText().toString();
                intent.putExtra("number", s);
                intent.setClass(MainActivity.this, ItemContent.class);
                startActivity(intent);
            }
        });
    }

    private void contextBox() {
        ImageView iv_clearText = (ImageView) findViewById(R.id.iv_clearText);

    }


    private void initData() {
        mNumber = new String[]{"12312434", "34643245", "35353563", "837483759"
                , "935802895", "38478520", "35362346", "85739852"};
        lv_contacts.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mNumber.length;
        }

        @Override
        public Object getItem(int position) {
            return mNumber[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(), R.layout.item_contact, null);
            TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
            tv_number.setText(mNumber[position]);
            return view;
        }
    }

    private void initUI() {
        lv_contacts = (ListView) findViewById(R.id.lv_contacts);
    }
//    mEditText.addTextChangedListener(new
//
//    TextWatcher() {
//        @Override
//        public void onTextChanged (CharSequence s,int start, int before, int count){
//            if (s.length() > 0) {
//                customedittext.this.mButton.setVisibility(View.VISIBLE);
//            } else {
//                customedittext.this.mButton.setVisibility(View.INVISIBLE);
//            }
//        }
//        @Override
//        public void beforeTextChanged (CharSequence s,int start, int count,
//        int after){
//        }
//        @Override
//        public void afterTextChanged (Editable s){
//        }
//    });
//
//        this.mButton.setOnClickListener(new
//
//    OnClickListener() {
//        @Override
//        public void onClick (View v){
//            mEditText.getText().clear();//清空输入框
//        }
//    });


}