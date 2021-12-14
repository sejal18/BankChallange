package com.Account;

public class Account {
	private int accNo;
	private String uname;
	private String type;
	private double bal;
	private String sq;
	private String hint;
	private String pass;
	public String getName() {
		return uname;
	}
	public void setName(String name) {
		this.uname = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	
	public String toString() {
		return "Account [name=" + uname + ", type=" + type + ", bal=" + bal + "]";
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getSq() {
		return sq;
	}
	public void setSq(String sq) {
		this.sq = sq;
	}
	

}
