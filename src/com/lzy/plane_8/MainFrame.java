package com.lzy.plane_8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	// 0 ��Ϸ��ʼ֮ǰ 1 ��һ�� -1 ��Ϸ����
	private int status = 0;
	private boolean isStop = false;
	public MainFrame() {
		this.setTitle("������Ϸ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		//��Ӽ��̼�����
		this.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_P) {
					isStop = !isStop; 
				} else {
					if (status == 0) {
						before.keyReleased(ke);
					} else if (status == 1) {
						play_1.keyReleased(ke);
					} else {
						over.keyReleased(ke);
					}
				}
			}
			
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() != KeyEvent.VK_P) {
					if (status == 0) {
						before.keyPressed(ke);
					} else if (status == 1) {
						play_1.keyPressed(ke);
					} else {
						over.keyPressed(ke);
					}
				}
			}
			
		});
		
		new Thread(){
			public void run() {
				while (true) {
					if (!isStop) {
						MainFrame.this.repaint();
					}
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
	// ��дJFrame�ķ���
	// �𵽿�һ���������� @Override
	public void paint(Graphics gp) {
		if (bufferedImage == null) {
			bufferedImage = this.createImage(600, 800);
		}
		Graphics Imggp = bufferedImage.getGraphics();
		Imggp.setColor(Color.BLACK);
		Imggp.fillRect(0, 0, 600, 800);
		this.draw(Imggp);
		
		gp.drawImage(bufferedImage, 0, 0, null);
	}
	
	private Before before = new Before(this);
	private Play_1 play_1 = new Play_1(this);
	private Over over = new Over(this);
	
	public void draw(Graphics gp) {
		if (status == 0) {
			before.draw(gp);
		} else if (status == 1) {
			play_1.draw(gp);
		} else if (status == -1){
			over.draw(gp);
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Play_1 getPlay_1() {
		return play_1;
	}

	public void setPlay_1(Play_1 play_1) {
		this.play_1 = play_1;
	}
	
}
