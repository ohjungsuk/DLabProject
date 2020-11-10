package com.dtps.chadwickschoolmeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText main_edtTv_id;
    EditText main_edtTv_pw;
    Button main_btn_signIn;
    Button main_btn_makeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
        activityMover();
    }

    public void setUp(){
        main_edtTv_id = (EditText)findViewById(R.id.main_edtTv_id);
        main_edtTv_pw = (EditText)findViewById(R.id.main_edtTv_pw);
        main_btn_signIn = (Button)findViewById(R.id.main_btn_signIn);
        main_btn_makeId = (Button)findViewById(R.id.main_btn_makeId);
    }

    public void activityMover(){
        main_btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        main_btn_makeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}