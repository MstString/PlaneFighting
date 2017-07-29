package com.lzy.plane_6;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	Image bgimg = null;
	int bgY = 0;
	int bgYY = 800;
	public Background() {
		try {
			bgimg = ImageIO.read(Play_1.class.getClassLoader().getResourceAsStream("images/Sky.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics gp) {
		gp.drawImage(bgimg, 0, bgY, null);
		bgY-=5;
		if (bgY == -800) {
			bgY = 0;
		}
		gp.drawImage(bgimg, 0, bgYY, null);
		bgYY-=5;
		if (bgYY == 0) {
			bgYY = 800;
		}
		
	}
}
