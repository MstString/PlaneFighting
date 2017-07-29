package com.lzy.plane_8;

import java.awt.Graphics;
import java.awt.Rectangle;
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
	// ����л��ӵ�
	private List<OBulle> obulles = new ArrayList<OBulle>();
	
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
			// ���������ӵ����ٶ�
			if (FireTime % 10 == 0)
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
		
		// ��ӵл��ӵ�
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			int x = oplane.getX();
			int y = oplane.getY();
			if ((int)(Math.random()*50) == 10) {
				obulles.add(new OBulle(x + 20, y + 40));
			}
		}
		
		// �Ƴ��л��ӵ�
		for (int i = 0; i < obulles.size(); i++) {
			OBulle obulle = obulles.get(i);
			if (obulle.getX() < -100 || obulle.getY() < -100 || obulle.getX() > 600 || obulle.getY() > 800) {
				obulles.remove(i);
			}
		}
		// ���л��ӵ�
		for (int i = 0; i < obulles.size(); i++) {
			OBulle obulle = obulles.get(i);
			obulle.draw(imggp);
		}
		
		// �ж�ս���е�
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
		
		// �жϵл��е�
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
		
		// �жϵл���ս����ײ
		for (int i = 0; i < oplanes.size(); i++) {
			OPlane oplane = oplanes.get(i);
			Rectangle opr = oplane.getRectangle();
			Rectangle pr = plane.getRectangle();
			if (pr.intersects(opr)) {
				oplanes.remove(i);
				plane.setLife(plane.getLife()-1);
			}
		}
		
		// �жϵл���л���ײ
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
