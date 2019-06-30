package com.sereyna.easyplan.fragment.main;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.sereyna.easyplan.R;
import com.sereyna.easyplan.bean.TaskBean;
import com.sereyna.easyplan.dao.TaskDao;
import com.sereyna.easyplan.dialog.*;

public class fragment_tasklist extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v_tl = inflater.inflate(R.layout.content_tasklist, container, false);

		addtaskDialog dialog = new addtaskDialog(getContext());

		FloatingActionButton fab = v_tl.findViewById(R.id.floatingActionButton);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dialog.show();
			}
		});

		return v_tl;
	}

}
