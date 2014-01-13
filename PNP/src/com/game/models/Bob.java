package com.game.models;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob {
	public enum State {
		IDLE, 
		WALKING, 
		JUMPING, 
		DYING
	}
	
	public static final float SPEED = 4f;
	static final float JUMP_VELOCITY = 1f;
	public static final float SIZE = 0.5f; //size of bob which is half 1 unit
	
	
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2(); //is used when bob jumps
	Vector2 velocity = new Vector2(); //is used for velocity
	Rectangle bounds = new Rectangle(); //this is used to determine if bob bumps into a wall or not
	State state = State.IDLE; //define bob state at given time
	boolean facingLeft = true;
	
	float stateTime = 0;
	
	
	//constructor to create actor with initial position
	public Bob(Vector2 position){
		this.position = position;
	}


	public Vector2 getPosition() {
		return position;
	}

	public void update(float delta) {
		stateTime += delta;
		position.add(velocity.cpy().scl(delta));	
	}

	public void setFacingLeft(boolean faceLeft) {
		facingLeft = faceLeft;	
	}

	public void setState(State newState) {
		this.state = newState;
		
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}
	

}
