package com.lzy.plane_4;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

// 游戏第一关代码
public class Play_1 {
	
	private MainFrame mainframe;
	private Background background = new Background();
	private Plane plane = new Plane();
	
	public Play_1(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	public void draw(Graphics imggp) {
		background.draw(imggp);
		plane.draw(imggp);
	}
	
	public void keyReleased(KeyEvent ke) {
		plane.keyReleased(ke);
	}
	
	public void keyPressed(KeyEvent ke) {
		plane.keyPressed(ke);
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
