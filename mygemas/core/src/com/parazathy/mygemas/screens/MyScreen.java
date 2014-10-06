package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.parazathy.mygemas.gameworld.GameRenderer;
import com.parazathy.mygemas.gameworld.GameWorld;

public abstract class MyScreen  implements Screen{

	protected GameWorld world;
	protected GameRenderer renderer;
	protected float screenWidth = Gdx.graphics.getWidth();
	protected float screenHeight = Gdx.graphics.getHeight();
	protected float gameWidth = 136;
	protected float gameHeight = screenHeight / (screenWidth / gameWidth);
	protected int midPointY = (int) (gameHeight / 2);
	
	
}
