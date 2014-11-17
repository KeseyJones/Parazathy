package com.parazathy.myzombiebird;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;

public class IOSLauncher extends IOSApplication.Delegate implements AdsRequestHandler{
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.orientationLandscape = true;
		config.orientationPortrait = false;
		MyZombieBird.setHandler(this);        
        return new IOSApplication(MyZombieBird.getInstance(), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }

	@Override
	public void showAds(boolean show) {
		// TODO Auto-generated method stub
		
	}
}