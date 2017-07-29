package com.lzy.plane_4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane {
	Image planeimg = null;
	int x = 290;
	int y = 750;
	
	private boolean isUP = false;
	private boolean isDOWN = false;
	private boolean isRIGHT = false;
	private boolean isLEFT = false;
	public Plane() {
		try {
			planeimg = ImageIO.read(Play_1.class.getClassLoader().getResourceAsStream("images/Plane.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics gp) {
		gp.drawImage(planeimg, x, y, null);
		this.move();
	}
	
	public void move() {
		if(!isUP && !isDOWN && !isLEFT && !isRIGHT) {
			
		} else if (isUP && !isDOWN && !isLEFT && !isRIGHT) {
			// 上
			if (y >= 25)
			y -= 3;
		} else if (!isUP && isDOWN && !isLEFT && !isRIGHT) {
			// 下
			if (y <= 750)
			y += 3;
		} else if (!isUP && !isDOWN && isLEFT && !isRIGHT) {
			// 左
			if (x >= 0)
			x -= 3;
		} else if (!isUP && !isDOWN && !isLEFT && isRIGHT) {
			// 右
			if (x <= 550)
			x += 3;
		} else if (isUP && !isDOWN && isLEFT && !isRIGHT) {
			// 左上
			if (x >= 0 && y >= 25) {
				x -= 3;
				y -= 3;
			}
			
		} else if (!isUP && isDOWN && isLEFT && !isRIGHT) {
			// 左下
			if (x >= 0 && y <= 750) {
				x -= 3;
				y += 3;
			}
		} else if (isUP && !isDOWN && !isLEFT && isRIGHT) {
			// 右上
			if (x <= 550 && y >= 25) {
				x += 3;
				y -= 3;
			}
		} else if (!isUP && isDOWN && !isLEFT && isRIGHT) {
			// 右下
			if (x <= 550 && y <= 750) {
				x += 3;
				y += 3;
			}
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		System.out.println("X: " + x + " Y: " + y);
		if(ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
			isUP = false;
		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
			isDOWN = false;
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
			isRIGHT = false;
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
			isLEFT = false;
		}
	}
	
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
			isUP = true;
		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
			isDOWN = true;
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
			isRIGHT = true;
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
			isLEFT = true;
		}
	}
}
