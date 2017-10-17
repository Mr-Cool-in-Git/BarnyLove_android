package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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

public class MiniGameVedroFinish extends State implements Screen {

    Texture fon;
    int total = 0;
    int easymoney = 0;
    int mymoney = 0;
    int itogo = 0;

    Preferences Preferencefromgame;
    String AddMoney;
    String MyMoney;

    Viewport viewport;
    Stage stage;

    BitmapFont font;
    BitmapFont font2;

    Skin bSkin;
    TextButton ButBack, B1;
    TextureAtlas bAtlas;

    public MiniGameVedroFinish(final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        font2 = new BitmapFont(Gdx.files.internal("text.fnt"));
        fon = new Texture("sky.png");

        Preferencefromgame = Gdx.app.getPreferences("MoneyStatus");
        AddMoney = Preferencefromgame.getString("Points", "0");
        MyMoney = Preferencefromgame.getString("Money" , "0");

        total = Integer.valueOf(AddMoney);
        mymoney = Integer.valueOf(MyMoney);

        Preferencefromgame.putString("Points", "0");
        Preferencefromgame.flush();

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
                gam.set(new MiniGameVedro(gam));

            }});
        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new TeddyPlayground(gam));}
        });

        stage.addActor(ButBack);
        stage.addActor(B1);

        if (total < 5)
            easymoney = 0;
        if ((total >= 5) && (total < 10))
            easymoney = 1;
        if ((total >= 10) && (total < 15))
            easymoney = 2;
        if ((total >= 15) && (total < 30))
            easymoney = 3;
        if ((total >= 30) && (total < 40))
            easymoney = 4;
        if ((total >= 40) && (total < 60))
            easymoney = 5;
        if ((total >= 60) && (total < 80))
            easymoney = 6;
        if ((total >= 80) && (total < 90))
            easymoney = 7;
        if ((total >= 90) && (total < 100))
            easymoney = 8;
        if ((total >= 100) && (total < 130))
            easymoney = 10;
        if ((total >= 130) && (total < 150))
            easymoney = 12;
        if ((total >= 150) && (total < 200))
            easymoney = 15;
        if ((total >= 200) && (total < 350))
            easymoney = 20;
        if ((total >= 350) && (total < 500))
            easymoney = 25;
        if ((total >= 500) && (total < 10000))
            easymoney = 50;

        itogo = easymoney + mymoney;
        Preferencefromgame.putString("Money", String.valueOf(itogo));
        Preferencefromgame.flush();


    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.begin();
        sb.draw(fon, 0, 0);
        font.setColor(1, 1, 1, 1);
        font.draw(sb, "Total: " + total, 170, 600);
        font2.setColor(1, 1, 1, 1);
        font2.draw(sb, "You got " + easymoney + " hearts", 100 , 350);
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

        font.dispose();
        fon.dispose();stage.dispose();

    }
}
