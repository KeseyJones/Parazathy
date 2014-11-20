package com.parazathy.myzombiebird.screens;

import com.badlogic.gdx.Gdx;
import com.parazathy.myzombiebird.gameworld.GameRenderer;
import com.parazathy.myzombiebird.gameworld.GameWorld;
import com.parazathy.myzombiebird.myzbhelpers.InputHandler;

public class GameScreen extends MyScreen {

	private GameWorld world;
	private GameRenderer renderer;	
	private InputHandler inputHandler;

	// This is the constructor, not the class declaration
	public GameScreen() {
		super(true);		
		
		int midPointY = (int) (this.getStage().getHeight() / 2);		
		
		world = new GameWorld(midPointY);
		inputHandler = new InputHandler(world, this.getStage().getViewport().getScreenWidth() / this.getStage().getWidth(), this.getStage().getViewport().getScreenHeight() / this.getStage().getHeight());
		Gdx.input.setInputProcessor(inputHandler);
		renderer = new GameRenderer(world, this.getStage());		
		world.setRenderer(renderer);

	}
	
	@Override
	public void resize(int width, int height) {	
						
        //ACtualizamos el stage
        super.resize(width, height);  
        inputHandler.setScaleFactorX(this.getStage().getViewport().getScreenWidth() / this.getStage().getWidth());
        inputHandler.setScaleFactorY(this.getStage().getViewport().getScreenHeight() / this.getStage().getHeight());
           		
          
	}

	@Override
	public void render(float delta) {
		this.setRunTime(this.getRunTime()+delta);
		world.update(delta);
		renderer.render(delta, this.getRunTime());
	}	

	@Override
	public void show() {		
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {		
	}

}
