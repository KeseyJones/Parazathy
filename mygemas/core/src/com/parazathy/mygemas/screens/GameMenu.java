package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.InputHandlerMenu;
import com.parazathy.mygemas.helpers.PlatformResolver;

public class GameMenu implements Screen {
	
	private GameWorldMenu world;
	private GameRendererMenu renderer;
	private float runTime;
	
	
	public GameMenu(PlatformResolver _resolver, int height, int width) {
		
		//Cargamos los elementos necesarios
		AssetLoader.loadLoadingFont(_resolver);
				
		world = new GameWorldMenu();
		renderer = new GameRendererMenu(world, height, width);

		Gdx.input.setInputProcessor(new InputHandlerMenu());

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.unloadMenuAssets();
		
	}

}
