package com.parazathy.mygemas.gameobjects;

public class Gems {
	
	private int[] _posX;
	private int _posY;
	
	private double _animTime;
	private double _animTotalTime;
	
	public Gems (int width) {
		for (int i = 0; i < 7; ++i) {			
			_posX[i] = width / 2 - (76 * 7) / 2 + i * 76;
		}
		
		_posY = 265;
		
		_animTime = 0.0;
		_animTotalTime = 0.5; 
	}
	
	public void update(double delta){
		if(_animTime < 7 * 5 + _animTotalTime)
            _animTime += delta;
		
		for(int i = 0; i < 7; ++i) {
            double composedTime = _animTime - i * _animTotalTime / 7.0f;
            if (composedTime < 0) {
            	continue;
            }

            /*
            if (composedTime < _animTotalTime) {
                batch.draw(_imgGems[i], _posX[i], Animation.easeOutCubic((float)composedTime, 600.0f, (float)_posY - 600.0f, _animTotalTime));
            }else{
            	batch.draw(_imgGems[i], _posX[i], _posY);
            }
            */
        }
	}

}
