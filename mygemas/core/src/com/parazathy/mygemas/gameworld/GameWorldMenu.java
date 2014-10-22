package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
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
	
	private boolean _readyToChange;
	
	// Positions
	private Vector2 _menuStart;
	private Vector2 _menuEnd;
	private int _menuGap;	
		
	
	// Options
	private int _selectedOption;
	private Array<Pair<String, String>> _options;
			
	
	public GameWorldMenu(){
		super();
		_state = StateMenu.Loading;
		
		// Menu options
		_selectedOption = 0;
		_options = new Array<Pair<String, String>>();
		_options.add(new Pair(this.get_lang().getString("Timetrial mode"), "StateGame"));
		_options.add(new Pair(this.get_lang().getString("How to play"), "StateHowto"));
		
		// Animation times
		_animTime = 0.0;
		_animTotalTime = 0.5;
		_animLogoTime = 0.5;
		
		this._readyToChange = false;
		
		
				
	}
	
	private void initialize(){
		// Set positions now that we now about sizes		
		float maxWidth = 0;
		int numOptions = _options.size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(_options.get(i).getFirst());
			
			if (bounds.width > maxWidth) {
				maxWidth = bounds.width;
			}
		}
		
		_menuStart = new Vector2((this.getRenderer().getMyGameWidth() - maxWidth) / 2, 390);
		_menuGap = 100;
		_menuEnd = new Vector2(_menuStart.x + maxWidth, 350 + _options.size * _menuGap);
	}
		
	
	@Override
	public void update(float delta) {		
		if (_state == StateMenu.Loading) {
			if (AssetLoader._assetManager.update()) {
				AssetLoader.AssignMenuResources();
				initialize();
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
	
	public int getOption() {
		Vector3 _mousePos= new Vector3();
		// Mouse position and selected option
	    _mousePos.x = Gdx.input.getX();
	    _mousePos.y = Gdx.input.getY();
	    this.getRenderer().getCam().unproject(_mousePos);

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
	
	public void set_readyToChange(boolean _readyToChange) {
		this._readyToChange = _readyToChange;
	}

	public boolean is_readyToChange() {
		return _readyToChange;
	}


	public int get_selectedOption() {
		return _selectedOption;
	}


	public void set_selectedOption(int _selectedOption) {
		this._selectedOption = _selectedOption;
	}

	public Vector2 get_menuStart() {
		return _menuStart;
	}

	public int get_menuGap() {
		return _menuGap;
	}
	
	
}
