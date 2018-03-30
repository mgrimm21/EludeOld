package com.mgrimm21.elude;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene {
	
	private List<GameObject> objects = new ArrayList<GameObject>();

	public void tick() {
		synchronized(objects) {
			for (GameObject obj: objects) obj.tick();
		}
	}
	
	public void render(Graphics g) {
		synchronized(objects) {
			for (GameObject obj: objects) obj.render(g);
		}
	}
	
	public void addObject(GameObject obj) {
		synchronized(objects) {
			objects.add(obj);
		}
	}
	
	public void removeObject(GameObject obj) {
		synchronized(objects) {
			objects.remove(obj);
		}
	}
	
}
