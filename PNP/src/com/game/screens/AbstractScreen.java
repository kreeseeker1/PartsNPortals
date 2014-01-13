/*
 * An abstract class that will be a base class for all game screens
 * This abstract class implements Screen class from GDX library
 * 		a constructor that accept the main game as a parameter
 * 		a SpriteBatch to draw on
 */

package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.game.PartAndPortal;

public class AbstractScreen implements Screen {

	protected final PartAndPortal game;
	protected SpriteBatch batch;
	protected final Stage stage;
	protected BitmapFont font;
	protected final Skin skin;

	public AbstractScreen(PartAndPortal game) {
		Texture.setEnforcePotImages(false);
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();

		// making skin for wigets
		skin = new Skin();
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(50, 25, Format.RGBA8888);
		pixmap.setColor(Color.CYAN);
		pixmap.fill();

		skin.add("white", new Texture(pixmap));

		// Store the default libgdx font under the name "default".
		BitmapFont bfont = new BitmapFont();
		bfont.scale(1);
		skin.add("default", bfont);

		this.stage = new Stage(0, 0, true);
	}

	public String getGame() {
		return getClass().getSimpleName();
	}

	public SpriteBatch getBatch() {
		if (batch == null) {
			batch = new SpriteBatch();
		}
		return batch;
	}

	public BitmapFont getFont() {
		if (font == null) {
			font = new BitmapFont();
		}
		return font;
	}

	// Screen implementation
	@Override
	public void show() {
		// set the input processor
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// (1) process the game logic
		// update the actors
		stage.act(delta);
		// (2) draw the result
		// clear the screen with the given RGB color (black)
		Gdx.gl.glClearColor(0.1f, 0.f, 0.f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// draw the actors
		stage.draw();
	}

	@Override
	public void dispose() {
		stage.dispose();
		if (font != null)
			font.dispose();
		if (batch != null)
			batch.dispose();
		if (skin != null)
			skin.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// resize and clear the stage
		stage.setViewport(width, height, true);
		stage.clear();
	}

	@Override
	public void hide() {
		// dispose the resources by default
		dispose();
	}

	@Override
	public void pause() {
		// intentionally left blank
	}

	@Override
	public void resume() {

	}

}
