package com.mgrimm21.elude.system;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {

	private Scene activeScene;
	private List<Scene> scenes = new ArrayList<Scene>();
	
	public void addScene(Scene scene) {
		synchronized(scenes) {
			scenes.add(scene);
			if (activeScene == null) activeScene = scene;
		}
	}
	
	public void removeScene(Scene scene) {
		synchronized(scenes) {
			scenes.remove(scene);
			if (scene.equals(activeScene)) activeScene = null;
		}
	}
	
	public void tick() {
		if (activeScene != null) activeScene.tick();
	}
	
	public void render(Graphics g) {
		if (activeScene!= null) activeScene.render(g);
	}
	
	public void setScene(Scene s) {
		activeScene = s;
	}

	public Scene getActiveScene() {
		return activeScene;
	}

	public void setActiveScene(Scene activeScene) {
		this.activeScene = activeScene;
	}
	
	
	
}
