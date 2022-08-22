package com.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class Demo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	List<List<String>> board = getBoardString();
	int frameCount = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("ps2p/ps2p-14-text-32bit.fnt"));
		img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		frameCount++;
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		font.setColor(1, 1, 1, 1);
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				font.draw(batch,
						board.get(y).get(x),
						x * 14,
						Gdx.graphics.getHeight() - y * 14 - 14  // leave 1 row empty
				);
			}
		}
		// batch.draw(img, 0, 0);
		font.setColor(1, 0, 0, 1);
		font.draw(batch, "Framecount: " + Integer.toString(frameCount), 0, Gdx.graphics.getHeight());
		batch.end();

		board = getBoardString();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public static List<List<String>> getBoardString() {
		List<List<String>> board = new ArrayList<>();
		for (int y = 0; y < 100; y++) {
			ArrayList<String> row = new ArrayList<>();
			for (int x = 0; x < 100; x++) {
				String allowedRandomChars = "ABCDEFGHIJKLMNOPQRSTUVWabcdefghijklmnopqrstuvw";
				String letter = Character.toString(allowedRandomChars.charAt((int) Math.floor(Math.random() * allowedRandomChars.length())));
				row.add(letter);
			}
			board.add(row);
		}
		return board;
	}
}
