package com.mgrimm21.elude;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class UIButton extends UIComponent{

	private boolean clicked = false, hovering = false;
	private Color backNormal, backHover, backClicked;
	
	public UIButton(int x, int y, int width, int height, Color backNormal, Color backHover, Color backClicked) {
		super(x, y, width, height);
		this.backHover = backHover;
		this.backNormal = backNormal;
		this.backClicked = backClicked;
	}

	@Override
	public void tick() {
		if (Mouse.x >= x && Mouse.x <= x + width) {
			if (Mouse.y >= y && Mouse.y <= y + height) {
				hovering = true;
				if (Mouse.clicked) {
					clicked = true;
				}else {
					if (clicked) {
						clicked = false;
						onClick();
					}else
					clicked = false;
				}
			}else {
				hovering = false;
				clicked = false;
			}
		}else {
			hovering = false;
			clicked = false;
		}
	}
	
	public abstract void onClick();

	@Override
	public void render(Graphics g) {
		if (clicked) {
			g.setColor(backClicked);
		}else if (hovering) {
			g.setColor(backHover);
		}else {
			g.setColor(backNormal);
		}
		g.fillRect(x, y, width, height);
	}
	
}
