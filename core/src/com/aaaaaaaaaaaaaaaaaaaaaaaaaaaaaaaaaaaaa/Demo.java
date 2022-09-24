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
	int frameCount = 0;
	List<String> board = getBoardString(WIDTH, HEIGHT);
	List<Float> deltaTimes = new ArrayList<Float>();
	static int HEIGHT = 40;
	static int WIDTH = 100;
	static int CHAR_WIDTH = 8;
	static int CHAR_HEIGHT = 8;


	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("ps2p/ps2p-8-text-32bit.fnt"));
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		frameCount++;


		deltaTimes.add(Gdx.graphics.getDeltaTime());

		float sum = 0.f;
		for (int i = 1; i < deltaTimes.size(); i++) {
			float deltaTime = deltaTimes.get(i);
			sum += deltaTime;
		}
		if (deltaTimes.size() > 100) {
			deltaTimes.remove(0);
		}
		float avgDeltaTime = sum / (deltaTimes.size() == 0 ? 1 : deltaTimes.size());

		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		font.setColor(1, 1, 1, 1);
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				font.draw(batch,
						board.get(y * WIDTH + x),
						x * CHAR_WIDTH,
						Gdx.graphics.getHeight() - y * CHAR_HEIGHT - CHAR_HEIGHT  // leave 1 row empty
				);
			}
		}
		// batch.draw(img, 0, 0);
		font.setColor(1, 0, 0, 1);
		font.draw(batch, "Framecount: " + frameCount + ", FPS: " + 1 / avgDeltaTime, 0, Gdx.graphics.getHeight());
		batch.end();

		board = getBoardString(WIDTH, HEIGHT);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public static List<String> getBoardString(int width, int height) {
		List<String> board = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				String allowedRandomChars = "ABCDEFGHIJKLMNOPQRSTUVWabcdefghijklmnopqrstuvw";
				String letter = Character.toString(allowedRandomChars.charAt((int) Math.floor(Math.random() * allowedRandomChars.length())));
				board.add(letter);
			}
		}
		return board;
	}
}
