package com.parazathy.myzombiebird;

import com.badlogic.gdx.Game;
import com.parazathy.myzbhelpers.AssetLoader;
import com.parazathy.screens.GameScreen;

public class MyZombieBird extends Game {

    @Override
    public void create() {
        System.out.println("ZBGame Created!");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

}