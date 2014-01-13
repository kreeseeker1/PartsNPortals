/*
 * is used to load textures...
 */
package com.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.game.controllers.WorldController;
import com.game.models.World;
import com.game.utils.Constants;


public class WorldRenderer implements Disposable {
	private OrthographicCamera camera;
	private SpriteBatch batch; //is used to draw our objects with respect to camera's settings
	private World world;
	private WorldController worldController;
	
	/** Textures **/
	private Texture bobTexture;

	public WorldRenderer(World world, WorldController worldController){
		this.world = world;
		this.worldController = worldController;
		batch = new SpriteBatch();
		init();
	}
	
	public void init() {
		
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);		
		camera.position.set(0,0,0);
		camera.update();
		loadTextures();
	}
	
	private void loadTextures() {
		bobTexture = new  Texture(Gdx.files.internal("characters/bob_01.png"));
	}
	
	/*
	 * logic to determine which order game objects are drawn over others
	 */
	public void render(){
		renderTestObjects();
	}
	
	private void renderTestObjects() {
		worldController.getCameraHelper().applyTo(this.getCamera());
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Sprite sprite: world.getTestSprites()) {
			sprite.draw(batch);
		}
		drawBob();
		batch.end();
	}
	

	private void drawBob() {
		Sprite sprite = new Sprite(bobTexture);
		sprite.setSize(2, 2);
		// set origin to sprite's center
		sprite.setOrigin(sprite.getWidth() / 2.0f, sprite.getHeight() / 2.0f);
		sprite.draw(batch);
	}

	//help with resizing
	public void resize(int width, int height){
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height) * width;
		camera.update();
	}
	
	/*
	 * this class is from Disposable which should be called to freee memory
	 */
	@Override
	public void dispose() {
		batch.dispose();
	}
	
	
	//getter and setter
	public OrthographicCamera getCamera() {
		return camera;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public World getWorld() {
		return world;
	}

	public WorldController getWorldController() {
		return worldController;
	}


	public Texture getBobTexture() {
		return bobTexture;
	}


}
