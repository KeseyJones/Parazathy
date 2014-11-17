package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.screens.GameMenu;

public class InputHandlerHowTo implements InputProcessor{
	
	private boolean readyToChange;
	
	public InputHandlerHowTo(){
		readyToChange = false;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK){			
			MyGemas.getInstance().changeScreen(new GameMenu());	
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
		this.readyToChange = true;
		
		AssetLoader.selectSFXHowTo.play();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// Left click		
		if (button == 0 && this.readyToChange) {			
			MyGemas.getInstance().changeScreen(new GameMenu());			
		}
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

	public void setReadyToChange(boolean readyToChange) {
		this.readyToChange = readyToChange;
	}

}
