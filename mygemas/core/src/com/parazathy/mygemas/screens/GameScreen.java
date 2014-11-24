package com.parazathy.mygemas.screens;

import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameworld.GameRendererGame;
import com.parazathy.mygemas.gameworld.GameWorldGame;

public class GameScreen extends MyScreen{

	public GameScreen() {		
		super(true);							
		this.setRenderer(new GameRendererGame(new GameWorldGame(this.getStage())));	
		MyGemas.getHandler().showInterstital();
	}
	
	
	@Override
	public void render(float delta) {
		this.setRunTime(this.getRunTime()+delta);		
		this.getRenderer().getWorld().update(delta);
		this.getRenderer().render(this.getRunTime());
		
	}

	@Override
	public void show() {		
		
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
		this.getRenderer().getWorld().dispose();
		
	}

}
