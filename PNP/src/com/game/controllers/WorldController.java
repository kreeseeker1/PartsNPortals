/*
 * Controller to handle user inputs
 */

package com.game.controllers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.game.PartAndPortal;
import com.game.models.World;
import com.game.utils.CameraHelper;

public class WorldController {
	
	
	enum Keys {
		LEFT, RIGHT,//keys used for characters
		A, D, W, S, //key used for moving camera
		Z, X // keys used for zooming
	}

	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		
		keys.put(Keys.A, false);
		keys.put(Keys.D, false);
		keys.put(Keys.W, false);
		keys.put(Keys.S, false);
		
		keys.put(Keys.Z, false);
		keys.put(Keys.X, false);
	};

	private World world;
	private CameraHelper cameraHelper;

	

	public WorldController(World world) {
		this.world = world;
		cameraHelper = new CameraHelper();
	}
	
	public World getWorld() {
		return world;
	}


	public CameraHelper getCameraHelper() {
		return cameraHelper;
	}

	/*
	 * Handle user input
	 */
	
	/*************** Handle key press to move characters *****************/
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}

	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}

	/*************** End Handle key press to move characters *****************/
	
	
	
	/*************** Handle key press to move camera *****************/
	public void leftCameraPressed(){
		keys.get(keys.put(Keys.A, true));
	}
	
	public void rightCameraPressed(){
		keys.get(keys.put(Keys.D, true));
	}
	
	public void upCameraPressed(){
		keys.get(keys.put(Keys.W, true));
	}
	
	public void downCameraPressed(){
		keys.get(keys.put(Keys.S, true));
	}
	/*************** End Handle key press to move camera *****************/
	
	
	
	
	
	/**************** Handle key press to zoom in and out camera ********/
	public void zoomInPressed(){
		keys.get(keys.put(Keys.Z, true));
	}
	
	public void zoomOutPressed() {
		keys.get(keys.put(Keys.X, true));
	}
	/**************** End Handle key press to zoom in and out camera ********/
	
	
	
	
	/*************** Handle key released of characters *****************/
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	/*************** End Handle key released of characters *****************/
	
	
	
	
	/*************** Handle key released of camera *****************/
	public void leftCameraReleased(){
		keys.get(keys.put(Keys.A, false));
	}
	
	public void rightCameraReleased(){
		keys.get(keys.put(Keys.D, false));
	}
	
	public void upCameraReleased(){
		keys.get(keys.put(Keys.W, false));
	}
	
	public void downCameraReleased(){
		keys.get(keys.put(Keys.S, false));
	}
	/*************** End Handle key released of camera *****************/
	
	/***************Handle key release of zooming a camera ************/
	public void zoomInReleased(){
		keys.put(Keys.Z, false);
	}
	
	public void zoomOutReleased() {
		keys.put(Keys.X, false);
	}
	/***************Handle key release of zooming a camera ************/
	
	// get called every cycle of the game
	public void update(float deltaTime) {
		// processInput();
		processInput(deltaTime);
		world.update(deltaTime);
		// call this to continuously update the camera during game span
		cameraHelper.update(deltaTime);
	}
	
	
	//method to process input regardless of game time
	@SuppressWarnings("unused")
	private void processInput() {

		if (keys.get(Keys.LEFT)) {
			Gdx.app.log(PartAndPortal.LOG, "left key pressed");
		}
		if (keys.get(Keys.RIGHT)) {
			Gdx.app.log(PartAndPortal.LOG, "right key pressed");
		}
		// if nothing pressed or both are pressed, bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT))
				|| !keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT))) {

		}
	}
	
	//method to handle input processing regard of game time
	private void processInput(float deltaTime) {
		float sprMoveSpeed = 5 * deltaTime;

		// Camera Controls (move)
		float camMoveSpeed = 5 * deltaTime;
		// Camera Controls (zoom)
		float camZoomSpeed = 1 * deltaTime;

		if (keys.get(Keys.LEFT)) {
			moveSelectedSprite(-sprMoveSpeed, 0);	
		}
		if (keys.get(Keys.RIGHT)) {
			moveSelectedSprite(sprMoveSpeed, 0);
		}
		if(keys.get(Keys.A)){
			moveCamera(camMoveSpeed, 0); // test moving camera
		}
		if(keys.get(Keys.D)){
			moveCamera(-camMoveSpeed, 0); // test moving camera
		}
		if(keys.get(Keys.Z)){
			cameraHelper.addZoom(camZoomSpeed);
		}
		if(keys.get(Keys.X)){
			cameraHelper.addZoom(-camZoomSpeed);
		}

	}
	
	//method to move the camera
	private void moveCamera(float x, float y) {
		x += cameraHelper.getPosition().x;
		y += cameraHelper.getPosition().y;
		cameraHelper.setPosition(x, y);

	}
	
	//method to move the selected sprite
	private void moveSelectedSprite(float x, int y) {
		world.getTestSprites()[world.getSelectedSprite()].translate(x, y);
	}

}
