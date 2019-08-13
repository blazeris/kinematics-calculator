package com.firestarter.kinematicskode.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.firestarter.kinematicskode.utilities.Calculator;
import com.firestarter.kinematicskode.utilities.ImageLoader;

public class Results extends Window{
	JLabel imgLabel;
	ImageLoader imageLoader = new ImageLoader();
	Calculator calculator = new Calculator();
	JTextField viInp,vfInp,aInp,dInp,tInp;
	JButton submit;
	ArrayList<String> solve;
	Double vi,vf,a,d,t;
	JTextArea uvi,uvf,ua,ud,ut,work;
	Font font, font2,font3;
	JLabel vit,vft,at,dt,tt,given,unknown,formulas,solvet;
	
	public Results() {
		super();
		font = new Font("Serif", Font.PLAIN,24);
		font2 = new Font("Serif", Font.PLAIN,40);
		font3 = new Font("Serif", Font.BOLD,40);
		add(imageLoader.image("formulas.png", 50, 650, 700, 200));
		
		submit = new JButton("Calculate!");
	    add(submit);
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			vi = check(viInp.getText());
    			vf = check(vfInp.getText());
    			a = check(aInp.getText());
    			d = check(dInp.getText());
    			t = check(tInp.getText());
                printU();
                calculator.update(vi, vf, a, d, t);
                calculator.calculate();
                solve = calculator.getSolve();
                printS();
	    	}
	    });
	    submit.setBounds(550,200,200,50);
	    submit.setVisible(true);
	    
	    given = new JLabel("Given:");
	    add(given);
	    given.setBounds(50,0,200,50);
	    given.setFont(font3);
	    
	    unknown = new JLabel("Unknown:");
	    add(unknown);
	    unknown.setBounds(50,300,200,50);
	    unknown.setFont(font3);
	    
	    formulas = new JLabel("Formulas:");
	    add(formulas);
	    formulas.setBounds(50,600,200,50);
	    formulas.setFont(font3);
	    
	    solvet = new JLabel("Solve/Solution:");
	    add(solvet);
	    solvet.setBounds(850,0,300,50);
	    solvet.setFont(font3);
	    
	    vit = new JLabel("Initial Velocity (m/s)");
	    add(vit);
	    vit.setBounds(50,60,250,50);
	    vit.setFont(font);
	    
	    viInp = new JTextField(10);
	    viInp.setBounds(50,100,200,50);
	    add(viInp);
	    viInp.setVisible(true);
	    viInp.setFont(font);
	    
	    vft = new JLabel("Final Velocity (m/s)");
	    add(vft);
	    vft.setBounds(50,240,250,50);
	    vft.setFont(font);
	    
	    vfInp = new JTextField(10);
	    vfInp.setBounds(50,200,200,50);
	    add(vfInp);
	    vfInp.setFont(font);
	    
	    at = new JLabel("Acceleration (m/s²)");
	    add(at);
	    at.setBounds(300,60,200,50);
	    at.setFont(font);
	    
	    aInp = new JTextField(10);
	    aInp.setBounds(300,100,200,50);
	    add(aInp);
	    aInp.setFont(font);
	    
	    dt = new JLabel("Distance (m)");
	    add(dt);
	    dt.setBounds(300,240,200,50);
	    dt.setFont(font);
	    
	    dInp = new JTextField(10);
	    dInp.setBounds(300,200,200,50);
	    add(dInp);
	    dInp.setFont(font);
	    
	    tt = new JLabel("Time (s)");
	    add(tt);
	    tt.setBounds(550,60,200,50);
	    tt.setFont(font);
	    
	    tInp = new JTextField(10);
	    tInp.setBounds(550,100,200,50);
	    add(tInp);
	    tInp.setFont(font);

	    setUpU();
	    
		work = new JTextArea("Answer here",20,40);
		add(work);
		work.setBounds(850,100,700,750);
		work.setFont(font2);
		work.setVisible(true);
	}
	
	public void setUpU() {
		uvi = new JTextArea("Initial Velocity = ?");
		add(uvi);
		uvi.setBounds(50,400,200,50);
		uvi.setFont(font);
		uvi.setVisible(false);
		
		uvf = new JTextArea("Final Velocity = ?");
		add(uvf);
		uvf.setBounds(50,500,200,50);
		uvf.setFont(font);
		uvf.setVisible(false);
		
		ua = new JTextArea("Acceleration = ?");
		add(ua);
		ua.setBounds(300,400,200,50);
		ua.setFont(font);
		ua.setVisible(false);
		
		ud = new JTextArea("Distance = ?");
		add(ud);
		ud.setBounds(300,500,200,50);
		ud.setFont(font);
		ud.setVisible(false);
		
		ut = new JTextArea("Time = ?");
		add(ut);
		ut.setBounds(550,400,200,50);
		ut.setFont(font);
		ut.setVisible(false);
	}
	
	public void printU() {
		if(vi == null) {
			uvi.setVisible(true);
		}
		else {
			uvi.setVisible(false);
		}
		
		if(vf == null) {
			uvf.setVisible(true);
		}
		else {
			uvf.setVisible(false);
		}
		
		if(a == null) {
			ua.setVisible(true);
		}
		else {
			ua.setVisible(false);
		}
		
		if(d == null) {
			ud.setVisible(true);
		}
		else {
			ud.setVisible(false);
		}
		
		if(t == null) {
			ut.setVisible(true);
		}
		else {
			ut.setVisible(false);
		}
	}
	
	public void printS() {
		work.setText(null);
		
		if(solve.size() == 0) {
			work.setText("Nothing can be found");
		}
		else {
			for(int i = 0; i < solve.size();i++) {
				work.append(solve.get(i) + "\n");
			}
		}
	}
	
	public Double check(String c) {
		 try {
         	if(c.equals("")) {
         		return null;
         	}
         	return Double.valueOf(c);
		 }
		 catch(Exception e) {
			 return null;
		 }
	}
}
