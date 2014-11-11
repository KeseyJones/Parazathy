package com.parazathy.mygemas.screens;

import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameworld.GameRendererHowTo;
import com.parazathy.mygemas.gameworld.GameWorldHowTo;

public class GameHowTo extends MyScreen {
			
	
	public GameHowTo(MyGemas game, int height, int width) {
		super(game, height, width);	
				
		this.setRenderer(new GameRendererHowTo(new GameWorldHowTo(this)));				
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	

}
