package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.ui.Cursor;


public abstract class GameRenderer {
				
	
	private GameWorld world;
	private Stage stage;
	private Cursor cursor;
		
	public GameRenderer(GameWorld world){	
		this.world = world;		
		this.stage = world.getStage();
		this.cursor = new Cursor(this.stage.getCamera());
						
		//Gdx.input.setCursorCatched(true);
		
		
	}
	
	public void renderLoading(){
		TextBounds bounds = AssetLoader.fontLoadingMenu.getBounds(world.getLoading());
		AssetLoader.fontLoadingMenu.draw(stage.getBatch(),world.getLoading(),(stage.getWidth() - bounds.width) / 2,(stage.getHeight() - bounds.height) / 2);
	}
	
	public void initRender() {		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		stage.getCamera().update();		
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
				
	}	
	
	public abstract void render(float runTime);		

	public GameWorld getWorld() {
		return world;
	}

	public Stage getStage() {
		return stage;
	}

	public Cursor getCursor() {
		return cursor;
	}	

}
