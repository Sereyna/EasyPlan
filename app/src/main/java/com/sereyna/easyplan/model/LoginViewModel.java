package com.sereyna.easyplan.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Patterns;

import com.sereyna.easyplan.R;
import com.sereyna.easyplan.utils.LoginFormState;

public class LoginViewModel {

	private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();

	public LiveData<LoginFormState> getLoginFormState() {
		return loginFormState;
	}

	public void loginDataChanged(String username, String password) {
		if (!isUserNameValid(username)) {
			loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
		} else if (!isPasswordValid(password)) {
			loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
		} else {
			loginFormState.setValue(new LoginFormState(true));
		}
	}

	// A placeholder username validation check
	private boolean isUserNameValid(String username) {
		if (username == null) {
			return false;
		}
		if (username.contains("@")) {
			return Patterns.EMAIL_ADDRESS.matcher(username).matches();
		} else {
			return !username.trim().isEmpty();
		}
	}

	// A placeholder password validation check
	private boolean isPasswordValid(String password) {
		return password != null && password.trim().length() > 5;
	}
}
