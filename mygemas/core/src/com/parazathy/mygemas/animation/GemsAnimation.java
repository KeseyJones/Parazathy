package com.parazathy.mygemas.animation;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.siondream.freegemas.Animation;
import com.siondream.freegemas.Freegemas;

public class GemsAnimation {
		
	private TextureRegion[] _imgGems;	
	
	public GemsAnimation() {
		
		AssetLoader.assignGemsAnimationResources();
	}
	
	public void update(double delta) {		

		SpriteBatch batch = _game.getSpriteBatch();
		
        for(int i = 0; i < 7; ++i) {
            double composedTime = _animTime - i * _animTotalTime / 7.0f;
            if (composedTime < 0) {
            	continue;
            }

            if (composedTime < _animTotalTime) {
                batch.draw(_imgGems[i], _posX[i], Animation.easeOutCubic((float)composedTime, 600.0f, (float)_posY - 600.0f, _animTotalTime));
            }else{
            	batch.draw(_imgGems[i], _posX[i], _posY);
            }
        }
	}
}