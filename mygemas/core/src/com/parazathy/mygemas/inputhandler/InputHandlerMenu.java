package com.parazathy.mygemas.inputhandler;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.screens.GameMenu;

public class InputHandlerMenu implements InputProcessor {
		
	public InputHandlerMenu (){
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK){
			//SAlimos de la aplicacion
			MyGemas.exit();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// Left click		
		if (button == 0) {			
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

}
