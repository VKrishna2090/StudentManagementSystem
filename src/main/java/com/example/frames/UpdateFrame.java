package com.example.frames;

import javax.swing.*;

import com.example.MainFrame;
import com.example.db.DbHandler;
import com.example.db.Student;
import com.example.db.Validations;

import java.awt.*;
import java.awt.event.*;

public class UpdateFrame extends JFrame {
	Container c;
	JLabel lbl_rno, lbl_name, lbl_m1, lbl_m2, lbl_m3;
	JTextField txt_rno, txt_name, txt_m1, txt_m2, txt_m3;
	JButton btn_save, btn_back;
		
	UpdateFrame(Student s) {
		
		c = getContentPane();
		c.setLayout(new FlowLayout());

		Font f = new Font("Times New Roman",Font.BOLD, 20);

		lbl_rno = new JLabel("Enter Roll Number ");
		txt_rno = new JTextField(25);
		lbl_name = new JLabel("Enter Name ");
		txt_name = new JTextField(25);
		lbl_m1 = new JLabel("Enter Marks in Subject 1 ");
		txt_m1 = new JTextField(25);
		lbl_m2 = new JLabel("Enter Marks in Subject 2 ");
		txt_m2 = new JTextField(25);
		lbl_m3 = new JLabel("Enter Marks in Subject 3 ");
		txt_m3 = new JTextField(25);
		btn_save = new JButton("Save");
		btn_back = new JButton("Back");

		lbl_rno.setFont(f);
		txt_rno.setFont(f);
		lbl_name.setFont(f);
		txt_name.setFont(f);
		lbl_m1.setFont(f);
		txt_m1.setFont(f);
		lbl_m2.setFont(f);
		txt_m2.setFont(f);
		lbl_m3.setFont(f);
		txt_m3.setFont(f);
		btn_save.setFont(f);
		btn_back.setFont(f);

		txt_rno.setText(""+s.getRno());
		txt_rno.setEditable(false);
			
		txt_name.setText(""+s.getName());
		txt_m1.setText(""+s.getM1());
		txt_m2.setText(""+s.getM2());
		txt_m3.setText(""+s.getM3());
		
		c.add(lbl_rno);
		c.add(txt_rno);
		c.add(lbl_name);
		c.add(txt_name);
		c.add(lbl_m1);
		c.add(txt_m1);
		c.add(lbl_m2);
		c.add(txt_m2);
		c.add(lbl_m3);
		c.add(txt_m3);
		c.add(btn_save);
		c.add(btn_back);

		ActionListener a1 = (ae) -> { 
			MainFrame a = new MainFrame();
			dispose(); 
		};
		btn_back.addActionListener(a1);

		ActionListener a2 = (ae) -> { 
			
			if(txt_rno.getText().equals("")) {
				JOptionPane.showMessageDialog(c, "Roll no field cannot be empty!");
				txt_rno.requestFocus();
			} else if(txt_name.getText().equals("")) {
				JOptionPane.showMessageDialog(c, "Name field cannot be empty!");
				txt_name.requestFocus();
			} else if(txt_m1.getText().equals("")) {
				JOptionPane.showMessageDialog(c, "Marks field cannot be empty!");
				txt_m1.requestFocus();
			} else if(txt_m2.getText().equals("")) {
				JOptionPane.showMessageDialog(c, "Marks field cannot be empty!");
				txt_m2.requestFocus();
			} else if(txt_m3.getText().equals("")) {
				JOptionPane.showMessageDialog(c, "Marks field cannot be empty!");
				txt_m3.requestFocus();
			} else {


			int rno = Integer.parseInt(txt_rno.getText());
			int check1 = 0;

			String name = txt_name.getText();
			int check2 = Validations.isNameValid(name);
			if(check2 == 1) {
				JOptionPane.showMessageDialog(c, "No of characters in name should be more than 1 and less than 30");
				txt_name.setText("");
				txt_name.requestFocus();
			} else if(check2 == 2) {
				JOptionPane.showMessageDialog(c, "Name can contain only letters or a blank space");
				txt_name.setText("");
				txt_name.requestFocus();
			}

			double m1 = Double.parseDouble(txt_m1.getText());
			double m2 = Double.parseDouble(txt_m2.getText());
			double m3 = Double.parseDouble(txt_m3.getText());
			int check31 = Validations.isMarksValid(m1);
			if(check31 == 1) {
				JOptionPane.showMessageDialog(c, "Marks should be between 0 and 100 only");
				txt_m1.setText("");
				txt_m1.requestFocus();
			}
			int check32 = Validations.isMarksValid(m2);
			if(check31==0 && check32 == 1) {
				JOptionPane.showMessageDialog(c, "Marks should be between 0 and 100 only");
				txt_m2.setText("");
				txt_m2.requestFocus();
			}
			int check33 = Validations.isMarksValid(m3);
			if(check31==0 && check32==0 && check33 == 1) {
				JOptionPane.showMessageDialog(c, "Marks should be between 0 and 100 only");
				txt_m3.setText("");
				txt_m3.requestFocus();
			}
			
			if(check1==0 && check2==0 && check31==0 && check32==0 && check33==0){
				DbHandler.updateStudent(rno, name, m1, m2, m3);
				RequestUpdateFrame obj = new RequestUpdateFrame();
				dispose();
			}

			}
		};
		btn_save.addActionListener(a2);

		setTitle("Update Student Details");
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
