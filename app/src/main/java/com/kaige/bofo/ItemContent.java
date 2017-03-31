package com.kaige.bofo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by dell on 2017/3/15.
 */

public class ItemContent extends Activity {
    private EditText et_number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String message = intent.getStringExtra("number");
        et_number = (EditText) findViewById(R.id.et_number);
        et_number.setText(message);


    }
}
