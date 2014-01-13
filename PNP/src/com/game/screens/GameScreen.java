package com.game.screens;



import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.game.PartAndPortal;
import com.game.controllers.WorldController;
import com.game.models.World;

public class GameScreen extends AbstractScreen implements InputProcessor {

	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private World world;

	private boolean paused;

	public GameScreen(PartAndPortal game) {
		super(game);	
		// initialize controller and renderer
		this.world = new World();
		this.worldController = new WorldController(world);
		this.worldRenderer = new WorldRenderer(world, worldController);
		// game world is active on start
		this.paused = false;		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		worldRenderer.resize(width, height);
	}

	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(this);
		// sets the clear screen color to given color
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// do not update game world when paused
		if (!paused) {
			// update game world by the time that has passed since last rendered
			// frame
			worldController.update(delta);
		}	
		// render game world to the screen
		worldRenderer.render();
	}

	
	@Override
	public void show() {
		super.show();
	}
	
	public void hide() {
		Gdx.input.setInputProcessor(null);
	};

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.LEFT){
			worldController.leftPressed();
		}
		if(keycode == Keys.RIGHT){
			worldController.rightPressed();
		}
		if(keycode == Keys.Z){
			worldController.zoomInPressed();
		}
		if(keycode == Keys.X){
			worldController.zoomOutPressed();
		}
		if(keycode == Keys.A){
			worldController.leftCameraPressed();
		}
		
		if(keycode == Keys.D){
			worldController.rightCameraPressed();
		}
		return true;
		
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.LEFT){
			worldController.leftReleased();
		}
		if(keycode == Keys.RIGHT){
			worldController.rightReleased();
		}
		if(keycode == Keys.Z){
			worldController.zoomInReleased();;
		}
		if(keycode == Keys.X){
			worldController.zoomOutReleased();;
		}
		if(keycode == Keys.A){
			worldController.leftCameraReleased();
		}
		if(keycode == Keys.D){
			worldController.rightCameraReleased();
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
	
		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		return false;
	}

}
