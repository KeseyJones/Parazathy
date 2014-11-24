package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.parazathy.mygemas.helpers.AssetLoader;

public class MenuButton extends Actor {
	
	public static enum OPTION {
		UNKNOWN(-1), 
		GAME(0), 
		HOWTO(1), 
		REMOVE(2),
		EXIT(3);
		
		private int position;
		
		OPTION(int position){
			this.position = position;
		}
	
		public int getPosition(){
			return this.position;
		}
	
	};	
	
	
	private static final int MENU_START_HEIGHT = 350;
	private static final int MENU_GAP_HEIGHT = 70;
	
	private String text;
	private OPTION option;	
	private TextBounds bounds;
	private float widthWorld;
	private static OPTION selectedOption = OPTION.UNKNOWN;
	private static boolean readyToChange = false;
	
	public MenuButton(String text, float widthWorld, OPTION option){
		this.text = text;
		this.option = option;
		this.widthWorld = widthWorld;
		this.bounds = AssetLoader.fontMenu.getBounds(text);
		this.setBounds((widthWorld - this.bounds.width)/2, MENU_START_HEIGHT + option.getPosition() * MENU_GAP_HEIGHT, this.bounds.width, this.bounds.height+4);
		this.setTouchable(Touchable.enabled);
		
	}
    
    @Override
    public void draw(Batch batch, float alpha){    	
    	
    	AssetLoader.fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
    	AssetLoader.fontMenu.draw(batch, text, this.getX(), this.getY() + 4);
    	AssetLoader.fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    	AssetLoader.fontMenu.draw(batch, text, this.getX(), this.getY());    	
    	
    	if (readyToChange && option == selectedOption) {
			batch.draw(AssetLoader.imgHighlightMenu,
		    		   ( this.widthWorld - AssetLoader.imgHighlightMenu.getRegionWidth()) / 2,
		    		   MENU_START_HEIGHT - 8 + option.getPosition() * MENU_GAP_HEIGHT);
		    		   
		}		
		
    }

	public static OPTION getSelectedOption() {
		return selectedOption;
	}

	public static void setSelectedOption(OPTION selectedOption) {
		MenuButton.selectedOption = selectedOption;
	}

	public static boolean isReadyToChange() {
		return readyToChange;
	}

	public static void setReadyToChange(boolean readyToChange) {
		MenuButton.readyToChange = readyToChange;
	}        
    
}
