package com.parazathy.mygemas.helpers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class LanguagesManager {
				
	private static final String LANGUAGES_FILE = "data/languages.xml";
	private static final String DEFAULT_LANGUAGE = "en_UK";
		
	private Logger logger;
	private Map<String, Map<String, String>> languages = null;
	private Map<String, String> currentLanguage = null;
	private String currentLanguageName = null;
	
	public LanguagesManager() {
				
		logger = new Logger("LanguagesManager");
		languages = new HashMap<String, Map<String, String>>();		
		currentLanguage = new HashMap<String, String>();		
		currentLanguageName = DEFAULT_LANGUAGE;
		
		loadLanguage();		
				
		currentLanguage = languages.get(currentLanguageName);
			
	}
			
	
	public void setLanguage(String languageName){
				
		if (languageName != null || languages.containsKey(languageName)) {
			currentLanguageName = languageName;
			currentLanguage = languages.get(currentLanguageName);
		}			
	}
	
	public String getCurrentLanguage() {
		
		return currentLanguageName;
	}

	public String getString(String key) {
		
		String string;
		
		if (currentLanguage != null) {			
			string = currentLanguage.get(key);
			
			if (string != null) {
				return string;
			}
		}
			
		return key;
	}
		
	private boolean loadLanguage() {
		
		try {
			languages.clear();
			
			XmlReader reader = new XmlReader();
			Element root = reader.parse(Gdx.files.internal(LANGUAGES_FILE).read());
			
			Array<Element> language = root.getChildrenByName("language");
			
			for (int i = 0; i < language.size; ++i) {
				Element languageElement = language.get(i);
				Map<String, String> languageMap = new HashMap<String, String>();		
								
				Array<Element> strings = languageElement.getChildrenByName("string");
				
				for (int j = 0; j < strings.size; ++j) {
					Element string = strings.get(j);
					String key = string.getAttribute("key");
					String value = string.getAttribute("value");
					value = value.replace("&lt;br /&gt;&lt;br /&gt;", "\n");
					languageMap.put(key, value);
				}
				
				languages.put(languageElement.getAttribute("name"),languageMap);
									
			}
						
		}
		catch (Exception e) {
			logger.error("Error loading languages file " + LANGUAGES_FILE);
			return false;
		}
		
		return true;
	}
}
