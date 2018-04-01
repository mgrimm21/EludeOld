import java.awt.Graphics;

import com.mgrimm21.elude.Plugin;

public class TestPlugin implements Plugin{

	@Override
	public void onEnable() {
		System.out.println("Test enabled");
	}

	@Override
	public void onDisable() {
		System.out.println("Test disabled");
	}

	@Override
	public void tick() {
		System.out.println("Test tick");
	}

	@Override
	public void render(Graphics g) {
		System.out.println("Test render");
	}

}
