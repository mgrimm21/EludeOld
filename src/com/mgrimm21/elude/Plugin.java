package com.mgrimm21.elude;

import java.awt.Graphics;

public abstract class Plugin {
	
	public Engine engine;
	
	public Plugin(Engine engine) {
		this.engine = engine;
	}

	public abstract void onEnable();
	public abstract void onDisable();
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
