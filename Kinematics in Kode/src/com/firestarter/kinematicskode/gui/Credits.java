package com.firestarter.kinematicskode.gui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Credits extends Window{
	JLabel dan,nathan,url1,url2,url3;
	Font font;
	public Credits() {
		setSize(550,200);
		font = new Font("Arial",Font.PLAIN,20);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		nathan = new JLabel("Did the code to show the numbers: Nathan Lai");
		add(nathan);
		nathan.setFont(font);
		dan = new JLabel("Did the code to actually make the numbers: Dan Nguyen");
		add(dan);
		dan.setFont(font);
		url1 = new JLabel("tinyurl.com/y6ze43yr");
		add(url1);
		url1.setFont(font);
		url2 = new JLabel("tinyurl.com/y2onh3fl");
		add(url2);
		url2.setFont(font);
		url3 = new JLabel("tinyurl.com/yctdqfpj");
		add(url3);
		url3.setFont(font);
	}
}
