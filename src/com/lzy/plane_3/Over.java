package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Over {
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("����", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("��Ϸ����", 0, 200);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("�ͷ�Over" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("����Over" + ke.getKeyCode());
	}
}
