package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.gameobjects.Pair;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.siondream.freegemas.GemsAnimation;


public class GameWorldMenu extends GameWorld{
	
	//Estados del menu
	public static enum StateMenu { Loading,
							TransitionIn,
							Active,
							TransitionOut } ;
	
	private StateMenu _state;
	
	// Animation time
	private double _animTime;
	private double _animLogoTime;
	private double _animTotalTime;
	
	private GemsAnimation _gems;
	
	// Options
	private int _selectedOption;
	private Array<Pair<String, String>> _options;
	
	public GameWorldMenu(){
		
		_state = StateMenu.Loading;
		
		// Menu options
		_selectedOption = 0;
		_options = new Array<Pair<String, String>>();
		_options.add(new Pair(_lang.getString("Timetrial mode"), "StateGame"));
		_options.add(new Pair(_lang.getString("How to play"), "StateHowto"));
		
		// Animation times
		_animTime = 0.0;
		_animTotalTime = 0.5;
		_animLogoTime = 0.5;
	}
		
	
	@Override
	public void update(float delta) {		
		if (_state == StateMenu.Loading) {
			if (AssetLoader._assetManager.update()) {
				AssetLoader.AssignMenuResources();
				_state = StateMenu.TransitionIn;
			}					
		}
		else if (_state  == StateMenu.TransitionIn) {
	        if ((_animTime += delta) >= _animTotalTime) {
	        	_state = StateMenu.Active;
	        	_animTime = _animLogoTime;
	        }
	    }
	    else if (_state == StateMenu.Active) {
	    	
	    }
	    else if (_state == StateMenu.TransitionOut) {

	    }
				
	}
	
	public double get_animTime() {
		return _animTime;
	}


	public double get_animLogoTime() {
		return _animLogoTime;
	}


	public double get_animTotalTime() {
		return _animTotalTime;
	}


	public StateMenu get_state() {
		return _state;
	}


	public Array<Pair<String, String>> get_options() {
		return _options;
	}
	
}
