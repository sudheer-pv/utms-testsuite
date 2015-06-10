package com.utms.util;

import java.awt.geom.IllegalPathStateException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropWithinClasspath {

	private static Properties prop = null;

	public static Properties getProperties(String path) {

		InputStream is = null;

		if (prop == null) {
			prop = new Properties();
			is = PropWithinClasspath.class.getResourceAsStream("/" + path);
			try {
				prop.load(is);
			} catch (IOException e) {
				throw new IllegalPathStateException(
						"Unable to load the properties file");
			}
		}
		return prop;

	}

}
