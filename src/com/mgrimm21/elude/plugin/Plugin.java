package com.mgrimm21.elude.plugin;

import java.awt.Graphics;

import com.mgrimm21.elude.main.Engine;

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
