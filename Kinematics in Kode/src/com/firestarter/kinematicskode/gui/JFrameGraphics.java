package com.firestarter.kinematicskode.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JFrameGraphics extends JPanel{
	private String text;
	private int x;
	private int y;
	
	public JFrameGraphics(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(text,x,y);
	}
}
