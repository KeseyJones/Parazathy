package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.AssetLoader;

public class BackGroundMenu extends Actor {
	
	private GameWorldMenu world;
	
	public BackGroundMenu(GameWorldMenu world){
		this.world = world;
	}
	
	@Override
    public void draw(Batch batch, float alpha){
		batch.draw(AssetLoader.imgBackgroundMenu, 0, 0);		    
		batch.setColor(1.0f, 1.0f, 1.0f, (float)(world.getAnimTime() / world.getAnimLogoTime()));
		batch.draw(AssetLoader.imgLogoMenu, 0, 0);
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);	   
    }

}
