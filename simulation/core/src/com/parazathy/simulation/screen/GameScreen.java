package com.parazathy.simulation.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.parazathy.simulation.stages.GameStage;
import com.parazathy.simulation.utils.Constants;

public class GameScreen implements Screen{
	
	private GameStage stage;
		
	
	public GameScreen (){
		stage = new GameStage();
	}
		

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.graphics.setTitle(Constants.TITLE+" -- FPS: " + Gdx.graphics.getFramesPerSecond());
		
		//Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		
		//Update the stage
        stage.draw();
        stage.act(delta);
		
		
	}

	@Override
	public void resize(int width, int height) {
		//TODO
		
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
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		//TODO
		
	}

}
