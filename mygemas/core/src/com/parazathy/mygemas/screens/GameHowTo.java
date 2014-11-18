package com.parazathy.mygemas.screens;

import com.parazathy.mygemas.gameworld.GameRendererHowTo;
import com.parazathy.mygemas.gameworld.GameWorldHowTo;

public class GameHowTo extends MyScreen {
			
	
	public GameHowTo() {		
		super();
		this.setRenderer(new GameRendererHowTo(new GameWorldHowTo(this.getStage())));
					
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
		GameWorldHowTo world = (GameWorldHowTo)this.getRenderer().getWorld();
		world.setState(GameWorldHowTo.StateHowTo.Loading);
		world.setReadyToChange(false);		
		
	}

	@Override
	public void dispose() {
		this.getRenderer().getWorld().dispose();		
		
	}

	

}
