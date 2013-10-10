package com.envight.admin;

import java.io.IOException;
import java.util.Properties;

import org.fluentlenium.core.FluentPage;
import static org.junit.Assert.assertEquals;

public class MapPage extends FluentPage {
	@Override
	public String getUrl() {
		
		try {
			return String.format("%s/envightadmin/location/map", getSeleniumTestServerUrl());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void isAt() {
		assertEquals(title(), "Route Overview");
	}

	private Properties configuration;

	private String getSeleniumTestServerHost() throws IOException {
		return getConfiguration().getProperty("selenium.test.server");
	}

	private int getSeleniumTestServerPort() throws IOException {
		return Integer.parseInt(getConfiguration().getProperty(
				"selenium.test.port"));
	}

	private String getSeleniumTestServerUrl() throws IOException {
		return "http://" + getSeleniumTestServerHost() + ":"
				+ getSeleniumTestServerPort();
	}

	protected Properties getConfiguration() throws IOException {
		if (this.configuration == null) {
			Properties tmp = new Properties();
			tmp.load(this.getClass().getClassLoader()
					.getResourceAsStream("selenium.properties"));
			this.configuration = tmp;
		}
		return this.configuration;
	}
}
