package com.mgrimm21.elude.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.mgrimm21.elude.gfx.Window;

public class Mouse implements MouseListener{

	public static int x = 0, y = 0;
	public static boolean clicked = false;
	private Window window;
	
	public Mouse(Window window) {
		this.window = window;
	}
	
	public void tick() {
		x = window.canvas.getMousePosition().x;
		y = window.canvas.getMousePosition().y;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		clicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		clicked = false;
	}

}
