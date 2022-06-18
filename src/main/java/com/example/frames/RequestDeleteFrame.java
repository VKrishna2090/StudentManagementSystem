package com.example.frames;

import javax.swing.*;

import com.example.MainFrame;
import com.example.db.DbHandler;
import com.example.db.Student;

import java.awt.*;
import java.awt.event.*;

public class RequestDeleteFrame extends JFrame {
	Container c;
	JLabel lbl_rno;
	JTextField txt_rno;
	JButton btn_delete, btn_back;
		
	public RequestDeleteFrame() {
		
		c = getContentPane();
		c.setLayout(new FlowLayout());

		Font f = new Font("Times New Roman",Font.BOLD, 20);

		lbl_rno = new JLabel("Enter Roll Number to be deleted");
		txt_rno = new JTextField(25);
		
		btn_delete = new JButton("Delete");
		btn_back = new JButton("Back");

		lbl_rno.setFont(f);
		txt_rno.setFont(f);
		btn_delete.setFont(f);
		btn_back.setFont(f);
		
		c.add(lbl_rno);
		c.add(txt_rno);
		c.add(btn_delete);
		c.add(btn_back);

		ActionListener a1 = (ae) -> { 
			MainFrame a = new MainFrame();
			dispose(); 
		};
		btn_back.addActionListener(a1);

		ActionListener a2 = (ae) -> { 
			int rno = Integer.parseInt(txt_rno.getText());
			if (rno<0) {
				JOptionPane.showMessageDialog(new JDialog(), "Roll no cannot be negative!");
				txt_rno.requestFocus();
			} else {
				Student s = DbHandler.getStudentForDelete(rno);
				if (s!=null) {
					DbHandler.deleteStudent(rno);
					RequestDeleteFrame obj = new RequestDeleteFrame();
					dispose();
				} else {
					JOptionPane.showMessageDialog(new JDialog(), "Student with this roll no not found!");
				}
	
				txt_rno.setText("");
			}
		};
		btn_delete.addActionListener(a2);

		setTitle("Delete Student Details");
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
