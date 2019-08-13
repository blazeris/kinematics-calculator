package com.firestarter.kinematicskode.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLoader {	
	public ImageLoader() {
	}
	
	public JLabel image(String file,int x,int y,int width,int height) {
		String PATH_NAME = "src/images/" + file;
		try {
			BufferedImage img = ImageIO.read(new File(PATH_NAME));
			ImageIcon imgI = new ImageIcon(img);
			JLabel imgLabel = new JLabel(imgI);
			imgLabel.setBounds(x,y,width,height);
			imgLabel.setVisible(true);
			return imgLabel;
	    }
	    catch(IOException ie)
	    {
	        System.out.println(ie.getMessage());
	    }
		
		
	    return null;
	}
}
