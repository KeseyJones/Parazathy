package com.parazathy.mygemas.gameobjects;

import com.parazathy.mygemas.helpers.AssetLoader;

public class Gems {
	
	private int[] posX;
	private int posY;
	
	private double animTime;
	private double animTotalTime;
	
	public Gems (int width) {
		for (int i = 0; i < 7; ++i) {			
			this.posX[i] = width / 2 - (76 * 7) / 2 + i * 76;
		}
		
		this.posY = 265;
		
		this.animTime = 0.0;
		this.animTotalTime = 0.5; 
	}
	
	public void initialize(){
		AssetLoader.assignGemsAnimationResources();
	}
	
	public void update(double delta){
		if(this.animTime < 7 * 5 + this.animTotalTime)
            this.animTime += delta;		
	}

	public int[] getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public double getAnimTime() {
		return animTime;
	}

	public double getAnimTotalTime() {
		return animTotalTime;
	}
	
	

}
