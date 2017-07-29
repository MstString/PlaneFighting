package com.lzy.plane_8;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

// ��Ϸ��ʼ֮ǰ�Ĵ���
public class Before {
	private MainFrame mainframe;
	
	public Before(MainFrame mainframe) {
		this.mainframe = mainframe;
		
		try {
			img = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/Before.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Image img = null;
	
	int time = 0;
	public void draw(Graphics Imggp) {
		time++;
		Imggp.setColor(Color.WHITE);
		Imggp.setFont(new Font("����", Font.BOLD, 30));
		Imggp.drawString("������Ʒ", 240, 450);
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("��Բ", Font.BOLD + Font.ITALIC, 50));
		if (time <= 10) {
			Imggp.drawString("[Enter] >>", 150, 600);
		} else if (time <= 20) {
			Imggp.drawString("[Enter]  >>", 150, 600);
		} else if (time <= 30) {
			Imggp.drawString("[Enter]   >>", 150, 600);
			if(time == 30)
				time = 0;
		}
		Imggp.drawImage(img, 200, 200, null);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("�ͷ�" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		int keyCode = ke.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			// ����Ϸ״̬��ĳ�1
			mainframe.setStatus(1);
		}
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
