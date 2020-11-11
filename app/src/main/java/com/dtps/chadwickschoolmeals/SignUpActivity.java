package com.dtps.chadwickschoolmeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dtps.chadwickschoolmeals.interfaces.SignUpActivityView;
import com.dtps.chadwickschoolmeals.services.SignUpService;

public class SignUpActivity extends AppCompatActivity implements SignUpActivityView {

    Button signUP_btn_done;
    Toolbar signUP_toolbar;
    CheckBox signUP_CBox_student;
    CheckBox signUP_CBox_admin;
    EditText signUP_edt_id;
    EditText signUP_edt_pw;
    EditText signUP_edt_name;
    EditText signUP_edt_grade;
    EditText signUP_edt_class;
    EditText signUP_edt_bday;
    EditText signUP_edt_adminCode;
    LinearLayout signUP_Linear_code,signUP_Linear_Bday,signUP_Linear_class,signUP_Linear_grade;

    public int State_student=0;
    public int State_admin=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUP_toolbar = (Toolbar)findViewById(R.id.signUP_toolbar);
        setSupportActionBar(signUP_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUp();
        activityMover();
        checkBoxControl();
    }

    public void setUp(){
        signUP_btn_done = (Button)findViewById(R.id.signUP_btn_done);
        signUP_CBox_student = (CheckBox)findViewById(R.id.signUP_CBox_student);
        signUP_CBox_admin = (CheckBox)findViewById(R.id.signUP_CBox_admin);
        signUP_edt_id = (EditText)findViewById(R.id.signUP_edt_id);
        signUP_edt_pw = (EditText)findViewById(R.id.signUP_edt_pw);
        signUP_edt_name = (EditText)findViewById(R.id.signUP_edt_name);
        signUP_edt_grade = (EditText)findViewById(R.id.signUP_edt_grade);
        signUP_edt_class = (EditText)findViewById(R.id.signUP_edt_class);
        signUP_edt_bday = (EditText)findViewById(R.id.signUP_edt_bday);
        signUP_edt_adminCode = (EditText)findViewById(R.id.signUP_edt_adminCode);
        signUP_Linear_code = (LinearLayout)findViewById(R.id.signUP_Linear_code);
        signUP_Linear_grade = (LinearLayout)findViewById(R.id.signUP_Linear_grade);
        signUP_Linear_class = (LinearLayout)findViewById(R.id.signUP_Linear_class);
        signUP_Linear_Bday = (LinearLayout)findViewById(R.id.signUP_Linear_Bday);
    }



    public void activityMover(){
        signUP_btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(State_admin == 1 || State_student == 1){
                    new SignUpService(SignUpActivity.this).postSignUp(
                            signUP_edt_id.getText().toString(),
                            signUP_edt_pw.getText().toString(),
                            signUP_edt_name.getText().toString(),
                            Integer.parseInt(signUP_edt_grade.getText().toString()),
                            signUP_edt_class.getText().toString(),
                            signUP_edt_bday.getText().toString()
                    );

//                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"소속을 선택해주세요",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void checkBoxControl(){
        signUP_CBox_student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    State_student=1;
                    signUP_CBox_admin.setChecked(false);
                    if(signUP_Linear_code.getVisibility() == compoundButton.VISIBLE){
                        signUP_Linear_code.setVisibility(compoundButton.GONE);
                    }
                    if(signUP_Linear_grade.getVisibility() == compoundButton.GONE){
                        signUP_Linear_grade.setVisibility(compoundButton.VISIBLE);
                    }
                    if(signUP_Linear_class.getVisibility() == compoundButton.GONE){
                        signUP_Linear_class.setVisibility(compoundButton.VISIBLE);
                    }
                    if(signUP_Linear_Bday.getVisibility() == compoundButton.GONE){
                        signUP_Linear_Bday.setVisibility(compoundButton.VISIBLE);
                    }
                }else{
                    State_student=0;
                }
            }
        });
        signUP_CBox_admin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    State_admin=1;
                    signUP_CBox_student.setChecked(false);
                    if(signUP_Linear_code.getVisibility() == compoundButton.GONE){
                        signUP_Linear_code.setVisibility(compoundButton.VISIBLE);
                    }
                    if(signUP_Linear_grade.getVisibility() == compoundButton.VISIBLE){
                        signUP_Linear_grade.setVisibility(compoundButton.GONE);
                    }
                    if(signUP_Linear_class.getVisibility() == compoundButton.VISIBLE){
                        signUP_Linear_class.setVisibility(compoundButton.GONE);
                    }
                    if(signUP_Linear_Bday.getVisibility() == compoundButton.VISIBLE){
                        signUP_Linear_Bday.setVisibility(compoundButton.GONE);
                    }
                }else{
                    State_admin=0;

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(SignUpActivity.this)
                .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                new AlertDialog.Builder(SignUpActivity.this)
                        .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                        .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
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
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void validateSuccess() {
        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateFailure() {
        Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show();
    }
}