package com.parazathy.myzombiebird.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;

public class AndroidLauncher extends AndroidApplication implements AdsRequestHandler  {
	
	private static final String AD_UNIT_ID = "ca-app-pub-9422675792706581/6239422955";
	private final int SHOW_ADS = 1;
	private final int HIDE_ADS = 0;
	private AdView adView;
	
	protected Handler handler = new Handler()
	{
	    @Override
	    public void handleMessage(Message msg) {
	        switch(msg.what) {
	            case SHOW_ADS:
	            {
	                adView.setVisibility(View.VISIBLE); //change to visible
	                break;
	            }
	            case HIDE_ADS:
	            {
	                adView.setVisibility(View.GONE);//change to not visible
	                // you should also disable the ad fetching here!
	                break;
	            }
	        }
	    }
	};
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create the layout
	    RelativeLayout layout = new RelativeLayout(this);

	    // Do the stuff that initialize() would do for you
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
				
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();		
		View gameView  = initializeForView(new MyZombieBird(this), config);
		
		adView = new AdView(this); 
		adView.setAdSize(AdSize.SMART_BANNER);
	    adView.setAdUnitId(AD_UNIT_ID);
	    adView.loadAd(new AdRequest.Builder().build());
	    
	    // Add the AdMob view
	    RelativeLayout.LayoutParams adParams = 
	        new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
	                RelativeLayout.LayoutParams.WRAP_CONTENT);
	    adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	    adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	    
	    adView.setId(R.id.adViewId); 
	     
	    layout.addView(adView, adParams);
	    
	    RelativeLayout.LayoutParams gameParams = 
	            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
	                    RelativeLayout.LayoutParams.WRAP_CONTENT);
	        gameParams.addRule(RelativeLayout.BELOW, adView.getId());
	        
	    layout.addView(gameView, gameParams);	   
	    
	    setContentView(layout);
	}

	@Override
	public void showAds(boolean show) {
		handler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
		
	}
}
