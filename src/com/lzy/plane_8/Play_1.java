package com.lzy.plane_8;

import java.awt.Graphics;
import java.awt.Rectangle;
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
	// 多个子弹
	private List<Bulle> bulles = new ArrayList<Bulle>();
	// 多架战机
	private List<OPlane> oplanes = new ArrayList<OPlane>();
	// 多个敌机子弹
	private List<OBulle> obulles = new ArrayList<OBulle>();
	
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
			// 调整发射子弹的速度
			if (FireTime % 10 == 0)
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
		
		// 添加敌机
		if ((int)(Math.random()*50) == 10) {
			oplanes.add(new OPlane());
		}
		// 移除敌机
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			if (oplane.getY() > 900) {
				oplanes.remove(i);
			}
		}
		// 画敌机
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			oplane.draw(imggp);
		}
		
		// 添加敌机子弹
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			int x = oplane.getX();
			int y = oplane.getY();
			if ((int)(Math.random()*50) == 10) {
				obulles.add(new OBulle(x + 20, y + 40));
			}
		}
		
		// 移除敌机子弹
		for (int i = 0; i < obulles.size(); i++) {
			OBulle obulle = obulles.get(i);
			if (obulle.getX() < -100 || obulle.getY() < -100 || obulle.getX() > 600 || obulle.getY() > 800) {
				obulles.remove(i);
			}
		}
		// 画敌机子弹
		for (int i = 0; i < obulles.size(); i++) {
			OBulle obulle = obulles.get(i);
			obulle.draw(imggp);
		}
		
		// 判断战机中弹
		for (int i = 0; i < obulles.size(); i++) {
			OBulle obulle = obulles.get(i);
			Rectangle obr = obulle.getRectangle();
			Rectangle pr = plane.getRectangle();
			if (obr.intersects(pr)) {
				obulles.remove(i);
				plane.setLife(plane.getLife()-1);
				if (plane.getLife() < 0) {
					mainframe.setStatus(-1);
				}
			}
		}
		
		// 判断敌机中弹
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			Rectangle opr = oplane.getRectangle();
			for (int j = 0; j < bulles.size(); j++) {
				Bulle bulle = bulles.get(j);
				Rectangle br = bulle.getRectangle();
				if (opr.intersects(br)) {
					oplanes.remove(i);
					bulles.remove(j);
				}
			}
		}
		
		// 判断敌机与战机相撞
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			Rectangle opr = oplane.getRectangle();
			Rectangle pr = plane.getRectangle();
			if (pr.intersects(opr)) {
				oplanes.remove(i);
				plane.setLife(plane.getLife()-1);
			}
		}
		
		// 判断敌机与敌机相撞
		for (int i = 0; i < oplanes.size(); i++) {
			for (int j = 0; j < oplanes.size(); j++) {
				if (i != j) {
					OPlane oplane1 = oplanes.get(i);
					OPlane oplane2 = oplanes.get(j);
					Rectangle opr1 = oplane1.getRectangle();
					Rectangle opr2 = oplane2.getRectangle();
					if (opr2.intersects(opr1)) {
						oplanes.remove(i);
					}
				}
			}
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
