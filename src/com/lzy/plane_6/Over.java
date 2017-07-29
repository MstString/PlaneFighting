package com.lzy.plane_6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
// 游戏结束
public class Over {
	private MainFrame mainframe;
	
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("游戏结束", 0, 200);
	}	public Over(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	public void keyReleased(KeyEvent ke) {
		System.out.println("释放Over" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("按下Over" + ke.getKeyCode());
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
