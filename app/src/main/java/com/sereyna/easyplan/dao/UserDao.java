package com.sereyna.easyplan.dao;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserDao {

	private static String result;
	private static Boolean isConnect = false;
	private static final String login_url = "http://120.79.59.245/zcw/login";
	private static final String signup_url = "http://120.79.59.245/zcw/signup";
	private static OkHttpClient okHttpClient = new OkHttpClient();

	// 登录
	public static String login_doPost(String name,String pwd) throws IOException {
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
	public static String signup_doPost(String name,String pwd)throws IOException {
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
