package com.lzy.plane_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	// 0 游戏开始之前 1 第一关 -1 游戏结束
	static int status = 0;
	public MainFrame() {
		this.setTitle("唔燎游戏");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		//添加键盘监听器
		this.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				if (status == 0) {
					before.keyReleased(ke);
				} else if (status == 1) {
					play_1.keyReleased(ke);
				} else {
					over.keyReleased(ke);
				}
			}
			
			public void keyPressed(KeyEvent ke) {
				if (status == 0) {
					before.keyPressed(ke);
				} else if (status == 1) {
					play_1.keyPressed(ke);
				} else {
					over.keyPressed(ke);
				}
			}
			
		});
		
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
		this.draw(Imggp);
		
		gp.drawImage(bufferedImage, 0, 0, null);
	}
	
	Before before = new Before();
	Play_1 play_1 = new Play_1();
	Over over = new Over();
	
	public void draw(Graphics gp) {
		if (status == 0) {
			before.draw(gp);
		} else if (status == 1) {
			play_1.draw(gp);
		} else {
			over.draw(gp);
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}
