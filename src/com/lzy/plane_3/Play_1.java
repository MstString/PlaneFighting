package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Play_1 {
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("����", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("��һ��", 200, 200);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("�ͷ�Play" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		System.out.println("����Play" + ke.getKeyCode());
	}
}
