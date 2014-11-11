package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.AssetLoader;

public class GameMenu extends MyScreen {
				
	public GameMenu(MyGemas game, int height, int width) {
		super(game, height, width);		
		
		//Cargamos la fuente de loading que el unico que necesito
		AssetLoader.loadLoadingFont();
						
		this.setRenderer(new GameRendererMenu(new GameWorldMenu(this)));					
	}

	@Override
	public void render(float delta) {
		this.setRunTime(this.getRunTime()+delta);		
		this.getRenderer().getWorld().update(delta);
		this.getRenderer().render(this.getRunTime(), this.getViewport());
		
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
		GameWorldMenu world = (GameWorldMenu)this.getRenderer().getWorld();
		world.setState(GameWorldMenu.StateMenu.Loading);
		world.setReadyToChange(false);		
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.unloadMenuAssets();
		
	}

}
