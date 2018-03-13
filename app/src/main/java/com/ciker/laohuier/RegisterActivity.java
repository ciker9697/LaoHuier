package com.ciker.laohuier;

import android.graphics.ColorSpace;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ciker.laohuier.db.User;

import org.litepal.tablemanager.Connector;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText boxAccount;
    EditText boxPassword;
    EditText boxPassword2;
    EditText boxName;
    RadioGroup boxSex;
    String account = null;
    String password = null;
    String password2 = null;
    String name = null;
    String sex = null;
    Button registerComplete;
    StringBuilder data = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        boxAccount = findViewById(R.id.register_account);
        boxAccount.addTextChangedListener(new AccountEditTextChangeListener());
        boxPassword = findViewById(R.id.register_password);
        boxPassword.addTextChangedListener(new PasswordEditTextChangeListener());
        boxPassword2 = findViewById(R.id.register_password2);
        boxPassword2.addTextChangedListener(new Password2EditTextChangeListener());
        boxName = findViewById(R.id.register_name);
        boxSex = findViewById(R.id.register_sex);
        registerComplete = findViewById(R.id.register_complete);
        registerComplete.setOnClickListener(this);
        SpannableString ss = new SpannableString("使用字符数至少6位且不超过13位字母和数字组合（特殊符号只能使用@_/）");
        AbsoluteSizeSpan textSize = new AbsoluteSizeSpan(10,true);
        ss.setSpan(textSize,0,ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        boxAccount.setHint(ss);
        boxPassword.setHint(ss);
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Button registerComplete = findViewById(R.id.register_complete);
    }
    public boolean checkAccount(){
        account = boxAccount.getText().toString();
        if(account.length()>= 6){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkPassword(){
        password = boxPassword.getText().toString();
        if(password.length()>=6){
            return true;
        }
        return false;
    }
    public boolean checkPassword2(){
        password2 = boxPassword2.getText().toString();
        if(password.equals(password2)){
            return true;
        }
        return false;
    }
    public boolean checkName() {
        name = boxName.getText().toString();
        if (name.length() > 3) {
            return true;
        }
        return false;
    }
    public String checkSex(){
        if(boxSex.getCheckedRadioButtonId() == R.id.male){
            sex="男";
        }else if(boxSex.getCheckedRadioButtonId() == R.id.female){
            sex="女";
        }else sex = null;
        return sex;
    }
    public boolean registerCheck(){
        if(checkAccount()){
            if(checkPassword()){
                if(checkPassword2()){
                    if(checkName()){
                        if(checkSex()!=null){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void registerCommit(){
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        data.append(account).append(name).append(sex);
        Connector.getDatabase();
        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.save();
        finish();
    }
    public class AccountEditTextChangeListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(boxAccount.getText().toString().length()<6){
                Snackbar.make(boxAccount,"账号填写不符合要求",Snackbar.LENGTH_SHORT).setAction("清空", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boxAccount.setText("");
                    }
                }).show();
            }
        }
    }
    public class PasswordEditTextChangeListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(boxPassword.getText().toString().length()<6){
                Snackbar.make(boxPassword,"密码过短",Snackbar.LENGTH_SHORT).setAction("清空", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boxPassword.setText("");
                    }
                }).show();
            }
        }
    }
    public class Password2EditTextChangeListener implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(!boxPassword2.getText().toString().equals(boxPassword.getText().toString())){
                Snackbar.make(boxPassword2,"两次所输密码不一致",Snackbar.LENGTH_SHORT).setAction("清空", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boxPassword2.setText("");
                    }
                }).show();
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_complete:
                if(registerCheck()){
                    registerCommit();
                    Log.d("RegisterActivity", data.toString());
                }else{
                    Toast.makeText(this,"data is wrong",Toast.LENGTH_SHORT).show();
                }
                break;
                default:break;
        }
    }
}
