package com.parazathy.myzombiebird;

import com.badlogic.gdx.Game;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;
import com.parazathy.myzombiebird.screens.SplashScreen;

public class MyZombieBird extends Game {

    @Override
    public void create() {
        System.out.println("ZBGame Created!");
        AssetLoader.load();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

}