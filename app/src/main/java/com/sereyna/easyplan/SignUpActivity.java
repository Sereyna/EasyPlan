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
import android.widget.Toast;

import com.sereyna.easyplan.utils.ConnToServer;

import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registe);

		final EditText usernameEditText = findViewById(R.id.username_signup);
		final EditText passwordEditText = findViewById(R.id.password_signup);
		final Button signupButton = findViewById(R.id.signup);                //注册按钮
		final ProgressBar loadingProgressBar = findViewById(R.id.loading);  //进度条

		//检查用户名或密码是否为空
		//功能有待提高
		signupButton.setEnabled(false);
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
					signupButton.setEnabled(false);
				}else
					signupButton.setEnabled(true);
			}
		};
		usernameEditText.addTextChangedListener(afterTextChangedListener);
		passwordEditText.addTextChangedListener(afterTextChangedListener);

		signupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						ConnToServer connToServer = new ConnToServer();
						try {
							String result = connToServer.signup_doPost(usernameEditText.getText().toString(),
									passwordEditText.getText().toString());
							if ("success".equals(result)) {
								Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
								startActivity(intent);
								Looper.prepare();
								Toast.makeText(getBaseContext(),"注册成功",Toast.LENGTH_LONG).show();
								Looper.loop();
							}else {
								Looper.prepare();
								Toast.makeText(getBaseContext(),"注册失败",Toast.LENGTH_LONG).show();
								Looper.loop();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});

	}
}
