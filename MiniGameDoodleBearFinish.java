package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
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

public class MiniGameDoodleBearFinish extends State implements Screen {

    Texture Fon;

    BitmapFont itog;
    Preferences MyPreference;
    String Score;
    int total = 0;
    int hearts = 0;
    int myhearts = 0;

    BitmapFont font;
    Viewport viewport;
    Stage stage;
    Skin bSkin;
    TextButton ButBack, B1;
    TextureAtlas bAtlas;
    String MoneyStatus;

    public MiniGameDoodleBearFinish (final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        itog = new BitmapFont(Gdx.files.internal("text.fnt"));
        Fon = new Texture("sky.png");

        MyPreference = Gdx.app.getPreferences("MoneyStatus");
        Score = MyPreference.getString("Points", "0");
        MoneyStatus = MyPreference.getString("Money", "0");
        total = Integer.valueOf(Score);
        MyPreference.putString("Points" , "0");
        MyPreference.flush();

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
        ButBack.setPosition(375, 30);
        ButBack.setVisible(true);
        ButBack.setSize(80, 80);
        B1 = new TextButton("", restart);
        B1.setPosition(25, 30);
        B1.setVisible(true);
        B1.setSize(80, 80);

        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)  {
                gam.set(new MiniGameDoodleBear(gam));

        }});
        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new TeddyPlayground(gam));}
        });

        stage.addActor(ButBack);
        stage.addActor(B1);

        if (total >= 0 && total <= 40)
            hearts = 1;
        if (total > 40 && total <= 70)
            hearts = 2;
        if (total > 70 && total <= 100)
            hearts = 3;
        if (total > 100 && total <= 120)
            hearts = 4;
        if (total > 120 && total <= 160)
            hearts = 5;
        if (total > 160 && total <= 230)
            hearts = 6;
        if (total > 230 && total <= 290)
            hearts = 7;
        if (total > 290 && total <= 350)
            hearts = 8;
        if (total > 350 && total <= 420)
            hearts = 9;
        if (total > 420 && total <= 620)
            hearts = 10;
        if (total > 620 && total <= 800)
            hearts = 15;
        if (total > 800 && total <= 1000)
            hearts = 20;
        if (total > 1000 && total <= 1300)
            hearts = 25;
        if (total > 1300 && total <= 1600)
            hearts = 30;
        if (total > 1600 && total <= 2000)
            hearts = 35;
        if (total > 2000)
            hearts = 50;

        myhearts = Integer.parseInt(MoneyStatus) + hearts;
        MyPreference.putString("Money" , Integer.toString(myhearts));
        MyPreference.flush();

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(Fon, 0, 0);
        itog.setColor(0, 0, 0, 1);
        itog.draw(sb, "Total points : " + total , 90, 650);
        itog.draw(sb, "You get hearts: " + hearts , 90, 600);
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
    public void dispose() {
        itog.dispose();stage.dispose();
        Fon.dispose();
    }
}
