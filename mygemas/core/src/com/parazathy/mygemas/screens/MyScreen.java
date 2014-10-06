package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Screen;
import com.parazathy.mygemas.gameworld.GameRenderer;
import com.parazathy.mygemas.gameworld.GameWorld;

public abstract class MyScreen  implements Screen{
	
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;

	protected GameWorld world;
	protected GameRenderer renderer;
	
	
	
	
}
