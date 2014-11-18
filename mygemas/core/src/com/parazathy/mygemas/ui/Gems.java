package com.parazathy.mygemas.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.parazathy.mygemas.helpers.Animation;
import com.parazathy.mygemas.helpers.AssetLoader;

public class Gems extends Actor{
	
	private int[] posX;
	private int posY;
	
	private double animTime;
	private double animTotalTime;
	
	public Gems (int screenWidth) {
		posX = new int[7];
		
		for (int i = 0; i < 7; ++i) {			
			this.posX[i] = screenWidth / 2 - (76 * 7) / 2 + i * 76;
		}
		
		this.posY = 265;
		
		this.animTime = 0.0;
		this.animTotalTime = 0.5; 
	}
	
	public void initialize(){
		
		AssetLoader.assignGemsAnimationResources();
	}
	
	@Override
    public void draw(Batch batch, float alpha){
     	for(int i = 0; i < 7; ++i) {
 			
             double composedTime = animTime - i *animTotalTime / 7.0f;
             if (composedTime < 0) {
             	continue;
             }
             
             if (composedTime < animTotalTime) {
                 batch.draw(AssetLoader.imgGemsAnimation[i], posX[i], Animation.easeOutCubic((float)composedTime, 600.0f, (float)posY - 600.0f, animTotalTime));
             }else{
             	batch.draw(AssetLoader.imgGemsAnimation[i], posX[i], posY);
             }
                         
         }
     }
		
	
	
	public void update(double delta){
		if(this.animTime < 7 * 5 + this.animTotalTime)
            this.animTime += delta;		
	}	

}
