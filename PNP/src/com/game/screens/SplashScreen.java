package com.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.game.PartAndPortal;

public class SplashScreen extends AbstractScreen {
	
	private Texture splashTexture;
	

    public SplashScreen(
        PartAndPortal game )
    {
        super( game );
    }

    @Override
    public void show()
    {
        super.show();
        // load the texture with the splash image
        splashTexture = new Texture( "splash/splash_screen.jpg" );
        // set the linear texture filter to improve the image stretching
        splashTexture.setFilter( TextureFilter.Linear, TextureFilter.Linear );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
        super.resize( width, height );

        // let's make sure the stage is clear
        stage.clear();

        //get TextureRegion from Texture
        TextureRegion splashRegion = new TextureRegion( splashTexture, 0, 0, 512, 301 );
        //get Drawable instance from splashRegion
        Drawable splashDrawable = new TextureRegionDrawable(splashRegion);
        //get Image
        Image splashImage = new Image(splashDrawable, Scaling.stretch,Align.bottom | Align.left);
        
        //set color
        splashImage.getColor().a = 0f;
        //add action for fade int and out
        splashImage.addAction(Actions.sequence(Actions.fadeIn(0.75f),
        					Actions.delay(1.75f), Actions.fadeOut(0.75f),
        					new Action() {
        	
								@Override
								public boolean act(float delta) {
									game.setScreen(game.getMenuScreen());
									return true;
								}
        	
        					}
        		));

        // and finally we add the actors to the stage, on the correct order
        stage.addActor( splashImage );
    }

    @Override
    public void dispose()
    {
        super.dispose();
        splashTexture.dispose();    
    }


}
