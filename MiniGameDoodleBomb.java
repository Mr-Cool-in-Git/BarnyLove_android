package nk.teddybear.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


public class MiniGameDoodleBomb {

    private Texture bomb;
    private Rectangle bombR;
    Random lol;
    Vector2 position;

    public MiniGameDoodleBomb(float y){

        bomb = new Texture("mine.png");
        bombR = new Rectangle(lol.nextInt(449) + 1, 1000, bomb.getWidth(), bomb.getHeight());
        position = new Vector2(lol.nextInt(449) + 1, y);
    }

    public void reposition(float y){
        position.set(lol.nextInt(449) + 1, y);
        bombR.setPosition(position.x, position.y);
    }

    public Vector2 getPosition(){
        return position;
    }

    public Rectangle getBombR() {
        return bombR;
    }

    public Texture getBomb() {
        return bomb;
    }

    public void dispose(){
        bomb.dispose();
    }

}
