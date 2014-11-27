package com.parazathy.fireman.screen.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.screen.world.CommonWorld;


public abstract class CommonRenderer {
				
	
	private CommonWorld world;	
	private Stage stage;
	
		
	public CommonRenderer(CommonWorld world, Stage stage){	
		this.world = world;	
		this.stage = stage;
		
		
	}
		
	
	public void initRender() {		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		this.stage.getCamera().update();		
		this.stage.getBatch().setProjectionMatrix( this.stage.getCamera().combined);
				
	}	
	
	public abstract void render(float runTime);		

	public CommonWorld getWorld() {
		return world;
	}


	public Stage getStage() {
		return stage;
	}	
	
	
}
