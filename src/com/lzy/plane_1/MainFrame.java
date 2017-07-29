package com.lzy.plane_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public MainFrame() {
		this.setTitle("唔燎游戏");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		new Thread(){
			public void run() {
				while (true) {
					MainFrame.this.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	Image bufferedImage = null;
	// 重写JFrame的方法
	// 起到可一个检测的作用 @Override
	public void paint(Graphics gp) {
		if (bufferedImage == null) {
			bufferedImage = this.createImage(800, 600);
		}
		Graphics Imggp = bufferedImage.getGraphics();
		Imggp.setColor(Color.BLACK);
		Imggp.fillRect(0, 0, 800, 600);
		this.drawImg(Imggp);
		
		gp.drawImage(bufferedImage, 0, 0, null);
	}
	
	public void drawImg(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString(""+Math.random(), 200, 200);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}
