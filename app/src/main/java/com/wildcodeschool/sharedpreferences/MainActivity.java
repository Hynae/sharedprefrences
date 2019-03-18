package com.wildcodeschool.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
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


        Button button = findViewById(R.id.bt_save);
        final EditText et_remember =  findViewById(R.id.et_remember);

        final TextView tv_response =  findViewById(R.id.tv_response);
        final SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("data", et_remember.getText().toString());
                editor.apply();
                tv_response.setText(sharedPreferences.getString("data"," empty"));

                Toast.makeText(MainActivity.this, " hey "+ sharedPreferences.getString("data","empty"), Toast.LENGTH_SHORT).show();

            }
        });



    }
}
