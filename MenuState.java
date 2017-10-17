package nk.teddybear.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;

public class MenuState {

    private Vector3 position;
    private BitmapFont font;
    private Texture ModeMoodDefault,ModeMoodBoxing, ModeMoodFriendly, ModeMoodRomantic, ButtonClick1, ButtonClick2, ButtonClick3, ButtonClickF1,ButtonClickF2, ButtonClickR1,ButtonClickR2 , ButtonClickF3, ButtonClickR3, fon;

    public MenuState(int x, int y) {

        position = new Vector3(x, y, 0);
        fon = new Texture ("spisok.png");
        ModeMoodDefault = new Texture("modemood1.png");
        ModeMoodFriendly = new Texture("modemood2.png");
        ModeMoodRomantic = new Texture("modemood3.png");
        ModeMoodBoxing = new Texture("modemood4.png");
        ButtonClick1 = new Texture("clickbuttonhm.png");
        ButtonClick2 = new Texture("clickbuttonsmile.png");
        ButtonClick3 = new Texture("clickbuttonarr.png");
        ButtonClickF1 = new Texture("clickbuttonfball.png");
        ButtonClickF2 = new Texture("clickbuttonfrocket.png");
        ButtonClickF3 = new Texture("clickbuttonfyoyo.png");
        ButtonClickR1 = new Texture("clickbuttonrheart.png");
        ButtonClickR2 = new Texture("clickbuttonrloved.png");
        ButtonClickR3 = new Texture("clickbuttonrflower.png");

        font = new BitmapFont();

    }

    public Vector3 getPositionRightState() { return position; }

    public Texture fonrightstate() {
        return fon;
    }

    public Texture getModeMood() {return ModeMoodDefault;}

    public Texture getModeMoodRomantic() {return ModeMoodRomantic;}

    public Texture getButtonClick1() {return ButtonClick1;}
    public Texture getButtonClick2() {return ButtonClick2;}
    public Texture getButtonClick3() {return ButtonClick3;}

    public Texture getButtonClickF1() {return ButtonClickF1;}
    public Texture getButtonClickF2() {return ButtonClickF2;}
    public Texture getButtonClickF3() {return ButtonClickF3;}

    public Texture getButtonClickR1() {return ButtonClickR1;}
    public Texture getButtonClickR2() {return ButtonClickR2;}
    public Texture getButtonClickR3() {return ButtonClickR3;}

    public Texture getModeMoodFriendly() {return ModeMoodFriendly;}

    public Texture getModeMoodBoxing() {return ModeMoodBoxing;}

    public BitmapFont getFont() { return font;}

    public void dispose() {
        ButtonClick1.dispose();
        ButtonClick2.dispose();
        ButtonClick3.dispose();
        ButtonClickF1.dispose();
        ButtonClickF2.dispose();
        ButtonClickR1.dispose();
        ButtonClickR2.dispose();
        ButtonClickR3.dispose();
        ButtonClickF3.dispose();
        fon.dispose();
        ModeMoodFriendly.dispose();
        font.dispose();
    }

}
