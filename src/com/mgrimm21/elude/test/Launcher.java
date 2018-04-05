package com.mgrimm21.elude.test;

import java.awt.Toolkit;

import com.mgrimm21.elude.main.Engine;
import com.mgrimm21.elude.system.Scene;

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
