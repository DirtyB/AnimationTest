package com.tchkalovsky;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTestGame extends ApplicationAdapter {
	SpriteBatch batch;
	AssetManager assetManager;

	private static final float frameDuration = 0.18f;

	Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
	float stateTime;

	Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		assetManager.load("badlogic.jpg", Texture.class);
		assetManager.load("fourFrames.png", Texture.class);
		assetManager.load("walk_out/walk.atlas", TextureAtlas.class);
		assetManager.load("music.mp3", Music.class);

		assetManager.finishLoading();

		TextureAtlas atlas = assetManager.get("walk_out/walk.atlas");


		walkAnimation =  new Animation<TextureRegion>(frameDuration, atlas.findRegions("walk"), Animation.PlayMode.LOOP);


		stateTime = 0f;

		music = assetManager.get("music.mp3");
		music.play();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Texture img = assetManager.get("badlogic.jpg");

		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

		// Get current frame of animation for the current stateTime
		TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);


		batch.begin();
		batch.draw(currentFrame, 50, 50, 151, 256); // Draw current frame at (50, 50)
		//batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		music.stop();
		batch.dispose();
		assetManager.dispose();
	}
}
