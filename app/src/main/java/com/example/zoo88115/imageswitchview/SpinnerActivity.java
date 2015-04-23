package com.example.zoo88115.imageswitchview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SpinnerActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
    Spinner s1;
    ArrayAdapter<String> a1;
    String[] tea = {"請選擇", "紅茶", "綠茶", "奶茶"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        s1 = (Spinner)findViewById(R.id.spinner);
        a1 = new ArrayAdapter<String>(this, R.layout.spinner_format, tea);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);
        s1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String appear = "\n";
        TextView t = (TextView)findViewById(R.id.textView4);
        if(i == 0){
            appear += "請選擇飲料\n";
        }
        if(appear.equals("\n")){
            t.setText("您點的飲料是: " + tea[i]);
            t.setVisibility(View.VISIBLE);
        }
        else{
            t.setVisibility(View.INVISIBLE);
            Toast.makeText(this.getApplicationContext(), appear, Toast.LENGTH_SHORT).show();
            appear = "\n";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spinner, menu);
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
