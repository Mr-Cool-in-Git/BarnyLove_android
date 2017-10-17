package nk.teddybear.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class MiniGameDoodleBearSticks {

    private Texture Stick;
    private Vector2 posTopStick;
    private Random rand;
    private Rectangle boundStick;

    public MiniGameDoodleBearSticks(float y) {
        Stick = new Texture("stick.png");

        rand = new Random();

        posTopStick = new Vector2(200, y);

        boundStick = new Rectangle(posTopStick.x, posTopStick.y, Stick.getWidth(), Stick.getHeight());
    }

    public void reposition(float y) {
        posTopStick.set(rand.nextInt(380) + 1, y);
        boundStick.setPosition(posTopStick.x, posTopStick.y);
    }

    public Texture getTopTube() {
        return Stick;
    }

    public Vector2 getPosTopTube() {
        return posTopStick;
    }

    public Rectangle getBoundStick() {
        return boundStick;
    }

    public void dispose() {
        Stick.dispose();
    }
}

