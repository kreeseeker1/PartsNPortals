package com.game.models;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	// for testing sprites
	private Sprite[] testSprites;
	private int selectedSprite;

	// the blocks making up the world. Array class from libgdx
	Array<Block> blocks = new Array<Block>();
	// bob
	Bob bob;

	public Array<Block> getBlocks() {
		return blocks;
	}

	public Bob getBob() {
		return bob;
	}

	public World() {
		initTestObjects();
		// createDemoWorld();
	}

	public Sprite[] getTestSprites() {
		return testSprites;
	}

	public int getSelectedSprite() {
		return selectedSprite;
	}

	public void setSelectedSprite(int newSelectedSprite) {
		this.selectedSprite = newSelectedSprite;
	}

	// method to create world
	@SuppressWarnings("unused")
	private void createDemoWorld() {
		bob = new Bob(new Vector2(8, 2));
		for (int i = 0; i < 10; i++) {
			blocks.add(new Block(new Vector2(i, 0)));
			// blocks.add(new Block(new Vector2(i, 7)));
			if (i > 2) {
				blocks.add(new Block(new Vector2(i, 1)));
			}

		}

		blocks.add(new Block(new Vector2(9, 2)));
		blocks.add(new Block(new Vector2(9, 3)));
		blocks.add(new Block(new Vector2(9, 4)));
		blocks.add(new Block(new Vector2(9, 5)));

		blocks.add(new Block(new Vector2(6, 3)));
		blocks.add(new Block(new Vector2(6, 4)));
		blocks.add(new Block(new Vector2(6, 5)));
	}

	private void initTestObjects() {
		// create new array for 5 sprites
		testSprites = new Sprite[5];
		// create empty POT-size pixmap with 8 bit RGBA pixel data
		int width = 32;
		int height = 32;
		Pixmap pixmap = createProceduralPixmap(width, height);
		// create texture from pixmap data
		Texture texture = new Texture(pixmap);
		// create new sprites using just created texture
		for (int i = 0; i < getTestSprites().length; i++) {
			Sprite spr = new Sprite(texture);
			// define sprite size to be 1m x 1m in game world
			spr.setSize(1, 1);
			// set origin to sprite's center
			spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
			// calculate random position for sprite
			float randomX = MathUtils.random(-2.0f, 2.0f);
			float randomY = MathUtils.random(-2.0f, 2.0f);
			spr.setPosition(randomX, randomY);
			// put new sprite into array
			getTestSprites()[i] = spr;
		}
		// set first sprite as selected one
		setSelectedSprite(0);

	}

	private Pixmap createProceduralPixmap(int width, int height) {
		Pixmap pixmap = new Pixmap(width, height, Format.RGB888);
		// fill spare with red color at 50% opacity
		pixmap.setColor(1, 0, 0, 0.5f);
		pixmap.fill();
		// draw a yellow color x shape on square
		pixmap.setColor(1, 1, 0, 1);
		pixmap.drawLine(0, 0, width, height);
		pixmap.drawLine(width, 0, 0, height);
		// draw a cyan color border around square
		pixmap.setColor(0, 1, 1, 1);
		pixmap.drawRectangle(0, 0, width, height);
		return pixmap;
	}

	public void update(float deltaTime) {
		updateTestObjects(deltaTime);
	}

	private void updateTestObjects(float deltaTime) {
		// get current rotation from selected sprite
		float rotation = getTestSprites()[getSelectedSprite()].getRotation();
		// rotate sprite by 90 degrees per second
		rotation += 90 * deltaTime;
		// wrap around at 360 degrees
		rotation %= 360;
		// set new rotation value to selected sprite
		getTestSprites()[getSelectedSprite()].setRotation(rotation);
	}

}
