package com.parazathy.mygemas.screens;

import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;

public class GameMenu extends MyScreen {
				
	public GameMenu() {		
		super();							
		this.setRenderer(new GameRendererMenu(new GameWorldMenu(this.getStage())));					
	}

	@Override
	public void render(float delta) {
		this.setRunTime(this.getRunTime()+delta);		
		this.getRenderer().getWorld().update(delta);
		this.getRenderer().render(this.getRunTime());
		
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
		this.getRenderer().getWorld().dispose();
		
	}

}
