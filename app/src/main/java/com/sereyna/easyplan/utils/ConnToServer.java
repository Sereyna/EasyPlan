package com.sereyna.easyplan.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnToServer {
	private String result;
	private Boolean isConnect = false;
	private String login_url = "http://120.79.59.245/zcw/login";
	private String signup_url = "http://120.79.59.245/zcw/signup";
	private OkHttpClient okHttpClient = new OkHttpClient();

	// 登录
	public String login_doPost(String name,String pwd) throws IOException {
		RequestBody formBody = new FormBody.Builder()
				.add("name",name)
				.add("password",pwd)
				.build();
		final Request request = new Request.Builder()
				.url(login_url)
				.post(formBody)
				.build();
		Response response;
		try{
			response = okHttpClient.newCall(request).execute();
			Log.d("loginToServer",String.valueOf(response.isSuccessful()));
			if (response.isSuccessful()){
				isConnect = true;
			}
			if(isConnect){
				result = response.body().string();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return result;
	}

	// 注册
	public String signup_doPost(String name,String pwd)throws IOException {
		RequestBody formBody = new FormBody.Builder()
				.add("name",name)
				.add("password",pwd)
				.build();
		final Request request = new Request.Builder()
				.url(signup_url)
				.post(formBody)
				.build();
		Response response;
		try{
			response = okHttpClient.newCall(request).execute();
			Log.d("loginToServer",String.valueOf(response.isSuccessful()));
			if (response.isSuccessful()){
				isConnect = true;
			}
			if(isConnect){
				result = response.body().string();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return result;
	}

}
