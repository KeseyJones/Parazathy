package com.parazathy.mygemas.gameworld;

import com.siondream.freegemas.StateMenu.State;

public class GameWorldMenu extends GameWorld{
	
	@Override
	public void update(float delta) {
		if (_state == State.Loading) {
			if (_parent.getAssetManager().update()) {
				assignResources();
				_state = State.TransitionIn;
			}
			
			return;
		}
		else if (_state  == State.TransitionIn) {
	        if ((_animTime += deltaT) >= _animTotalTime) {
	        	_state = State.Active;
	        	_animTime = _animLogoTime;
	        }
	    }
	    else if (_state == State.Active) {
	    	
	    }
	    else if (_state == State.TransitionOut) {

	    }
	}

}
