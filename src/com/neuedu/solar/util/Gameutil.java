package com.neuedu.solar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Gameutil {
	/**
	 * get the Image Object
	 */
	public static Image getImage(String imgPath) {
		URL u = Gameutil.class.getClassLoader().getResource(imgPath);
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
		
	}
}
