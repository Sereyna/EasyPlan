package com.sereyna.easyplan.dao;

import com.sereyna.easyplan.bean.TaskBean;

import java.util.ArrayList;
import java.util.Date;

public class TaskDao {

	private static ArrayList<TaskBean> tasklist = new ArrayList<>(); //已经有的列表
	private static ArrayList<String> taskcategory = new ArrayList<String>(){{add("无类别");add("wu");}};

	public static void AddTask(String taskname, String taskcate, Date taskdeadline, int tasktype, int taskxundays){
		TaskBean taskBean = new TaskBean(taskname, taskcate, taskdeadline, tasktype, taskxundays);
		tasklist.add(taskBean);
	}

	public static void AddTask(String taskname, String taskcate, Date taskdeadline, int tasktype){
		TaskBean taskBean = new TaskBean(taskname, taskcate, taskdeadline, tasktype);
		tasklist.add(taskBean);
	}

	public static ArrayList<TaskBean> GetTask(){
		return tasklist;
	}

	public static void DeleteTask(){

	}

	public static void ChangeTask(){

	}

	//
	public static void AddCategory(String cate){
		taskcategory.add(cate);
	}

	public static ArrayList<String> GetCategory(){
		return taskcategory;
	}

	public static void DeleteCategory(String cate){
		taskcategory.remove(cate);
	}
}
