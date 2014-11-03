package com.parazathy.mygemas.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.parazathy.mygemas.helpers.PlatformResolver;

public class DesktopResolver implements PlatformResolver {

	@Override
	public String getDefaultLanguage() {
		return java.util.Locale.getDefault().toString();
	}
	
	public String format(String string, Object... args) {
		return String.format(string, args);
	}
	
	@Override
	public BitmapFont loadFont(String fntFile, String ttfFile, int size) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(ttfFile));
		FreeTypeFontParameter param = new FreeTypeFontParameter();
		param.size = size;
		param.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
		param.flip = true;
		BitmapFont font = generator.generateFont(param);
		generator.dispose();
		return font;
	}
}
