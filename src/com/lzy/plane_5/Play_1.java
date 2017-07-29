package com.lzy.plane_5;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

// 游戏第一关代码
public class Play_1 {
	
	private MainFrame mainframe;
	private Background background = new Background();
	private Plane plane = new Plane();
	private boolean isFire = false;
	private int FireTime = 0;
	List<Bulle> bulles = new ArrayList<Bulle>();
	
	public Play_1(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	public void draw(Graphics imggp) {
		// 画背景
		background.draw(imggp);
		// 画战斗机
		plane.draw(imggp);
		
		// 添加子弹
		if (isFire == true) {
			if (FireTime % 5 == 0)
			bulles.add(new Bulle(plane.getX() - 1, plane.getY() - 40));
			FireTime++;
		}
		
		// 移除子弹
		for (int i = 0; i < bulles.size(); i++) {
			Bulle bulle = bulles.get(i);
			if (bulle.getY() < 0) {
				bulles.remove(i);
			}
		}
		// 画子弹
		for (int i = 0; i < bulles.size(); i++) {
			Bulle bulle = bulles.get(i);
			bulle.draw(imggp);
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		plane.keyReleased(ke);
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			isFire = false;
			FireTime = 0;
		}
	}
	
	public void keyPressed(KeyEvent ke) {
		plane.keyPressed(ke);
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			isFire = true;
		}
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
