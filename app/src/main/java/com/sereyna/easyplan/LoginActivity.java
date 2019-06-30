package com.sereyna.easyplan;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sereyna.easyplan.dao.UserDao;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		final EditText usernameEditText = findViewById(R.id.username);
		final EditText passwordEditText = findViewById(R.id.password);
		final Button loginButton = findViewById(R.id.login);                //登录按钮
		final ProgressBar loadingProgressBar = findViewById(R.id.loading);  //进度条
		TextView textView_registe = findViewById(R.id.textview_registe);

		//检查用户名或密码是否为空
		//功能有待提高
		loginButton.setEnabled(false);
		TextWatcher afterTextChangedListener = new TextWatcher() {
			private CharSequence text;
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				text = s;
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// ignore
			}

			@Override
			public void afterTextChanged(Editable s) {
				if(text.length()==0) {
					loginButton.setEnabled(false);
				}else
					loginButton.setEnabled(true);
			}
		};
		usernameEditText.addTextChangedListener(afterTextChangedListener);
		passwordEditText.addTextChangedListener(afterTextChangedListener);

		// 登录按钮
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							String result = UserDao.login_doPost(usernameEditText.getText().toString(),
									passwordEditText.getText().toString());
							if ("success".equals(result)) {
								Intent intent = new Intent(LoginActivity.this, MainActivity.class);
								Bundle bundle = new Bundle();
								bundle.putString("username", usernameEditText.getText().toString());
								intent.putExtra("login_bun", bundle);
								startActivity(intent);
								Looper.prepare();
								Toast.makeText(getBaseContext(),"登录成功",Toast.LENGTH_LONG).show();
								Looper.loop();
							}else {
								Looper.prepare();
								Toast.makeText(getBaseContext(),"登录失败",Toast.LENGTH_LONG).show();
								Looper.loop();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});

		//添加onclick事件 : 没有账号？注册一个
		textView_registe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(intent);
			}
		});


	}
}
