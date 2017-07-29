package com.lzy.plane_6;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

// ��Ϸ��һ�ش���
public class Play_1 {
	
	private MainFrame mainframe;
	private Background background = new Background();
	private Plane plane = new Plane();
	private boolean isFire = false;
	private int FireTime = 0;
	// ����ӵ�
	private List<Bulle> bulles = new ArrayList<Bulle>();
	// ���ս��
	
	private List<OPlane> oplanes = new ArrayList<OPlane>();
	public Play_1(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	public void draw(Graphics imggp) {
		// ������
		background.draw(imggp);
		// ��ս����
		plane.draw(imggp);
		
		// ����ӵ�
		if (isFire == true) {
			if (FireTime % 5 == 0)
			bulles.add(new Bulle(plane.getX() - 1, plane.getY() - 40));
			FireTime++;
		}
		
		// �Ƴ��ӵ�
		for (int i = 0; i < bulles.size(); i++) {
			Bulle bulle = bulles.get(i);
			if (bulle.getY() < 0) {
				bulles.remove(i);
			}
		}
		
		// ���ӵ�
		for (int i = 0; i < bulles.size(); i++) {
			Bulle bulle = bulles.get(i);
			bulle.draw(imggp);
		}
		
		// ��ӵл�
		if ((int)(Math.random()*50) == 10) {
			oplanes.add(new OPlane());
		}
		// �Ƴ��л�
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			if (oplane.getY() > 900) {
				oplanes.remove(i);
			}
		}
		// ���л�
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			oplane.draw(imggp);
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
