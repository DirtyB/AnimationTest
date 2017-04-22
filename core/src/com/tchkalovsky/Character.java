package com.tchkalovsky;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.List;

/**
 * Created by boris_0mrym3f on 26.03.2017.
 */
public class Character {

    HashMap<State, List<TextureRegion>> frames = new HashMap<State, List<TextureRegion>>();

    public Character(AnimationTestGame game){


    }

    public enum State{
        STILL,
        WALKING
    }
}
