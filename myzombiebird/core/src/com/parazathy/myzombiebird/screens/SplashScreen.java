package com.parazathy.myzombiebird.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;
import com.parazathy.myzombiebird.tweenaccessors.SpriteAccessor;

public class SplashScreen extends MyScreen {

    private TweenManager manager;   
    private Sprite sprite;    

    public SplashScreen() {    
    	super();
        //Quitamos la publicidad
    	MyZombieBird.getHandler().showAds(false);
    }

    @Override
    public void show() {
    	
        sprite = new Sprite(AssetLoader.logo);
        sprite.setColor(1, 1, 1, 0);
       
        float desiredWidth = this.getStage().getViewport().getScreenWidth() * .7f;
        float scale = desiredWidth / sprite.getWidth();

        sprite.setSize(sprite.getWidth() * scale, sprite.getHeight() * scale);
        sprite.setPosition((this.getStage().getViewport().getScreenWidth() / 2) - (sprite.getWidth() / 2), (this.getStage().getViewport().getScreenHeight() / 2)
                - (sprite.getHeight() / 2));
        setupTween();        
    }

    private void setupTween() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        manager = new TweenManager();

        TweenCallback cb = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
            	MyZombieBird.getInstance().setScreen(new GameScreen());
            }
        };

        Tween.to(sprite, SpriteAccessor.ALPHA, .8f).target(1)
                .ease(TweenEquations.easeInOutQuad).repeatYoyo(1, .4f)
                .setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
                .start(manager);
    }

    @Override
    public void render(float delta) {
        manager.update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        this.getStage().getBatch().begin();
        sprite.draw(this.getStage().getBatch());
        this.getStage().getBatch().end();
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
