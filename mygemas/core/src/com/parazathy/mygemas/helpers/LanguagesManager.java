package com.parazathy.mygemas.helpers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class LanguagesManager {
	
	private Logger _logger = null;
	
	private static LanguagesManager _instance = null;
	
	private static final String LANGUAGES_FILE = "data/languages.xml";
	private static final String DEFAULT_LANGUAGE = "en_UK";
	
	private Map<String, Map<String, String>> _languages = null;
	private Map<String, String> _currentLanguage = null;
	private String _currentLanguageName = null;
	
	private LanguagesManager() {

		_logger = new Logger("MyGemas");
		
		_languages = new HashMap<String, Map<String, String>>();		
		_currentLanguage = new HashMap<String, String>();		
		_currentLanguageName = DEFAULT_LANGUAGE;
		
		loadLanguage();		
				
		_currentLanguage = _languages.get(_currentLanguageName);
			
	}
		
	public static LanguagesManager getInstance() {
		
		if (_instance == null) {
			_instance = new LanguagesManager();
		}
		
		return _instance;
	}
	
	public void setLanguage(String languageName){
				
		if (languageName != null || _languages.containsKey(languageName)) {
			_currentLanguageName = languageName;
			_currentLanguage = _languages.get(_currentLanguageName);
		}			
	}
	
	public String getCurrentLanguage() {
		
		return _currentLanguageName;
	}

	public String getString(String key) {
		
		String string;
		
		if (_currentLanguage != null) {			
			string = _currentLanguage.get(key);
			
			if (string != null) {
				return string;
			}
		}
			
		return key;
	}
		
	private boolean loadLanguage() {
		
		try {
			_languages.clear();
			
			XmlReader reader = new XmlReader();
			Element root = reader.parse(Gdx.files.internal(LANGUAGES_FILE).read());
			
			Array<Element> languages = root.getChildrenByName("language");
			
			for (int i = 0; i < languages.size; ++i) {
				Element language = languages.get(i);
				Map<String, String> _language = new HashMap<String, String>();		
								
				Array<Element> strings = language.getChildrenByName("string");
				
				for (int j = 0; j < strings.size; ++j) {
					Element string = strings.get(j);
					String key = string.getAttribute("key");
					String value = string.getAttribute("value");
					value = value.replace("&lt;br /&gt;&lt;br /&gt;", "\n");
					_language.put(key, value);
				}
				
				_languages.put(language.getAttribute("name"),_language);
									
			}
						
		}
		catch (Exception e) {
			_logger.error("Error loading languages file " + LANGUAGES_FILE);
			return false;
		}
		
		return true;
	}
}
