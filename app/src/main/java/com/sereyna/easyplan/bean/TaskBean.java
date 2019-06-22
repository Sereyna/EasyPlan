package com.sereyna.easyplan.bean;

import java.util.Date;

public class TaskBean {
	private String taskname;
	private String taskcategory;
	private Date task_deadline;
	private int tasktype; //完成类型：一次性 规律重复
	private static double taskprogress;

	TaskBean(){

	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskcategory(String taskcategory) {
		this.taskcategory = taskcategory;
	}

	public String getTaskcategory() {
		return taskcategory;
	}

	public void setTask_deadline(Date task_deadline) {
		this.task_deadline = task_deadline;
	}

	public Date getTask_deadline() {
		return task_deadline;
	}

	public void setTasktype(int tasktype) {
		this.tasktype = tasktype;
	}

	public int getTasktype() {
		return tasktype;
	}

	public static void setTaskprogress(double taskprogress) {
		TaskBean.taskprogress = taskprogress;
	}

	public static double getTaskprogress() {
		return taskprogress;
	}
}
