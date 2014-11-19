package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.parazathy.mygemas.helpers.AssetLoader;

public class MenuButton extends Actor {
	
	private static final int MENU_START_HEIGHT = 390;
	private static final int MENU_GAP_HEIGHT = 100;
	
	private String text;
	private int position;	
	private TextBounds bounds;
	private float widthWorld;
	private static int selectedOption = -1;
	private static boolean readyToChange = false;
	
	public MenuButton(String text, float widthWorld, int position){
		this.text = text;
		this.position = position;
		this.widthWorld = widthWorld;
		this.bounds = AssetLoader.fontMenu.getBounds(text);
		this.setBounds((widthWorld - this.bounds.width)/2, MENU_START_HEIGHT + position * MENU_GAP_HEIGHT, this.bounds.width, this.bounds.height+4);
		this.setTouchable(Touchable.enabled);
		
	}
    
    @Override
    public void draw(Batch batch, float alpha){    	
    	
    	AssetLoader.fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
    	AssetLoader.fontMenu.draw(batch, text, this.getX(), this.getY() + 4);
    	AssetLoader.fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    	AssetLoader.fontMenu.draw(batch, text, this.getX(), this.getY());
    	
    	if (readyToChange && position == selectedOption) {
			batch.draw(AssetLoader.imgHighlightMenu,
		    		   ( this.widthWorld - AssetLoader.imgHighlightMenu.getRegionWidth()) / 2,
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
