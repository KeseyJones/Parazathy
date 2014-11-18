package com.parazathy.mygemas.ui;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.parazathy.mygemas.helpers.AssetLoader;

public class Cursor extends Actor {
	
	private Camera cam;
	
	public Cursor(Camera cam){
		this.cam = cam;
	}
    
    @Override
    public void draw(Batch batch, float alpha){
    	if (Gdx.app.getType() != ApplicationType.Android) {
        	Vector3 mousePos = new Vector3();
			mousePos.x = Gdx.input.getX();
			mousePos.y = Gdx.input.getY();
			cam.unproject(mousePos);
			batch.draw(AssetLoader.imgMouse, mousePos.x, mousePos.y);
		}
    }
}
