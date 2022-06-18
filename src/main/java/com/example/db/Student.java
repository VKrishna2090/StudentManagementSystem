package com.example.db;

public class Student {

	private int rno;
	private String name;
	private double m1;
	private double m2;
	private double m3;

	Student () {}

	Student(int rno, String name, double m1, double m2, double m3) {
		this.rno = rno;
		this.name = name;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}

	//getter
	public int getRno() { return rno; }
	public String getName() { return name; }
	public double getM1() { return m1; }
	public double getM2() { return m2; }
	public double getM3() { return m3; }

	//setter
	public void setRno(int rno) { this.rno = rno; }
	public void setName(String name) { this.name = name; }
	public void setM1(double m1) { this.m1 = m1; }
	public void setM2(double m2) { this.m2 = m2; }
	public void setM3(double m3) { this.m3 = m3; }
}