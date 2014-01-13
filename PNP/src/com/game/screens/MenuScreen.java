package com.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.game.PartAndPortal;

public class MenuScreen extends AbstractScreen {
	// private String message = "Welcome to the great menu screen!";
	// private float x, y;

	public MenuScreen(PartAndPortal game) {
		super(game);
	}

	@Override
	public void resize(int width, int height) {

		super.resize(width, height);

		/************* Creating style for TextButton **********************/
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle); // add skin name "default"
		/************* End Creating style for TextButton **********************/

		/************* Creating style for Label **********************/
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = super.getFont();
		labelStyle.fontColor = Color.YELLOW;
		/************* End Creating style for Label **********************/

		/************* Creating label and text buttons **********************/
		// create text label
		final Label welcomeLabel = new Label("Student Originated Software",
				labelStyle);
		welcomeLabel.setPosition(0, 300);
		stage.addActor(welcomeLabel);
		// start game button
		final TextButton startGameButton = new TextButton("Start Game",
				textButtonStyle);
		startGameButton.setPosition(200, 300);
		stage.addActor(startGameButton);
		// options button
		final TextButton optionsButton = new TextButton("Options",
				textButtonStyle);
		optionsButton.setPosition(200, 250);
		stage.addActor(optionsButton);
		// high score button
		final TextButton highScoreButton = new TextButton("High Score",
				textButtonStyle);
		highScoreButton.setPosition(200, 200);
		stage.addActor(highScoreButton);
		//credits button
		final TextButton creditsButton = new TextButton("Credits", textButtonStyle);
		creditsButton.setPosition(200, 150);
		stage.addActor(creditsButton);
		/************* End Creating label and text buttons **********************/

		/************* Creating table to hold buttons **************************/
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		// add button into table
		table.add(welcomeLabel).spaceBottom(10);
		table.row();
		table.add(startGameButton).spaceBottom(10);
		table.row();
		table.add(optionsButton).spaceBottom(10);
		table.row();
		table.add(highScoreButton).spaceBottom(10);
		table.row();
		table.add(creditsButton).spaceBottom(10);
		table.row();
		/************* End Creating table to hold buttons **************************/

		
		
		/************* Handle button listener **************************/
		//listener for main game button
		startGameButton.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.getGameScreen());
			}
		});
		//listener for options button
		optionsButton.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.getSplashScreen());
			}
		});
		//listener for high score button
		highScoreButton.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.getSplashScreen());
			}
		});
		//listener for credit button
		creditsButton.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.getCreditScreen());
				
			}
		});
		/*************End Handle button listener **************************/
		
		
		/*
		 * Use this if want to render a text message instead of menus //
		 * calculate the center point for the message TextBounds bounds =
		 * font.getBounds(message); 
		 * x = (width - bounds.width) / 2; 
		 * y = (height- bounds.height) / 2;
		 */
	}

	/*
	 * Use this if want to render a text message instead of menus
	 * 
	 * @Override public void render(float delta) { super.render(delta);
	 * 
	 * // draw the message batch.begin(); font.draw(batch, message, x, y);
	 * batch.end(); }
	 */

}
