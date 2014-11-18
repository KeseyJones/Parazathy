package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.parazathy.mygemas.helpers.AssetLoader;

public class MenuButton extends Actor {
	
	private static final int MENU_START_HEIGHT = 390;
	private static final int MENU_GAP_HEIGHT = 100;
	
	private String text;
	private int position;
	private float widthWorld;
	private static int selectedOption = -1;
	private static boolean readyToChange = false;
	
	public MenuButton(String text, float widthWorld, int position){
		this.text = text;
		this.position = position;
		this.widthWorld = widthWorld;
		
	}
    
    @Override
    public void draw(Batch batch, float alpha){
    	TextBounds bounds = AssetLoader.fontMenu.getBounds(text);
    	
    	AssetLoader.fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
    	AssetLoader.fontMenu.draw(batch, text, (this.widthWorld - bounds.width) / 2, MENU_START_HEIGHT + position * MENU_GAP_HEIGHT + 4);
    	AssetLoader.fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    	AssetLoader.fontMenu.draw(batch, text, (this.widthWorld - bounds.width) / 2, MENU_START_HEIGHT + position * MENU_GAP_HEIGHT);
    	
    	if (readyToChange && position == selectedOption) {
			batch.draw(AssetLoader.imgHighlightMenu,
		    		   ( this.getStage().getWidth() - AssetLoader.imgHighlightMenu.getRegionWidth()) / 2,
		    		   MENU_START_HEIGHT + 5 + selectedOption * MENU_GAP_HEIGHT);
		    		   
		}		
		
    }

	public static int getSelectedOption() {
		return selectedOption;
	}

	public static void setSelectedOption(int selectedOption) {
		MenuButton.selectedOption = selectedOption;
	}

	public static boolean isReadyToChange() {
		return readyToChange;
	}

	public static void setReadyToChange(boolean readyToChange) {
		MenuButton.readyToChange = readyToChange;
	}        
    
}
