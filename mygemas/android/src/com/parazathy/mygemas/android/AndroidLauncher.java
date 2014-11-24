package com.parazathy.mygemas.android;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.helpers.AdsRequestHandler;

public class AndroidLauncher extends AndroidApplication implements AdsRequestHandler{
	
	private static final String AD_UNIT_ID_BANNER  = "ca-app-pub-9422675792706581/4949539359";
	private static final String AD_UNIT_ID_INTERSTITIAL   = "ca-app-pub-9422675792706581/4809938554";	
	private AdView adView;
	private View gameView;
	private InterstitialAd interstitialAd;	
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();	
		
		// Do the stuff that initialize() would do for you
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
				
	    RelativeLayout layout = new RelativeLayout(this);
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
	    layout.setLayoutParams(params);

	    AdView admobView = createAdView();
	    layout.addView(admobView);
	    View gameView = createGameView(config);
	    layout.addView(gameView);	    
						
		MyGemas.setHandler(this);	    
	    setContentView(layout);
	    
	    interstitialAd = new InterstitialAd(this);
	    interstitialAd.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);	
	    interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
            	interstitialAd.show();
            }
	    });
		
	}
	
	private AdView createAdView() {
	    adView = new AdView(this);
	    adView.setAdSize(AdSize.SMART_BANNER);
	    adView.setAdUnitId(AD_UNIT_ID_BANNER);	 	    
	    adView.setBackgroundColor(Color.BLACK);	 
	    adView.setId(R.id.adViewId);	
	    adView.setEnabled(false);		
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.BELOW);
	    adView.setLayoutParams(params);	    	   
	    return adView;	   
	  }
	
	private View createGameView(AndroidApplicationConfiguration cfg) {
	    gameView = initializeForView(MyGemas.getInstance(), cfg);	
	    
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.ABOVE, adView.getId());
	    gameView.setLayoutParams(params);
	    return gameView;
	 }
	
	@Override
	public void showAdsBanner(boolean show) {
		
		if (show) {
			showAd();
		} else {
			hideAd();
		}
		
	}
	
	private void showAd() {		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if(!adView.isEnabled()){
					adView.setEnabled(true);
					adView.setVisibility(View.VISIBLE);
					adView.loadAd(new AdRequest.Builder().build());
				}
			}
		});
	}
	 
	 
	private void hideAd() {		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if(adView.isEnabled()){
					adView.setEnabled(false);
					adView.setVisibility(View.GONE);
				}
			}
		});
	}	
			
	@Override
	public void showInterstital() {
	    try {
	      runOnUiThread(new Runnable() {
	        public void run() {	    
	        	interstitialAd.loadAd(new AdRequest.Builder().build());
	        }
	      });
	    } catch (Exception e) {
	    }
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (adView != null) adView.resume();
	}

	@Override
	public void onPause() {
		if (adView != null) adView.pause();
	    super.onPause();
	}

	@Override
	public void onDestroy() {
		if (adView != null) adView.destroy();
	    super.onDestroy();
	}
}
