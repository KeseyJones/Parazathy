package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.mygemas.helpers.AssetLoader;


public abstract class GameRenderer {
			
	public class Cursor extends Actor {
        
        @Override
        public void draw(Batch batch, float alpha){
        	if (Gdx.app.getType() != ApplicationType.Android) {
            	Vector3 mousePos = new Vector3();
    			mousePos.x = Gdx.input.getX();
    			mousePos.y = Gdx.input.getY();
    			stage.getCamera().unproject(mousePos);
    			batch.draw(AssetLoader.imgMouse, mousePos.x, mousePos.y);
    		}
        }
    }
	
	private GameWorld world;
	private Stage stage;
	private Cursor cursor;
		
	public GameRenderer(GameWorld world){	
		this.world = world;		
		this.stage = world.getStage();
		this.cursor = new Cursor();
						
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
