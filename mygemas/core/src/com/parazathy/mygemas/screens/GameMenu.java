package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.InputHandlerMenu;
import com.parazathy.mygemas.helpers.PlatformResolver;

public class GameMenu extends MyScreen {
	
	private GameWorldMenu world;
	private GameRendererMenu renderer;
	private float runTime;
	private PlatformResolver _resolver;
	
	
	public GameMenu(PlatformResolver _resolver, int height, int width) {
		super(height, width);
		this._resolver = _resolver;
		
		//Cargamos la fuente de loading que el unico que necesito
		AssetLoader.loadLoadingFont(this._resolver);
				
		world = new GameWorldMenu();
		renderer = new GameRendererMenu(world, height, width);
		world.setRenderer(renderer);
		world.set_resolver(this._resolver);

		Gdx.input.setInputProcessor(new InputHandlerMenu(world));
		
		

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime, this.get_viewport());
		
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
		world.set_state(GameWorldMenu.StateMenu.Loading);
		world.set_readyToChange(false);		
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.unloadMenuAssets();
		
	}

}
