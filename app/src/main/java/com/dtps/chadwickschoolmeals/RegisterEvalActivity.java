package com.dtps.chadwickschoolmeals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

public class RegisterEvalActivity extends AppCompatActivity {

    ImageButton registerEval_btn_back;
    Button registerEval_btn_done;
    RatingBar registerEval_ratingbar;
    EditText registerEval_edt_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_eval);

        setUp();
        activityMover();
    }
    public void setUp(){
        registerEval_btn_back = (ImageButton)findViewById(R.id.registerEval_btn_back);
        registerEval_btn_done = (Button)findViewById(R.id.registerEval_btn_done);
        registerEval_edt_comment = (EditText)findViewById(R.id.registerEval_edt_comment);
        registerEval_ratingbar = (RatingBar)findViewById(R.id.registerEval_ratingbar);
    }

    public void activityMover(){
        registerEval_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(RegisterEvalActivity.this)
                        .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                        .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(RegisterEvalActivity.this,EvaluateActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
        registerEval_btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterEvalActivity.this, EvaluateActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(RegisterEvalActivity.this)
                .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(RegisterEvalActivity.this,EvaluateActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}