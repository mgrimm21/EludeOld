package com.mgrimm21.elude;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class UIComponent{

	protected int x, y, width, height;
	private List<UIComponent> children = new ArrayList<UIComponent>();
	
	public UIComponent(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public void tickChildren() {
		synchronized(children) {
			for (UIComponent uic: children) uic.tick();
		}
	}
	
	public void renderChildren(Graphics g) {
		synchronized(children) {
			for (UIComponent uic: children) uic.render(g);
		}
	}
	
	public void addChild(UIComponent uic) {
		synchronized(children) {
			uic.x += x;
			uic.y += y;
			children.add(uic);
		}
	}
	
	public void removeChild(UIComponent uic) {
		synchronized(children) {
			children.remove(uic);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<UIComponent> getChildren() {
		return children;
	}
	
}
