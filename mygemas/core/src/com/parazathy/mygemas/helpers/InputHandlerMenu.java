package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.InputProcessor;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.screens.GameHowTo;

public class InputHandlerMenu implements InputProcessor {
	
	private GameWorldMenu world;
	
	public InputHandlerMenu (GameWorldMenu world){
		this.world = world;
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK){
			//SAlimos de la aplicacion
			world.getScreen().getGame().exit();
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private int getOption() {
		/*
		Vector3 _mousePos= new Vector3();
		// Mouse position and selected option
	    _mousePos.x = Gdx.input.getX();
	    _mousePos.y = Gdx.input.getY();
	    this.getRenderer().getCam().unproject(_mousePos);

	    if (_mousePos.y >= world.getMenuStart().y - 100 && _mousePos.y < world.getMenuEnd().y + 100) {
	       return (int)(_mousePos.y - world.getMenuStart().y) / world.getMenuGap();
	    }
	    
	    return world.getSelectedOption();
	    */
		return 0;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// Left click		
		if (button == 0) {
			
			AssetLoader.selectSFXMenu.play();
			
			int currentOption = getOption();
			
			if (currentOption > 1 && Gdx.app.getType() == ApplicationType.WebGL) {
				currentOption = 0;
			}
			
			if (world.isReadyToChange() && currentOption == world.getSelectedOption()) {			
				if(world.getOptions().get(world.getSelectedOption()).getSecond() == MyGemas.Screens.HowTo){
					world.getScreen().getGame().changeScreen(new GameHowTo(world.getScreen().getGame()));
				}else if(world.getOptions().get(world.getSelectedOption()).getSecond() == MyGemas.Screens.Exit){
					world.getScreen().getGame().exit();
				}
				
			}
			else {
				world.setReadyToChange(true);
				world.setSelectedOption(currentOption);
			}
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
