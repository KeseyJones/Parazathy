package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Screen;
import com.parazathy.mygemas.gameworld.GameRenderer;
import com.parazathy.mygemas.gameworld.GameWorld;

public abstract class MyScreen  implements Screen{
	
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;

	protected GameWorld world;
	protected GameRenderer renderer;
	private float runTime;
	
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen - resizing");
	}

	@Override
	public void show() {
		System.out.println("GameScreen - show called");
	}

	@Override
	public void hide() {
		System.out.println("GameScreen - hide called");
	}

	@Override
	public void pause() {
		System.out.println("GameScreen - pause called");
	}

	@Override
	public void resume() {
		System.out.println("GameScreen - resume called");
	}

	@Override
	public void dispose() {
		// Leave blank
	}

	
}
