package com.game.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraHelper {
	
	private final float MAX_ZOOM_IN = 0.25f;
	private final float MAX_ZOOM_OUT = 10.0f;
	
	private Sprite target; //is used to specify which target the camera should follow
	private Vector2 position; //is used to specify the position
	private float zoom; //zoom
	
	public CameraHelper(){
		position = new Vector2();
		zoom = 1f;
	}

	public Sprite getTarget() {
		return target;
	}

	public void setTarget(Sprite target) {
		this.target = target;
	}
	
	public boolean hasTarget() {
		return target != null;
	}
	
	public boolean hasTarget(Sprite target){
		return hasTarget() && this.target.equals(target);
	}


	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(float x, float y) {
		this.position.set(x,y);
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
	}
	
	public void addZoom(float amount){
		setZoom(getZoom() + amount);
	}
	
	
	public void applyTo(OrthographicCamera camera){
		camera.position.x = position.x;
		camera.position.y = position.y;
		camera.zoom =zoom;
		camera.update();
	}
	
	public void update(float deltaTime){
		if(!hasTarget() ) return;
		
		position.x = target.getX() + target.getOriginX();
		position.y = target.getY() + target.getOriginY();
	}

	
}
