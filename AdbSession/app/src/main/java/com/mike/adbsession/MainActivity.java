package com.mike.adbsession;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private TextView mBooleanTextView;
    private TextView mStringTextView;
    private TextView mFloatTextView;
    private TextView mStringArrayTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBooleanTextView = (TextView) findViewById(R.id.extra_boolean_val_tv);
        mStringTextView = (TextView) findViewById(R.id.extra_string_val_tv);
        mFloatTextView = (TextView) findViewById(R.id.extra_float_val_tv);
        mStringArrayTextView = (TextView) findViewById(R.id.extra_string_aray_val_tv);


        try{
            mStringTextView.setText(getIntent().getExtras().getString("string"));
        } catch(Exception e)  {
            mStringTextView.setText("NONE");
        }

        try{
            mFloatTextView.setText(Float.toString(getIntent().getExtras().getFloat("float")));
        } catch(Exception e)  {
            mFloatTextView.setText("NONE");
        }

        try{
            mBooleanTextView.setText(Boolean.toString(getIntent().getExtras().getBoolean("bool", false)));
        } catch(Exception e)  {
            mBooleanTextView.setText("NONE");
        }

        try{
           String[] string_arrays = (String[]) getIntent().getExtras().get("string_array");
            mStringArrayTextView.setText(TextUtils.join(",", string_arrays));
        } catch(Exception e) {
            mStringArrayTextView.setText("NONE");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
