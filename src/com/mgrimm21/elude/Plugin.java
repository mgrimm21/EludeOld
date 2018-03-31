package com.mgrimm21.elude;

import java.awt.Graphics;

public interface Plugin {

	void onEnable();
	void onDisable();
	void tick();
	void render(Graphics g);
	
}
