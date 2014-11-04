package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.LanguagesManager;


public abstract class GameRenderer {
	
	private OrthographicCamera cam;
	private SpriteBatch _batch;
	private Vector3 _mousePos;	
	private LanguagesManager _lang;
	private int myGameHeight;
	private int myGameWidth;	
	private GameWorld myworld;
	
	public GameRenderer(GameWorld world, int gameHeight, int gameWidth){	
		myworld = world;
		myGameHeight = gameHeight;
		myGameWidth = gameWidth;
		
		//Obtenemos el singleton de language
		_lang = LanguagesManager.getInstance();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);
		
		//Gdx.input.setCursorCatched(true);
		
		_batch = new SpriteBatch();
		
		_mousePos = new Vector3();
		
		
	}
	
	public void initRender(Rectangle _viewport) {		
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		cam.update();
        //_camera.apply(Gdx.gl10);
        Gdx.gl.glViewport((int) _viewport.x, (int) _viewport.y,
        				  (int) _viewport.width, (int) _viewport.height);
        
        _batch.setProjectionMatrix(cam.combined);
				
	}
	
	public void renderCursor(){
		
		_batch.begin();		
        
        if (Gdx.app.getType() != ApplicationType.Android) {
			_mousePos.x = Gdx.input.getX();
			_mousePos.y = Gdx.input.getY();
			cam.unproject(_mousePos);
			_batch.draw(AssetLoader._imgMouse, _mousePos.x, _mousePos.y);
		}
        
        _batch.end();
	}
	
	public abstract void render(float runTime, Rectangle _viewport);

	public int getMyGameHeight() {
		return myGameHeight;
	}	

	public int getMyGameWidth() {
		return myGameWidth;
	}	

	public OrthographicCamera getCam() {
		return cam;
	}	

	public SpriteBatch get_batch() {
		return _batch;
	}	

	public LanguagesManager get_lang() {
		return _lang;
	}	

	public GameWorld getMyworld() {
		return myworld;
	}	

}
