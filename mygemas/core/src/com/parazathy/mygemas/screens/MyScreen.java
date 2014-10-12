package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;

public abstract class MyScreen implements Screen{
	
	private static final float ASPECT_RATIO = 1.7777f;
	private Logger _logger;
	private int myHeight;
	private int myWidth;
	protected Rectangle _viewport;
	
	public MyScreen(int height, int width){
		_logger = new Logger("MyScreen");
		myHeight = height;
		myWidth = width;
	}

	@Override
	public void resize(int width, int height) {
		_logger.info("Resizing to: " + width + "x" + height);
		
		// calculate new viewport
        float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        
        if(aspectRatio > ASPECT_RATIO)
        {
            scale = (float)height / (float)this.myHeight;
            crop.x = (width - this.myWidth * scale) / 2.0f;
        }
        else if(aspectRatio < ASPECT_RATIO)
        {
            scale = (float)width / (float)this.myWidth;
            crop.y = (height - this.myHeight * scale) / 2.0f;
        }
        else
        {
            scale = (float)width/(float)this.myWidth;
        }

        float w = (float)this.myWidth * scale;
        float h = (float)this.myHeight * scale;
        _viewport = new Rectangle(crop.x, crop.y, w, h);
	}

	public Rectangle get_viewport() {
		return _viewport;
	}
	
	

}
