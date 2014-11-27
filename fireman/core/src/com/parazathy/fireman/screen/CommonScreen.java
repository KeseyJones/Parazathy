package com.parazathy.fireman.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.parazathy.fireman.screen.renderer.CommonRenderer;
import com.parazathy.screen.world.CommonWorld;

public abstract class CommonScreen implements Screen{
	
	private static final int VIRTUAL_WIDTH = 272;
	private static final int VIRTUAL_HEIGHT = 408;
				
	private float runTime;		
	private CommonRenderer renderer;	
	private static Stage stage;	
	private CommonWorld world;
	
	protected CommonScreen(){		
			
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

	public void setRenderer(CommonRenderer renderer) {
		this.renderer = renderer;
	}

	public CommonRenderer getRenderer() {
		return renderer;
	}

	public Stage getStage() {
		return stage;
	}

	public CommonWorld getWorld() {
		return world;
	}

	public void setWorld(CommonWorld world) {
		this.world = world;
	}

}
