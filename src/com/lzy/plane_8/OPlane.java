package com.lzy.plane_8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OPlane {
	Image planeimg = null;
	int x = 0; // 0 ~ 550
	int y = 0;
	public OPlane() {
		this.x = (int)(Math.random()*551);
		try {
			int num = (int)(Math.random()*6)+1;
			planeimg = ImageIO.read(Play_1.class.getClassLoader().getResourceAsStream("images/Plane"+ num +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics gp) {
		gp.drawImage(planeimg, x, y, null);
		y++;
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
		return new Rectangle(x, y, planeimg.getWidth(null), planeimg.getHeight(null));
	}
}
