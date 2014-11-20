package com.parazathy.myzombiebird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.parazathy.myzombiebird.MyZombieBird;

public abstract class MyScreen implements Screen{
		
	private static final int VIRTUAL_WIDTH = 136;
				
	private float runTime;			
	private static Stage stage;	
	
	protected MyScreen(boolean showAds){	
		MyZombieBird.getHandler().showAds(showAds);
		
		float gameHeight = Gdx.graphics.getHeight() / (Gdx.graphics.getWidth() / VIRTUAL_WIDTH);
		OrthographicCamera camera = new OrthographicCamera(VIRTUAL_WIDTH, gameHeight);
		camera.setToOrtho(true, VIRTUAL_WIDTH, gameHeight);
		Viewport viewport = new ScalingViewport(Scaling.stretch, VIRTUAL_WIDTH, gameHeight, camera);
		stage = new Stage(viewport);			
		
		this.runTime = 0;
		
	}

	@Override
	public void resize(int width, int height) {	
						
        //ACtualizamos el stage
        stage.getViewport().update(width, height, true);   
           		
          
	}
	
	public float getRunTime() {
		return runTime;
	}

	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}		

	public Stage getStage() {
		return stage;
	}
			
}
