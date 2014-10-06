package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Gdx;
import com.parazathy.mygemas.gameworld.GameRendererMenu;
import com.parazathy.mygemas.gameworld.GameWorldMenu;
import com.parazathy.mygemas.helpers.InputHandlerMenu;

public class GameMenu extends MyScreen {
		
	public GameMenu() {
		
		world = new GameWorldMenu();
		renderer = new GameRendererMenu(world, VIRTUAL_HEIGHT, VIRTUAL_WIDTH);

		Gdx.input.setInputProcessor(new InputHandlerMenu());

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
