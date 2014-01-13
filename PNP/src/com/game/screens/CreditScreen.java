package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.game.PartAndPortal;


public class CreditScreen extends AbstractScreen {
    
    public CreditScreen(
    		PartAndPortal game )
        {
            super( game );
            
        }

	@Override
    public void resize(
        int width,
        int height )
    {
        super.resize( width, height );
        stage.clear();
        /************* Creating style for Label **********************/
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = super.getFont();
		labelStyle.fontColor = Color.YELLOW;
		/************* End Creating style for Label **********************/

		/************* Creating label and text buttons **********************/
		// create text label
		final Label welcomeLabel = new Label("Parts and Portals \n\n\n" +
											"the development team: \n\n" +
											"1. Daniel Cochran\n" +
											"2. Jaron Williams\n" +
											"3. Nhan (Jacky) Nguyen",labelStyle);
		welcomeLabel.setPosition(Gdx.graphics.getWidth()/2 - welcomeLabel.getWidth()/2, 0);
		
		MoveToAction moveAction = new MoveToAction();	
		moveAction.setPosition(Gdx.graphics.getWidth()/2 - welcomeLabel.getWidth()/2, Gdx.graphics.getHeight());
        moveAction.setDuration(10f);   
        
        welcomeLabel.addAction(moveAction);
        
        Gdx.app.log( PartAndPortal.LOG, "Delta time: " + Gdx.graphics.getDeltaTime());
        Gdx.app.log( PartAndPortal.LOG, "duration: " + moveAction.getDuration());
        Gdx.app.log( PartAndPortal.LOG, "height of moveaction: " + moveAction.getY());
        Gdx.app.log( PartAndPortal.LOG, "height of window: " + Gdx.graphics.getHeight());     
        Gdx.app.log( PartAndPortal.LOG, "get top of welcome: " + welcomeLabel.getTop());
       

        stage.act(Gdx.graphics.getDeltaTime());
		stage.addActor(welcomeLabel);
    }

    @Override
    public void render(
        float delta )
    {
        super.render( delta );
        
    }



}
