package com.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.Demo;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(960, 720);
		config.useVsync(false);
		config.setForegroundFPS(0);
		config.setTitle("Demo");
		new Lwjgl3Application(new Demo(), config);
	}
}
