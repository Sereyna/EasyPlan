package com.sereyna.easyplan.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sereyna.easyplan.R;
import com.sereyna.easyplan.bean.TaskBean;
import com.sereyna.easyplan.dao.TaskDao;

public class addtaskDialog extends Dialog implements View.OnClickListener {

	private TaskBean newtask;
	public addtaskDialog(@NonNull Context context) {
		super(context);
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.add_task_view);

		//设置弹窗的宽度
		WindowManager m = getWindow().getWindowManager();
		Display d = m.getDefaultDisplay();
		WindowManager.LayoutParams p =getWindow().getAttributes();
		Point size = new Point();
		d.getSize(size);
		p.width = (int)(size.x * 0.9);//是dialog的宽度为app界面的80%
		getWindow().setAttributes(p);

		Spinner spinner = findViewById(R.id.spinner);
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.cateitems_select, TaskDao.GetCategory());
		spinner.setAdapter(spinnerAdapter);

		Button button = findViewById(R.id.ok);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
	}
	@Override
	public void onClick(View view) {

	}

}
