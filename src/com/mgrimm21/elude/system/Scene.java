package com.mgrimm21.elude.system;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.mgrimm21.elude.entity.GameObject;
import com.mgrimm21.elude.gfx.UIComponent;

public class Scene {
	
	private List<GameObject> objects = new ArrayList<GameObject>();
	private List<UIComponent> components = new ArrayList<UIComponent>();

	public void tick() {
		synchronized(objects) {
			for (GameObject obj: objects) obj.tick();
		}
		synchronized(components) {
			for (UIComponent comp: components) comp.tick();
		}
	}
	
	public void render(Graphics g) {
		synchronized(objects) {
			for (GameObject obj: objects) obj.render(g);
		}
		synchronized(components) {
			for (UIComponent comp: components) comp.render(g);
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
	
	public void addComponent(UIComponent obj) {
		synchronized(components) {
			components.add(obj);
		}
	}
	
	public void removeComponent(UIComponent obj) {
		synchronized(components) {
			components.remove(obj);
		}
	}
	
}
