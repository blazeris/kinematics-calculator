package com.firestarter.kinematicskode.gui;

import java.awt.Container;

import javax.swing.*;

public class Window extends JFrame{
	JFrame f;
	
	public Window() {
		setSize(1600,900);
		
		setLayout(null);
        
		setVisible(true);
	}
	
	public Container getCurPane() {
		return getContentPane();
	}
}
