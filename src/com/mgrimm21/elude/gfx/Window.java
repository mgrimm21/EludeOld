package com.mgrimm21.elude.gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mgrimm21.elude.input.Keyboard;
import com.mgrimm21.elude.input.Mouse;

public class Window {

	protected Dimension size;
	public Canvas canvas = new Canvas();
	public JFrame frame = new JFrame();
	public Mouse mouse = new Mouse(this);
	
	public Window(Dimension size) {
		this.size = size;
		frame.setPreferredSize(size);
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(canvas);
		canvas.addKeyListener(new Keyboard());
		canvas.addMouseListener(mouse);
		canvas.setFocusable(true);
		canvas.requestFocus();
		canvas.setBackground(Color.black);
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
	}
	
}
