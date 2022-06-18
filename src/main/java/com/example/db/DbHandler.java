package com.example.db;

import java.util.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import java.sql.*;

public class DbHandler {
	
	private static String connectionString = "jdbc:mysql://localhost/students?user=root&password=";

	public static void addStudent(int rno, String name, double m1, double m2, double m3) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?)");
			stmt.setInt(1,rno);
			stmt.setDouble(2,m1);
			stmt.setDouble(3,m2);
			stmt.setDouble(4,m3);
			stmt.setString(5,name);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),"Record Added Successfully");
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
	}
	
	public static String[][] viewStudents() {
		
		int no_of_records = 0;
		ArrayList<Student> students = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				students.add(obj);
			}
			no_of_records = students.size();
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
		
		if(no_of_records == 0) {
			return null;
		}
		
		String[][] data = new String[no_of_records][5];
		
		int i=0;
		for(Student k : students) {
			data[i][0] = ""+ k.getRno();
			data[i][1] = ""+ k.getName();
			data[i][2] = ""+ k.getM1();
			data[i][3] = ""+ k.getM2();
			data[i][4] = ""+ k.getM3();
			i++;
		}	
		return data;
		
	}

	public static Student getStudentForUpdate(int rno) {
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE rno="+rno);
			if(rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				return obj;
			}
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
		return null;
	}

	public static void updateStudent(int rno, String name, double m1, double m2, double m3) {
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			PreparedStatement stmt = conn.prepareStatement("UPDATE students SET m1=?, m2=?, m3=?, name=? WHERE rno=?");
			stmt.setInt(5,rno);
			stmt.setDouble(1,m1);
			stmt.setDouble(2,m2);
			stmt.setDouble(3,m3);
			stmt.setString(4,name);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),"Record Updated Successfully");
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
	}
	
	public static Student getStudentForDelete(int rno) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE rno="+rno);
			if(rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				return obj;
			}
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
		return null;
	}

	public static void deleteStudent(int rno) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE rno=?");
			stmt.setInt(1,rno);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),"Record Deleted Successfully");
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
	}

	public static void chartFirstFive() {
		
		ArrayList<Student> students = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				students.add(obj);
			}
			
			DefaultCategoryDataset ds = new DefaultCategoryDataset();
			int i=1;
			for(Student k : students) {
				if(i>5) 
					break;
				ds.addValue(k.getM1(), k.getName(), "Subject 1");
				ds.addValue(k.getM2(), k.getName(), "Subject 2");
				ds.addValue(k.getM3(), k.getName(), "Subject 3");
				i++;
			}
			JFreeChart ch = ChartFactory.createBarChart("First 5 Students' Performance", "Subject", "Marks", ds, PlotOrientation.VERTICAL, true, true, false);
			ChartPanel cp = new ChartPanel(ch);
			JFrame f1 = new JFrame();
			f1.setContentPane(cp);
			f1.setTitle("Students Performance");
			f1.setSize(500,510);
			f1.setLocationRelativeTo(null);
			//f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f1.setVisible(true);
			
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}
		
	}

	public static void chartSubject1() {
		
		ArrayList<Student> students = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students ORDER BY m1 DESC");
			while (rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				students.add(obj);
			}
			
			DefaultCategoryDataset ds = new DefaultCategoryDataset();

			int i=1;
			for(Student k : students) {
				ds.addValue(k.getM1(), k.getName(), "Subject 1");
				if(i>=5)
					break;
				i++;
			}

			JFreeChart ch = ChartFactory.createBarChart("Top 5 in Subject 1", "Students", "Marks", ds, PlotOrientation.VERTICAL, true, true, false);
			ChartPanel cp = new ChartPanel(ch);
			JFrame f1 = new JFrame();
			f1.setContentPane(cp);
			f1.setTitle("Students Performance");
			f1.setSize(500,510);
			f1.setLocationRelativeTo(null);
			//f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f1.setVisible(true);
			
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}		
	}

	public static void chartSubject2() {
		ArrayList<Student> students = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students ORDER BY m2 DESC");
			while (rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				students.add(obj);
			}
			
			DefaultCategoryDataset ds = new DefaultCategoryDataset();

			int i=1;
			for(Student k : students) {
				ds.addValue(k.getM1(), k.getName(), "Subject 2");
				if(i>=5)
					break;
				i++;
			}

			JFreeChart ch = ChartFactory.createBarChart("Top 5 in Subject 2", "Students", "Marks", ds, PlotOrientation.VERTICAL, true, true, false);
			ChartPanel cp = new ChartPanel(ch);
			JFrame f1 = new JFrame();
			f1.setContentPane(cp);
			f1.setTitle("Students Performance");
			f1.setSize(500,510);
			f1.setLocationRelativeTo(null);
			//f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f1.setVisible(true);
			
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}	
	}

	public static void chartSubject3() {
		ArrayList<Student> students = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students ORDER BY m3 DESC");
			while (rs.next()) {
				Student obj = new Student();
				obj.setRno(rs.getInt(1));
				obj.setM1(rs.getDouble(2));
				obj.setM2(rs.getDouble(3));
				obj.setM3(rs.getDouble(4));
				obj.setName(rs.getString(5));
				students.add(obj);
			}
			
			DefaultCategoryDataset ds = new DefaultCategoryDataset();

			int i=1;
			for(Student k : students) {
				ds.addValue(k.getM1(), k.getName(), "Subject 3");
				if(i>=5)
					break;
				i++;
			}

			JFreeChart ch = ChartFactory.createBarChart("Top 5 in Subject 3", "Students", "Marks", ds, PlotOrientation.VERTICAL, true, true, false);
			ChartPanel cp = new ChartPanel(ch);
			JFrame f1 = new JFrame();
			f1.setContentPane(cp);
			f1.setTitle("Students Performance");
			f1.setSize(500,510);
			f1.setLocationRelativeTo(null);
			//f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f1.setVisible(true);
			
			conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue: "+e);
		}	
	}
		
}