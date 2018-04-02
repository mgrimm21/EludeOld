package com.mgrimm21.elude;

import java.awt.Toolkit;

public class Launcher {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Engine engine = new Engine(tk.getScreenSize()).setBackgroundColor(0x00);
		engine.start();
		Scene scene = new Scene();
		TestEntity ent = new TestEntity(400, 300);
		scene.addObject(ent);
		engine.addScene(scene);
	}

}
