package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.gameobjects.Pair;
import com.parazathy.mygemas.helpers.AssetLoader;


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
		
	
	// Options
	private int _selectedOption;
	private Array<Pair<String, String>> _options;
	
	
	public GameWorldMenu(){
		super();
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
	
	private int getOption() {
		Vector3 _mousePos= new Vector3();
		// Mouse position and selected option
	    _mousePos.x = Gdx.input.getX();
	    _mousePos.y = Gdx.input.getY();
	    _parent.getCamera().unproject(_mousePos);

	    if (_mousePos.y >= _menuStart.y - 100 && _mousePos.y < _menuEnd.y + 100) {
	       return (int)(_mousePos.y - _menuStart.y) / _menuGap;
	    }
	    
	    return _selectedOption;
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
	

	public void set_state(StateMenu _state) {
		this._state = _state;
	}


	public Array<Pair<String, String>> get_options() {
		return _options;
	}
		
	
}
