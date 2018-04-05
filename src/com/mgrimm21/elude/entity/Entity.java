package com.mgrimm21.elude.entity;

import java.awt.Graphics;

import com.mgrimm21.elude.gfx.Sprite;

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
