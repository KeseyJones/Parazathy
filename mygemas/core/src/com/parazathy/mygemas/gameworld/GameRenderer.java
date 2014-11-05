package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.parazathy.mygemas.helpers.AssetLoader;


public abstract class GameRenderer {
	
	private OrthographicCamera cam;
	private SpriteBatch batch;	
	private int height;
	private int width;	
	private GameWorld world;
	
	public GameRenderer(GameWorld world, int height, int width){	
		this.world = world;	
		this.height = height;
		this.width = width;
						
		cam = new OrthographicCamera();
		cam.setToOrtho(true, width, height);
		
		//Gdx.input.setCursorCatched(true);
		
		this.batch = new SpriteBatch();					
		
	}
	
	public void initRender(Rectangle viewport) {		
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		cam.update();
        //_camera.apply(Gdx.gl10);
        Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
        				  (int) viewport.width, (int) viewport.height);
        
        batch.setProjectionMatrix(cam.combined);
				
	}
	
	public void renderCursor(){
		
		batch.begin();		
        
        if (Gdx.app.getType() != ApplicationType.Android) {
        	Vector3 mousePos = new Vector3();
			mousePos.x = Gdx.input.getX();
			mousePos.y = Gdx.input.getY();
			cam.unproject(mousePos);
			batch.draw(AssetLoader._imgMouse, mousePos.x, mousePos.y);
		}
        
        batch.end();
	}
	
	public abstract void render(float runTime, Rectangle _viewport);

	public int getHeight() {
		return height;
	}	

	public int getWidth() {
		return width;
	}	

	public OrthographicCamera getCam() {
		return cam;
	}	

	public SpriteBatch getBatch() {
		return batch;
	}	

	public GameWorld getWorld() {
		return world;
	}	

}
