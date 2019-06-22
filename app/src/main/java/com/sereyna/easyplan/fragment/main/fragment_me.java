package com.sereyna.easyplan.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sereyna.easyplan.R;

public class fragment_me extends Fragment {

	/*
	public fragment_main() {
		// Required empty public constructor
	}

	public static fragment_main newInstance() {
		fragment_main fragment = new fragment_main();
		return fragment;
	}
*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v_me = inflater.inflate(R.layout.content_me, container, false);
		final TextView text_name = v_me.findViewById(R.id.text_name1);
		final TextView text_email = v_me.findViewById(R.id.text_email1);

		Intent intent = getActivity().getIntent();
		Bundle bundle = intent.getBundleExtra("login_bun");
		text_name.setText(bundle.getCharSequence("username"));

		return v_me;
	}
}
