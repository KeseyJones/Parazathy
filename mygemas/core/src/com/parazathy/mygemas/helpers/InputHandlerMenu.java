package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.parazathy.mygemas.gameworld.GameWorldMenu;

public class InputHandlerMenu implements InputProcessor {
	
	private GameWorldMenu myWorld;
	
	public InputHandlerMenu (GameWorldMenu world){
		this.myWorld = world;
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK){
			//SAlimos de la aplicacion
			Gdx.app.exit();
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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// Left click		
		if (button == 0) {
			
			AssetLoader._selectSFXMenu.play();
			
			int currentOption = myWorld.getOption();
			
			if (currentOption > 1 && Gdx.app.getType() == ApplicationType.WebGL) {
				currentOption = 0;
			}
			
			if (myWorld.is_readyToChange() && currentOption == myWorld.get_selectedOption()) {
				_parent.changeState(_options.get(_selectedOption).getSecond());
			}
			else {
				myWorld.set_readyToChange(true);
				myWorld.set_selectedOption(currentOption);
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
