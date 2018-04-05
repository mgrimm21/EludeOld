package com.mgrimm21.elude.test;

import java.awt.event.KeyEvent;

import com.mgrimm21.elude.entity.Entity;
import com.mgrimm21.elude.gfx.Sprite;
import com.mgrimm21.elude.input.Keyboard;

public class TestEntity extends Entity{

	public TestEntity(int x, int y) {
		super(x, y, new Sprite("test.png"));
	}

	@Override
	public void tick() {
		if (Keyboard.down(KeyEvent.VK_W)) y--;
		if (Keyboard.down(KeyEvent.VK_S)) y++;
		if (Keyboard.down(KeyEvent.VK_A)) x--;
		if (Keyboard.down(KeyEvent.VK_D)) x++;
	}

}
