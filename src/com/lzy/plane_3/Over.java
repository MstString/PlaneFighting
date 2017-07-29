package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Over {
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("游戏结束", 0, 200);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("释放Over" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("按下Over" + ke.getKeyCode());
	}
}
