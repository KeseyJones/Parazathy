package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.LanguagesManager;

public class GameMenu extends MyScreen {
	
	private GameWorldMenu world;
	private GameRendererMenu renderer;
	private float runTime;	
	
	
	public GameMenu(MyGemas game, LanguagesManager languagesManager, int height, int width) {
		super(languagesManager, height, width);		
		
		//Cargamos la fuente de loading que el unico que necesito
		AssetLoader.loadLoadingFont();
				
		world = new GameWorldMenu(game, languagesManager);
		renderer = new GameRendererMenu(world, height, width);
		world.setRenderer(renderer);				
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime, this.getViewport());
		
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
		world.setState(GameWorldMenu.StateMenu.Loading);
		world.set_readyToChange(false);		
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.unloadMenuAssets();
		
	}

}
