package com.example.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class LoginActivity extends Activity {
    private EditText account;
    private EditText passWord;
    private Button bt;
    @Override
    public void onCreate(Bundle saveInstanceState){
         super.onCreate(saveInstanceState);

         setContentView(R.layout.login);
         account=(EditText)findViewById(R.id.account);
         passWord=(EditText)findViewById(R.id.password);
         bt=(Button)findViewById(R.id.bt);
         bt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String user=account.getText().toString();
                 String number=passWord.getText().toString();
                 if(TextUtils.isEmpty(user)||TextUtils.isEmpty(number)){
                     Toast.makeText(LoginActivity.this,"选项不能为空",Toast.LENGTH_SHORT).show();
                 }

                 if(!TextUtils.isEmpty(user)&&!isUserValid(user)){
                     Toast.makeText(LoginActivity.this,"账户缺省@字符",Toast.LENGTH_SHORT).show();
                 }

                 if(!TextUtils.isEmpty(number)&&isPassWordValid(number)){
                     Toast.makeText(LoginActivity.this,"密码太短",Toast.LENGTH_SHORT).show();
                 }

                 if(user.equals("example@qq.com")&&number.equals("123456")){
                     Toast.makeText(LoginActivity.this,"登录成功", LENGTH_SHORT).show();
                 };
             }
         });

    }

    private boolean isUserValid(String user){
        return user.contains("@");
    }
    private boolean isPassWordValid(String number ){
        return number.length()<6;
    }

}
