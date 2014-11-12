package com.parazathy.myzombiebird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.gameworld.GameRenderer;
import com.parazathy.myzombiebird.gameworld.GameWorld;
import com.parazathy.myzombiebird.myzbhelpers.InputHandler;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	private MyZombieBird game;

	// This is the constructor, not the class declaration
	public GameScreen(MyZombieBird game) {

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);

		int midPointY = (int) (gameHeight / 2);

		//Ponemos la publicidad
		this.game = game;
		game.getHandler().showAds(true);
		
		world = new GameWorld(midPointY);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);		
		world.setRenderer(renderer);

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}

	@Override
	public void resize(int width, int height) {		
	}

	@Override
	public void show() {		
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {		
	}

}
