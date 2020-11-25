package com.dtps.chadwickschoolmeals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.dtps.chadwickschoolmeals.interfaces.RegisterEvalActivityView;
import com.dtps.chadwickschoolmeals.models.RegisterEvalResponse;
import com.dtps.chadwickschoolmeals.services.RegisterEvalService;

public class RegisterEvalActivity extends AppCompatActivity implements RegisterEvalActivityView {

    ImageButton registerEval_btn_back;
    Button registerEval_btn_done;
    RatingBar registerEval_ratingbar;
    EditText registerEval_edt_comment;
    int mfoodIdx;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_eval);

        setUp();

        Intent intent = getIntent();
        mfoodIdx = intent.getExtras().getInt("foodIdx");
        date = intent.getExtras().getString("date");

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
                Log.d("abc",String.valueOf(mfoodIdx));
                Log.d("abc",String.valueOf(registerEval_ratingbar.getRating()));
                Log.d("abc",registerEval_edt_comment.getText().toString());
                new RegisterEvalService(RegisterEvalActivity.this).postRegisterEval(
                        mfoodIdx,
                        registerEval_ratingbar.getRating(),
                        registerEval_edt_comment.getText().toString(),
                        RegisterEvalActivity.this.date
                );

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



    @Override
    public void validateSuccess(RegisterEvalResponse response) {
        if(response == null){
            Toast.makeText(RegisterEvalActivity.this, "something wrong in validateSuccess", Toast.LENGTH_SHORT).show();
        }else{
            switch(response.getCode()){
                case 200:
                    Toast.makeText(RegisterEvalActivity.this, "리뷰 등록 완료", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 400:
                    Toast.makeText(RegisterEvalActivity.this, "리뷰 등록 실패", Toast.LENGTH_SHORT).show();
                    break;
                case 413:
                    Toast.makeText(RegisterEvalActivity.this, "score를 입력해주세요", Toast.LENGTH_SHORT).show();
                    break;
                case 414:
                    Toast.makeText(RegisterEvalActivity.this, "comment를 입력해주세요", Toast.LENGTH_SHORT).show();
                    break;
                case 461:
                    Toast.makeText(RegisterEvalActivity.this, "이미 리뷰를 작성하셨습니다.", Toast.LENGTH_SHORT).show();
                    break;
                case 452:
                    Toast.makeText(RegisterEvalActivity.this, "해당 날짜에 메뉴가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void validateFailure() {
        Toast.makeText(RegisterEvalActivity.this, "Error", Toast.LENGTH_SHORT).show();
    }
}