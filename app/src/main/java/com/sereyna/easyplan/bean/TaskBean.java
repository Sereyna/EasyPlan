package com.sereyna.easyplan.bean;

import java.util.Date;

public class TaskBean {
	private int userid;
	private String taskname;
	private String taskcategory;
	private Date task_deadline;
	private int tasktype; //完成类型：一次性 规律重复
	private int taskxundays;
	private double taskprogress;

	public TaskBean(String taskname, String taskcate, Date taskdeadline, int tasktype){
		this.taskname = taskname;
		this.taskcategory = taskcate;
		this.task_deadline = taskdeadline;
		this.tasktype = tasktype;
	}

	public TaskBean(String taskname, String taskcate, Date taskdeadline, int tasktype, int taskxundays){
		this.taskname = taskname;
		this.taskcategory = taskcate;
		this.task_deadline = taskdeadline;
		this.tasktype = tasktype;
		this.taskxundays = taskxundays;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUserid() {
		return userid;
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

	public void setTaskprogress(double taskprogress) {
		this.taskprogress = taskprogress;
	}

	public double getTaskprogress() {
		return taskprogress;
	}

	public void setTaskxundays(int taskxundays) {
		this.taskxundays = taskxundays;
	}

	public int getTaskxundays() {
		return taskxundays;
	}
}
