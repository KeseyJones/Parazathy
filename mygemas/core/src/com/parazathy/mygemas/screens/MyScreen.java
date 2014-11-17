package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.parazathy.mygemas.gameworld.GameRenderer;

public abstract class MyScreen implements Screen{
	
	private static final int VIRTUAL_WIDTH = 1280;
	private static final int VIRTUAL_HEIGHT = 720;
				
	private float runTime;		
	private GameRenderer renderer;	
	private static Stage stage;	
	
	protected MyScreen(){					
		OrthographicCamera camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		camera.setToOrtho(true, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		Viewport viewport = new ScalingViewport(Scaling.stretch, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		stage = new Stage(viewport);		
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

	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}

	public GameRenderer getRenderer() {
		return renderer;
	}

	public Stage getStage() {
		return stage;
	}
			
}
