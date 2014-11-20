package com.parazathy.myzombiebird.android;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;

public class AndroidLauncher extends AndroidApplication implements AdsRequestHandler  {
	
	private static final String AD_UNIT_ID = "ca-app-pub-9422675792706581/6239422955";	
	private AdView adView;
	private View gameView;
		
	
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
						
	    
	    setContentView(layout);
						
	}
	
	private AdView createAdView() {
	    adView = new AdView(this);
	    adView.setAdSize(AdSize.SMART_BANNER);
	    adView.setAdUnitId(AD_UNIT_ID);
	    adView.setId(R.id.adViewId); // this is an arbitrary id, allows for relative positioning in createGameView()
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
	    adView.setLayoutParams(params);
	    adView.setBackgroundColor(Color.BLACK);	    
	    return adView;
	  }
	
	private View createGameView(AndroidApplicationConfiguration cfg) {
		MyZombieBird.setHandler(this);	    
	    gameView = initializeForView(MyZombieBird.getInstance(), cfg);
	    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
	    params.addRule(RelativeLayout.BELOW, adView.getId());
	    gameView.setLayoutParams(params);
	    return gameView;
	}

	
	@Override
	public void showAds(boolean show) {
		
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
				adView.setEnabled(true);
				adView.setVisibility(View.VISIBLE);
				adView.loadAd(new AdRequest.Builder().build());
			}
		});
	}
	 
	 
	private void hideAd() {		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adView.setEnabled(false);
				adView.setVisibility(View.GONE);
			}
		});
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
