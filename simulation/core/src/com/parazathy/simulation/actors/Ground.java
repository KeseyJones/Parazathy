package com.parazathy.simulation.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.parazathy.simulation.bos2d.GroundUserData;

public class Ground extends GameActor {

    public Ground(Body body) {
        super(body);
    }
    
    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }

}
