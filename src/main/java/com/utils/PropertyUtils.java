package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.exceptions.PropertyFileUsageException;

public final class PropertyUtils {

	private PropertyUtils() {
	}

	private static Properties property= new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();

	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			property.load(file);
			for(Object key : property.keySet()) {
				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)).trim());
			}

		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}


	public static String get(ConfigProperties key)  {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name" + key +"is not found. please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	/*
	public static String getValue(String key) throws Exception {
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("Property name" + key +"is not found. please check config.properties");
		}
		return property.getProperty(key);
	}
	 */

}
