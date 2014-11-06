package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
			
			int currentOption = world.getOption();
			
			if (currentOption > 1 && Gdx.app.getType() == ApplicationType.WebGL) {
				currentOption = 0;
			}
			
			if (world.is_readyToChange() && currentOption == world.get_selectedOption()) {			
				if(world.get_options().get(world.get_selectedOption()).getSecond() == MyGemas.Screens.HowTo){
					world.getGame().changeScreen(new GameHowTo(world.getGame(), MyGemas.VIRTUAL_HEIGHT,  MyGemas.VIRTUAL_WIDTH));
				}
				
			}
			else {
				world.set_readyToChange(true);
				world.set_selectedOption(currentOption);
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
