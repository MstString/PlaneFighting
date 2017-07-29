package com.lzy.plane_8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bulle {
	Image bulleimg = null;
	int x = 290;
	int y = 700;
	
	public Bulle(int x, int y) {
		this.x = x;
		this.y = y;
		try {
			bulleimg = ImageIO.read(Bulle.class.getClassLoader().getResourceAsStream("images/Bulle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics gp) {
		gp.drawImage(bulleimg, x, y, null);
		y -= 8;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// 自定义一个获取图片矩形的方法
	public Rectangle getRectangle() {
		return new Rectangle(x, y, bulleimg.getWidth(null), bulleimg.getHeight(null));
	}
}
