package com.parazathy.simulation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.simulation.Simulation;
import com.parazathy.simulation.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.TITLE;
		config.width = Constants.SCENE_WIDTH * Constants.SCALE;
		config.height = Constants.SCENE_HEIGHT * Constants.SCALE;				
		new LwjglApplication(new Simulation(), config);
	}
}
