package com.mgrimm21.elude.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private BufferedImage image;
	
	public Sprite(String path) {
		try {
			image = ImageIO.read(new File("res/sprites/" + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage get() {
		return image;
	}
	
}
