package com.sic.utilities;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.sic.accelerators.ActionEngine_Dialog;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.GeneralLeanFtException;
//import com.hp.lft.sdk.web.*;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;

public class BrowserFactoryTest extends ActionEngine_Dialog {

	static Browser browser;

	public static Browser fnOpenBrowser(Browser browser) throws IOException, GeneralLeanFtException, Throwable {

		if (utility.fnReadPropFile("browserName").toUpperCase().equals("IE")) {
			
			ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI("ws://localhost:5095"));
			SDK.init(config);
			
			browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
			handleDialogue(browser);
			// browser.fullScreen();
			System.out.println("IE is opening");
			utility.fnLogging("IE is opening");
		} else if (utility.fnReadPropFile("browserName").toUpperCase().equals("CHROME")) {
			
			ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI("ws://localhost:5095"));
			SDK.init(config);
			
			browser = BrowserFactory.launch(BrowserType.CHROME);
			// browser.fullScreen();
			System.out.println("Chrome is opening");
			utility.fnLogging("Chrome is opening");
		} else if (utility.fnReadPropFile("browserName").toUpperCase().equals("FIREFOX")) {
			
			ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI("ws://localhost:5095"));
			SDK.init(config);
			
			browser = BrowserFactory.launch(BrowserType.FIREFOX);
			// browser.fullScreen();
			System.out.println("Firefox is opening");
			utility.fnLogging("Firefox is opening");
		}

		return browser;

	}

}
