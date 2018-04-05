package com.mgrimm21.elude.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import com.mgrimm21.elude.gfx.Window;
import com.mgrimm21.elude.input.Keyboard;
import com.mgrimm21.elude.plugin.PluginLoader;
import com.mgrimm21.elude.system.Scene;
import com.mgrimm21.elude.system.SceneManager;

public class Engine implements Runnable{
	
	public static Engine instance;
	
	private Window window;
	private Thread thread;
	private int width, height;
	private boolean running = false;
	private Color backColor;
	private SceneManager sceneManager = new SceneManager();
	private PluginLoader pluginManager;
	
	public Engine(final Dimension windowSize) {
		pluginManager = new PluginLoader();
		instance = this;
		width = windowSize.width;
		height = windowSize.height;
		window = new Window(windowSize);
	}
	
	public synchronized void start() {
		if (running) return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if (Keyboard.down(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
		window.mouse.tick();
		sceneManager.tick();
		pluginManager.tick();
	}
	
	public void render() {
		BufferStrategy bs = window.canvas.getBufferStrategy();
		if (bs == null) {
			window.frame.setVisible(true);
			window.canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(backColor);
		g.fillRect(0, 0, width, height);
		sceneManager.render(g);
		pluginManager.render(g);
		g.dispose();
		bs.show();
	}
	
	
	public Engine setBackgroundColor(Color color) {
		this.backColor = color;
		return this;
	}
	
	public Engine setBackgroundColor(int color) {
		this.backColor = new Color(color);
		return this;
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void addScene(Scene scene) {
		sceneManager.addScene(scene);
	}
	
	public void removeScene(Scene scene) {
		sceneManager.removeScene(scene);
	}
	
	public void setScene(Scene scene) {
		sceneManager.setScene(scene);
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
}
