package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.parazathy.mygemas.helpers.AssetLoader;

public class GameButton extends Actor {
	
	public static enum OPTION {		
		HINT, 
		RESET, 
		EXIT,
		MUSIC;		
	
	};	
	
	private String text;	
	private Vector2 pos;	
	private boolean clicked;	
	private TextureRegion icon;
	
	
	public GameButton(int x, int y, String text,  OPTION option) {		
		this.text = text;		
		this.clicked = false;		
		this.pos = new Vector2(x, y);
		this.setBounds(x, y, AssetLoader.buttonBackgroundGame.getRegionWidth(), AssetLoader.buttonBackgroundGame.getRegionHeight());
		this.setTouchable(Touchable.enabled);
		if(option == OPTION.EXIT){
			icon = AssetLoader.iconExitGame;
		}
		else if(option == OPTION.MUSIC){
			icon = AssetLoader.iconMusicGame;
		}
		else if(option == OPTION.RESET){
			icon = AssetLoader.iconRestartGame;
		}
		else if(option == OPTION.HINT){
			icon = AssetLoader.iconHintGame;
		}
	}
	
	@Override
	public void draw(Batch batch, float alpha) {		
		
		if (!isClicked())
		{
			batch.draw(AssetLoader.buttonBackgroundGame, this.pos.x, this.pos.y);
		}
		else 
		{
			batch.draw(AssetLoader.buttonBackgroundClickedGame, this.pos.x, this.pos.y);
		}
		
		
		batch.draw(icon, this.pos.x + 15, this.pos.y + (AssetLoader.buttonBackgroundGame.getRegionHeight() - icon.getRegionHeight()) / 2);				
		AssetLoader.fontTextGame.draw(batch, this.text, this.pos.x + 60, this.pos.y + 25);
		
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setText(String text) {
		this.text = text;
	}
		
	
}