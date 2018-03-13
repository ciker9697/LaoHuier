package com.ciker.laohuier;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ciker.laohuier.db.User;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener{
    private String account = null;
    private String password = null;
    private User user;
    private ProgressBar progressBar;
    private AlertDialog.Builder builder;
    private AutoCompleteTextView accountView;
    private EditText passwordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountView = findViewById(R.id.account_edit_view);
        passwordView = findViewById(R.id.password);
        Button signInButton = findViewById(R.id.sign_in_button);
        progressBar = findViewById(R.id.login_progress);
        builder = new AlertDialog.Builder(this);
        signInButton.setOnClickListener(this);
        builder.setTitle("登陆失败").setMessage("账号或密码错误");
        TextView register = findViewById(R.id.register);
        register.setOnClickListener(this);
        builder.setPositiveButton("注册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                goToRegister();
            }
        });
        builder.setNegativeButton("忘记密码", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginActivity.this,"忘记密码",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToRegister() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public boolean isRegisteredUser(String account) {
        account = accountView.getText().toString();
        password = passwordView.getText().toString();
        List<User> userList = DataSupport.findAll(User.class);
        for(User user:userList){
            if(account.equals(user.getAccount())){
                this.user = user;
                return true;
            }
        }
        return false;
    }
    public boolean checkAccount(String account){
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                goToRegister();
                break;
            case R.id.sign_in_button:
//                if(isRegisteredUser(account)&&checkAccount(account)){
//                    progressBar.setVisibility(View.VISIBLE);
//                    Intent intent = new Intent(this,MainActivity.class);
//                    Toast.makeText(this,"欢迎您"+ user.getName()+"登录",Toast.LENGTH_SHORT).show();
//                    startActivity(intent);
//                    progressBar.setVisibility(View.INVISIBLE);
//                }else {
//                    builder.show();
//                }
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}

