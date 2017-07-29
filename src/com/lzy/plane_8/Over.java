package com.lzy.plane_8;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
// 游戏结束
public class Over {
	private MainFrame mainframe;
	
	private Image img = null;
	
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString("继续挑战？Y/N", 210, 500);
		Imggp.drawImage(img, 200, 200, null);
	}
		public Over(MainFrame mainframe) {
		this.mainframe = mainframe;
		
		try {
			img = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/Over.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_Y) {
			mainframe.setStatus(0);
			Play_1 play_1 = new Play_1(mainframe); 
			mainframe.setPlay_1(play_1);
		} else if (ke.getKeyCode() == KeyEvent.VK_N) {
			System.exit(0);
		}
		
	}
	
	public void keyPressed(KeyEvent ke) {
	}
	
	public MainFrame getMainframe() {
		return mainframe;
	}
	
	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	
}
