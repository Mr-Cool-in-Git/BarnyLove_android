package nk.teddybear.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MiniGamePingFinish extends State implements Screen {

    Texture Fon;
    BitmapFont Bit;

    Preferences Pref;
    String MyMoney, MyScore;

    BitmapFont font;
    Viewport viewport;
    Stage stage;

    int perevod, money;

    Skin bSkin;
    TextButton ButBack, B1;
    TextureAtlas bAtlas;


    public MiniGamePingFinish(final GameStateManager gam){
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        Fon = new Texture("pole2.png");
        Bit = new BitmapFont(Gdx.files.internal("text.fnt"));

        Pref = Gdx.app.getPreferences("MoneyStatus");
        MyMoney = Pref.getString("Money", "0");
        MyScore = Pref.getString("Points", "0");

        perevod = Integer.parseInt(MyScore);
        money = Integer.parseInt(MyMoney);

        money = money + perevod;

        Pref.putString("Points", "0");
        Pref.putString("Money", Integer.toString(money));
        Pref.flush();

        bAtlas = new TextureAtlas("but.pack");
        bSkin = new Skin();
        bSkin.addRegions(bAtlas);

        TextButton.TextButtonStyle restart = new TextButton.TextButtonStyle();
        restart.up = bSkin.getDrawable("restart");
        restart.down = bSkin.getDrawable("restart");
        restart.font = font;
        TextButton.TextButtonStyle back = new TextButton.TextButtonStyle();
        back.up = bSkin.getDrawable("back");
        back.down = bSkin.getDrawable("back");
        back.font = font;

        ButBack = new TextButton("", back);
        ButBack.setPosition(355, 50);
        ButBack.setVisible(true);
        ButBack.setSize(80, 80);
        B1 = new TextButton("", restart);
        B1.setPosition(45, 50);
        B1.setVisible(true);
        B1.setSize(80, 80);

        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)  {
                gam.set(new MiniGamePing(gam));

            }});
        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new TeddyPlayground(gam));}
        });

        stage.addActor(ButBack);
        stage.addActor(B1);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(Fon, 0, 0);
        Bit.setColor(0, 0, 0, 1);
        Bit.draw(sb, "Your points: " + Integer.toString(perevod), 110, 600);
        Bit.draw(sb, "Earn money: " + Integer.toString(perevod), 108, 550);
        sb.end();
        stage.draw();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {stage.dispose();
        Fon.dispose();
        Bit.dispose();
    }
}
