package com.example.frames;

import javax.swing.*;

import com.example.MainFrame;
import com.example.db.DbHandler;

import java.awt.*;
import java.awt.event.*;

public class ViewFrame extends JFrame {
	Container c;
	JLabel lbl_info;
	JTable table_data;
	JScrollPane sp;
	JButton btn_back;
		
	public ViewFrame() {
		
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Font f = new Font("Times New Roman",Font.BOLD, 20);
		
		String[][] data = DbHandler.viewStudents();
		String[] colNames = {"RNo","Name","Marks1","Marks2","Marks3"};
		if(data==null){
			lbl_info = new JLabel("                             No data found!                             ");
			lbl_info.setFont(f);
			c.add(lbl_info);
		} else {
			table_data = new JTable(data, colNames);
			sp = new JScrollPane(table_data);
			c.add(sp);
		}

		btn_back = new JButton("Back");
		btn_back.setFont(f);
		c.add(btn_back);
		
		ActionListener a1 = (ae) -> { 
			MainFrame a = new MainFrame();
			dispose(); 
		};
		btn_back.addActionListener(a1);
		

		setTitle("View Student Details");
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}