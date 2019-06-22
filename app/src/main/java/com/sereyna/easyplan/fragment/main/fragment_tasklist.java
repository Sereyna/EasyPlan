package com.sereyna.easyplan.fragment.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sereyna.easyplan.R;

public class fragment_tasklist extends Fragment {
	/*
	public fragment_tasklist() {
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
		return inflater.inflate(R.layout.content_tasklist, container, false);
	}
}
