package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Before {
	
	Image img = null;
	public Before() {
		try {
			img = ImageIO.read(Before.class.getClassLoader().getResourceAsStream("images/BaiDu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int time = 0;
	public void draw(Graphics Imggp) {
		time++;
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("幼圆", Font.BOLD + Font.ITALIC, 50));
		if (time <= 10) {
			Imggp.drawString("[Enter] >>", 200, 400);
		} else if (time <= 20) {
			Imggp.drawString("[Enter]  >>", 200, 400);
		} else if (time <= 30) {
			Imggp.drawString("[Enter]   >>", 200, 400);
			if(time == 30)
				time = 0;
		}
		Imggp.drawImage(img, 150, 50, null);
	}
	public void keyReleased(KeyEvent ke) {
		System.out.println("释放" + ke.getKeyCode());
	}
	
	public void keyPressed(KeyEvent ke) {
		int keyCode = ke.getKeyCode();
		if (keyCode == 10) {
			// 将游戏状态码改成1
			MainFrame.status = 1;
		}
	}
}
