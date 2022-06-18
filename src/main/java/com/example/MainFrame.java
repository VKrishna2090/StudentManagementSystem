package com.example;

import javax.swing.*;

import com.example.frames.*;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	Container c;
	JButton btn_add, btn_view, btn_update, btn_delete, btn_graph;
		
	public MainFrame() {
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\vkris\\Downloads\\bgcolorimage.png")));
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

		Font f = new Font("Times New Roman",Font.BOLD, 20);
		
		btn_add = new JButton("Add student details");
		btn_add.setFont(f);
		c.add(btn_add);

		btn_view = new JButton("View student details");
		btn_view.setFont(f);
		c.add(btn_view);
	
		btn_update = new JButton("Update student details");
		btn_update.setFont(f);
		c.add(btn_update);

		btn_delete = new JButton("Delete student details");
		btn_delete.setFont(f);
		c.add(btn_delete);

		btn_graph = new JButton("Chart student details");
		btn_graph.setFont(f);
		c.add(btn_graph);

		ActionListener a1 = (ae) -> { 
			AddFrame a = new AddFrame();
			dispose(); 
		};
		btn_add.addActionListener(a1);

		ActionListener a2 = (ae) -> { 
			ViewFrame a = new ViewFrame();
			dispose(); 
		};
		btn_view.addActionListener(a2);

		ActionListener a3 = (ae) -> { 
			RequestUpdateFrame a = new RequestUpdateFrame();
			dispose(); 
		};
		btn_update.addActionListener(a3);

		ActionListener a4 = (ae) -> { 
			RequestDeleteFrame a = new RequestDeleteFrame();
			dispose(); 
		};
		btn_delete.addActionListener(a4);

		ActionListener a5 = (ae) -> { 
			ChartsFrame a = new ChartsFrame();
			dispose(); 
		};
		btn_graph.addActionListener(a5);

		setTitle("Student Management System");
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}