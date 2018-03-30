package com.mgrimm21.elude;

import java.awt.Color;
import java.awt.Toolkit;

public class Launcher {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Engine engine = new Engine(tk.getScreenSize()).setBackgroundColor(0x00);
		engine.start();
		Scene scene = new Scene();
		GameObject player = new GameObject(100, 100, 32, 32);
		scene.addObject(player);
		UIPanel panel = new UIPanel(400, 0, 500, 100, Color.red, Color.white);
		panel.addChild(new UIPanel(100, 40, 32, 32, Color.red, Color.yellow));
		scene.addComponent(panel);
		engine.addScene(scene);
	}

}
