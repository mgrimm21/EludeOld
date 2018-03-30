package com.mgrimm21.elude;

import java.awt.Color;
import java.awt.Graphics;

public class UIPanel extends UIComponent{

	private Color border, back;
	
	public UIPanel(int x, int y, int width, int height, Color border, Color back) {
		super(x, y, width, height);
		this.border = border;
		this.back = back;
	}

	@Override
	public void tick() {
		tickChildren();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(back);
		g.fillRect(x, y, width, height);
		g.setColor(border);
		g.drawRect(x, y, width, height);
		renderChildren(g);
	}

}
