package com.mgrimm21.elude;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameObject {
	
	private int x, y, width, height;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void tick() {
		int v = 0;
		int h = 0;
		if (Keyboard.down(KeyEvent.VK_A)) h --;
		if (Keyboard.down(KeyEvent.VK_D)) h ++;
		if (Keyboard.down(KeyEvent.VK_W)) v --;
		if (Keyboard.down(KeyEvent.VK_S)) v ++;
		x += h;
		y += v;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
}
