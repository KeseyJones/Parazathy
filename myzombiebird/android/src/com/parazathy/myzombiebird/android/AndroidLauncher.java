package com.parazathy.myzombiebird.android;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.parazathy.myzombiebird.MyZombieBird;

public class AndroidLauncher extends AndroidApplication {
	
	private static final String AD_UNIT_ID = "ca-app-pub-9422675792706581/6239422955";
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create the layout
        RelativeLayout layout = new RelativeLayout(this);               
				
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();		
		View gameView  = initializeForView(new MyZombieBird(), config);
		
		AdView adView = new AdView(this); 
		adView.setAdSize(AdSize.BANNER);
	    adView.setAdUnitId(AD_UNIT_ID);
	    adView.loadAd(new AdRequest.Builder().build());
	    
	    layout.addView(gameView);
	    
	    RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	    adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	    adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	    
	    layout.addView(adView, adParams);
	    
	    setContentView(layout);
	}
}
