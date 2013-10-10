package com.envight.admin;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.test.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class MapTest extends FluentTest {
	
	@Page
	MapPage mapPage;
	
	@Override
	public WebDriver getDefaultDriver() {
	    return new HtmlUnitDriver();
	}
	
	@Test
	public void testMapPageAccess() {
		goTo(mapPage);
		mapPage.isAt();
	}
	
}
