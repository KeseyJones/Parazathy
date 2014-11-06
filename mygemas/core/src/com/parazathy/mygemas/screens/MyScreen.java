package com.parazathy.mygemas.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;

public abstract class MyScreen implements Screen{
	
	private static final float ASPECT_RATIO = 1.7777f;
	
	private Logger logger;
	private int height;
	private int width;
	private Rectangle viewport;		
	private float runTime;	
	
	public MyScreen(int height, int width){
		logger = new Logger("MyScreen");
		this.height = height;
		this.width = width;				
	}

	@Override
	public void resize(int width, int height) {
		logger.info("Resizing to: " + width + "x" + height);
		
		// calculate new viewport
        float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        
        if(aspectRatio > ASPECT_RATIO)
        {
            scale = (float)height / (float)this.height;
            crop.x = (width - this.width * scale) / 2.0f;
        }
        else if(aspectRatio < ASPECT_RATIO)
        {
            scale = (float)width / (float)this.width;
            crop.y = (height - this.height * scale) / 2.0f;
        }
        else
        {
            scale = (float)width/(float)this.width;
        }

        float w = (float)this.width * scale;
        float h = (float)this.height * scale;
        viewport = new Rectangle(crop.x, crop.y, w, h);
	}

	public Rectangle getViewport() {
		return viewport;
	}

	public float getRunTime() {
		return runTime;
	}

	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}	
		
	
}
