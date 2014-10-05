package com.parazathy.mygemashelpers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class LanguagesManager {
	private static LanguagesManager _instance = null;
	
	private static final String LANGUAGES_FILE = "data/languages.xml";
	private static final String DEFAULT_LANGUAGE = "en_UK";
	
	//private HashMap<String, HashMap<String, String>> _strings = null;
	private HashMap<String, String> _language = null;
	private String _languageName = null;
	
	private LanguagesManager(String languageName) {

		_language = new HashMap<String, String>();		
		_languageName = languageName;
		
		if (languageName == null) {
			_languageName = DEFAULT_LANGUAGE;
		}
		
		loadLanguage(_languageName);
			
	}
	
	public static LanguagesManager getInstance(String languageName) {
		if (_instance == null) {
			_instance = new LanguagesManager(languageName);
		}
		
		return _instance;
	}
	
	public String getLanguage() {
		return _languageName;
	}

	public String getString(String key) {
		String string;
		
		if (_language != null) {			
			string = _language.get(key);
			
			if (string != null) {
				return string;
			}
		}
			
		return key;
	}
		
	public boolean loadLanguage(String languageName) {
		try {
			XmlReader reader = new XmlReader();
			Element root = reader.parse(Gdx.files.internal(LANGUAGES_FILE).read());
			
			Array<Element> languages = root.getChildrenByName("language");
			
			for (int i = 0; i < languages.size; ++i) {
				Element language = languages.get(i);
				
				if (language.getAttribute("name").equals(languageName)) {
					_language.clear();
					Array<Element> strings = language.getChildrenByName("string");
					
					for (int j = 0; j < strings.size; ++j) {
						Element string = strings.get(j);
						String key = string.getAttribute("key");
						String value = string.getAttribute("value");
						value = value.replace("&lt;br /&gt;&lt;br /&gt;", "\n");
						_language.put(key, value);
					}
					
					return true;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error loading languages file " + LANGUAGES_FILE);
			return false;
		}
		
		return false;
	}
}
