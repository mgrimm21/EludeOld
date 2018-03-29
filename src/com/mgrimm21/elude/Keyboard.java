package com.mgrimm21.elude;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private static boolean[] down = new boolean[1000];
	private static boolean[] downnew = new boolean[1000];
	
	public static boolean down(int key) {
		return down[key];
	}
	
	public static boolean pressed(int key) {
		if (downnew[key]) {
			downnew[key] = false;
			return true;
		}
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		down[e.getKeyCode()] = true;
		downnew[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		down[e.getKeyCode()] = false;
		downnew[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
