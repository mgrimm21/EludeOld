package com.mgrimm21.elude;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginLoader {
	
	private List<Plugin> plugins = new ArrayList<Plugin>();
	
	public PluginLoader() {
		File folder = new File("Plugins");
		ArrayList<String> files = listFilesForFolder(folder);
		for (String s: files) {
			s = s.replace(".java", "");
			s = s.trim();
			try {
				Class<?> c = Class.forName(s);
				plugins.add((Plugin) c.getDeclaredConstructor(Engine.class).newInstance(Engine.instance));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (Plugin p: plugins) {
				p.onEnable();
			}
		}
	}
	
	private ArrayList<String> listFilesForFolder(final File folder) {
		ArrayList<String> files = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            files.addAll(listFilesForFolder(fileEntry));
	        } else {
	            files.add(fileEntry.getName());
	        }
	    }
	    return files;
	}
	
	public void tick() {
		for (Plugin p: plugins) {
			p.tick();
		}
	}

	public void render(Graphics g) {
		for (Plugin p: plugins) {
			p.render(g);
		}
	}
	
	public void disable() {
		for (Plugin p: plugins) {
			p.onDisable();
		}
	}
	
}
