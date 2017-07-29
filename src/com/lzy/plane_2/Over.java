package com.lzy.plane_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Over {
	public void draw(Graphics Imggp) {
		Imggp.setColor(Color.YELLOW);
		Imggp.setFont(new Font("¿¬Ìå", Font.BOLD + Font.ITALIC, 30));
		Imggp.drawString(""+Math.random(), 0, 200);
	}
}
