package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Play_1 {
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("第一关", 200, 200);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("释放Play" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("按下Play" + ke.getKeyCode());
	}
}
