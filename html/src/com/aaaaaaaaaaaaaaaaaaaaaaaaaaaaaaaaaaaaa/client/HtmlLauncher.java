package com.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.Demo;

import static com.badlogic.gdx.backends.gwt.GwtFiles.LocalStorage;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                // return new GwtApplicationConfiguration(true);
                // Fixed size application:
                GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(960, 720);
                return cfg;
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new Demo();
        }
}