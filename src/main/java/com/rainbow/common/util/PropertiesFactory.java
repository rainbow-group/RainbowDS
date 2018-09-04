package com.rainbow.common.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Constants;

/**
 * @author Ray
 *
 */
public class PropertiesFactory {
	final static Logger logger = LogManager.getLogger(PropertiesFactory.class);

	private Properties getProperties(String propertyFileName) {

		Properties prop = new Properties();

		try {
			prop.load(getClass().getClassLoader().getResourceAsStream(propertyFileName));
		} catch (IOException e) {
			logger.error("Read properties file : " + Constants.CONFIG_PROPERTIES + " error.", e);
		}

		return prop;
	}

	public static String getConfig(String key) {
		PropertiesFactory pf = new PropertiesFactory();
		Properties prop = pf.getProperties(Constants.CONFIG_PROPERTIES);

		return prop.getProperty(key);
	}
}
