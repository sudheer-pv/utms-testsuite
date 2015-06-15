package com.utms.util;

import java.awt.geom.IllegalPathStateException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropWithinClasspath {

	private  Properties prop = null;

	public  Properties getProperties(String path) {

		this.prop = new Properties();
		InputStream is = PropWithinClasspath.class.getResourceAsStream("/"
				+ path);
		try {
			this.prop.load(is);
		} catch (IOException e) {
			throw new IllegalPathStateException(
					"Unable to load the properties file");
		}

		return this.prop;

	}

}
