package com.example.frames;

import javax.swing.*;

import com.example.MainFrame;
import com.example.db.DbHandler;

import java.awt.*;
import java.awt.event.*;

public class ChartsFrame extends JFrame {
	Container c;
	JButton btn_chart1, btn_chart2, btn_chart3, btn_chart4, btn_back;
		
	public ChartsFrame() {
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

		Font f = new Font("Times New Roman",Font.BOLD, 20);
		
		btn_chart1 = new JButton("First 5 students");
		btn_chart1.setFont(f);
		c.add(btn_chart1);

		btn_chart2 = new JButton("Top 5 in Subject 1");
		btn_chart2.setFont(f);
		c.add(btn_chart2);
	
		btn_chart3 = new JButton("Top 5 in Subject 2");
		btn_chart3.setFont(f);
		c.add(btn_chart3);

		btn_chart4 = new JButton("Top 5 in Subject 3");
		btn_chart4.setFont(f);
		c.add(btn_chart4);

		btn_back = new JButton("Back");
		btn_back.setFont(f);
		c.add(btn_back);

		ActionListener a5 = (ae) -> { 
			MainFrame a = new MainFrame();
			dispose(); 
		};
		btn_back.addActionListener(a5);

		ActionListener a1 = (ae) -> { 
			DbHandler.chartFirstFive(); 
		};
		btn_chart1.addActionListener(a1);

		ActionListener a2 = (ae) -> { 
			DbHandler.chartSubject1();
		};
		btn_chart2.addActionListener(a2);

		ActionListener a3 = (ae) -> { 
			DbHandler.chartSubject2();
		};
		btn_chart3.addActionListener(a3);

		ActionListener a4 = (ae) -> { 
			DbHandler.chartSubject3(); 
		};
		btn_chart4.addActionListener(a4);

		setTitle("Charts");
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}