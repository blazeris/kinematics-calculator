package com.firestarter.kinematicskode.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LandingPage extends Window {
	JButton getStarted;
	JButton credits;
	JLabel title;
	Font titlef;
	
	Credits creditPage;
	Results resultPage;
	
	public LandingPage() {
		getStarted = new JButton("Get started");
		getStarted.setBounds(600,500,400,100);
		credits = new JButton("Credits");
		credits.setBounds(600,700,400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titlef = new Font("Century Gothic",Font.BOLD,150);
		title = new JLabel("Kinematics In Kode");
		add(title);
		title.setBounds(0,0,1600,500);
		title.setFont(titlef);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		getStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPage = new Results();
			}
		});
		
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditPage = new Credits();
			}
		});
		add(getStarted);
		add(credits);
	}
}
