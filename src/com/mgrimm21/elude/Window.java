package com.mgrimm21.elude;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	protected Dimension size;
	protected Canvas canvas = new Canvas();
	protected JFrame frame = new JFrame();
	
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
		canvas.setFocusable(true);
		canvas.requestFocus();
		canvas.setBackground(Color.black);
		frame.dispose();
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
	}
	
}
