package com.lzy.plane_6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
// ��Ϸ����
public class Over {
	private MainFrame mainframe;
	
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("����", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("��Ϸ����", 0, 200);
	}	public Over(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	public void keyReleased(KeyEvent ke) {
		System.out.println("�ͷ�Over" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("����Over" + ke.getKeyCode());
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
