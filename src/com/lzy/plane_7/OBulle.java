package com.lzy.plane_7;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBulle {
	Image bulleimg = null;
	int x = 290;
	int y = 700;
	
	int direction = (int)(Math.random()*8);
	public OBulle(int x, int y) {
		this.x = x;
		this.y = y;
		try {
			bulleimg = ImageIO.read(OBulle.class.getClassLoader().getResourceAsStream("images/OBulle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics gp) {
		gp.drawImage(bulleimg, x, y, null);
		this.move();
	}

	public void move() {
		if (direction == 0) {
			// 上
			y -= 6;
		} else if (direction == 1) {
			// 下
			y += 6;
		} else if (direction == 2) {
			// 左
			x -= 6;
		} else if (direction == 3) {
			// 右
			x += 6;
		} else if (direction == 4) {
			// 左上
				x -= 6;
				y -= 6;
			
		} else if (direction == 5) {
			// 左下
				x -= 6;
				y += 6;
		} else if (direction == 6) {
			// 右上
				x += 6;
				y -= 6;
		} else if (direction == 7) {
			// 右下
				x += 6;
				y += 6;
		}
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
	
}
