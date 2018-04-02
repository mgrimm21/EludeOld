package com.mgrimm21.elude;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y, width, height;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
