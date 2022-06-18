package com.example;

import javax.swing.*;
import java.awt.*;

public class SplashFrame extends JFrame {
	Container c;
	JLabel lbl_msg;
		
	SplashFrame() {
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\vkris\\Downloads\\bgimage.jpg")));
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Font f = new Font("Times New Roman",Font.BOLD, 50);

		lbl_msg = new JLabel("<html><center>Welcome<br>to<br>Student Management<br>System</center></html>");
		lbl_msg.setFont(f);
		lbl_msg.setForeground(Color.decode("#000080"));
		c.add(lbl_msg);
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					dispose();
					MainFrame m = new MainFrame();	
				} catch(Exception e) {

				}
			}
		}.start();
		
		setUndecorated(true);
		setSize(500,510);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}