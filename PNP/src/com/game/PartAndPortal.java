package com.game;

import com.badlogic.gdx.Game;
import com.game.screens.CreditScreen;
import com.game.screens.GameScreen;
import com.game.screens.HighScoreScreen;
import com.game.screens.MenuScreen;
import com.game.screens.OptionScreen;
import com.game.screens.SplashScreen;

public class PartAndPortal extends Game {
	
	public static final String LOG = "debugging";

	@Override
	public void create() {
		setScreen(getGameScreen());
	}
	
	//get screen for splash
	public SplashScreen getSplashScreen(){
		return new SplashScreen(this);
	}
	
	//get screen for menus
	public MenuScreen getMenuScreen() {
		return new MenuScreen(this);
	}
	
	//get screen for main game
	public GameScreen getGameScreen() {
		return new GameScreen(this);
	}
	
	//get screen for option
	public OptionScreen getOptionScreen() {
		return new OptionScreen(this);
	}
	
	//get screen for high score
	public HighScoreScreen getHighScoreScreen() {
		return new HighScoreScreen(this);
	}
	
	//get screen for credits
	public CreditScreen getCreditScreen() {
		return new CreditScreen(this);
	}
	
}
