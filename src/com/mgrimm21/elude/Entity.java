package com.mgrimm21.elude;

import java.awt.Graphics;

public abstract class Entity extends GameObject{

	protected Sprite sprite;
	
	public Entity(int x, int y, Sprite sprite) {
		super(x, y, sprite.get().getWidth(), sprite.get().getHeight());
		this.sprite = sprite;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite.get(), x, y, null);
	}

}
