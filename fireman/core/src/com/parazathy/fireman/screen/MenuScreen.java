package com.parazathy.fireman.screen;

import com.parazathy.fireman.screen.renderer.MenuRenderer;
import com.parazathy.screen.world.MenuWorld;


public class MenuScreen extends CommonScreen{

	public MenuScreen() {		
		super();	
		this.setWorld(new MenuWorld());
		this.setRenderer(new MenuRenderer(this.getWorld(), this.getStage()));					
	}
	
	@Override
	public void render(float delta) {
		this.setRunTime(this.getRunTime()+delta);		
		this.getWorld().update(delta);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		this.getWorld().dispose();
		
	}

}
