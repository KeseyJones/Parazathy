package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.State;


public abstract class GameRenderer {
	
	private OrthographicCamera cam;
	protected SpriteBatch _batch = null;
	private Vector3 _mousePos = null;	
	protected LanguagesManager _lang;
	protected int myGameHeight;
	protected int myGameWidth;
	
	public GameRenderer(int gameHeight, int gameWidth){		
		myGameHeight = gameHeight;
		myGameWidth = gameWidth;
		
		//Obtenemos el singleton de language
		_lang = LanguagesManager.getInstance();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);
		
		Gdx.input.setCursorCatched(true);
		
		_batch = new SpriteBatch();
		
		
	}
	
	public void renderCommon() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start rendering
        _batch.begin();
        
        _batch.setProjectionMatrix(cam.combined);
        
        if (Gdx.app.getType() != ApplicationType.Android) {
			_mousePos.x = Gdx.input.getX();
			_mousePos.y = Gdx.input.getY();
			cam.unproject(_mousePos);
			_batch.draw(AssetLoader._imgMouse, _mousePos.x, _mousePos.y);
		}
        
        _batch.end();
	}
	
	public abstract void render(float runTime);

}
