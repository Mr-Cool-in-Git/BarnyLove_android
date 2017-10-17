package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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

public class TeddyPlayground extends State implements Screen {

    Texture fon, unlocked , loading;
    float timerforExit = 0;
    int a = 0;
    BitmapFont font;
    Viewport viewport;
    Stage stage;
    TextureAtlas bAtlas;
    Skin bSkin;
    TextButton ButBack, ButGame1, ButGame2, ButGame3, ButGame4;

    public TeddyPlayground(final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        fon = new Texture("teddyplayground2.png");
        unlocked = new Texture("unl.png");
        loading = new Texture("loadingmini.png");

        bAtlas = new TextureAtlas("but.pack");
        bSkin = new Skin();
        bSkin.addRegions(bAtlas);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = bSkin.getDrawable("playbut");
        style.down = bSkin.getDrawable("playbut");
        style.font = font;
        TextButton.TextButtonStyle back = new TextButton.TextButtonStyle();
        back.up = bSkin.getDrawable("back");
        back.down = bSkin.getDrawable("back");
        back.font = font;

        ButBack = new TextButton("", back);
        ButBack.setPosition(375, 30);
        ButBack.setVisible(true);
        ButBack.setSize(80, 80);
        ButGame1 = new TextButton("", style);
        ButGame1.setPosition(70, 470);
        ButGame1.setVisible(true);
        ButGame1.setSize(140, 140);
        ButGame2 = new TextButton("", style);
        ButGame2.setPosition(270, 470);
        ButGame2.setVisible(true);
        ButGame2.setSize(140, 140);
        ButGame3 = new TextButton("", style);
        ButGame3.setPosition(35, 290);
        ButGame3.setVisible(true);
        ButGame3.setSize(140, 140);
        ButGame4 = new TextButton("", style);
        ButGame4.setPosition(325, 290);
        ButGame4.setVisible(true);
        ButGame4.setSize(140, 140);

        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { a = 1;}
        });
        ButGame1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gam.set(new MiniGameVedro(gam));
            }
        });
        ButGame2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gam.set(new MiniGameGuessMe(gam));
            }
        });
        ButGame3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gam.set(new MiniGameDoodleBear(gam));
            }
        });
        ButGame4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gam.set(new MiniGamePing(gam));
            }
        });

        stage.addActor(ButBack);
        stage.addActor(ButGame1);
        stage.addActor(ButGame2);
        stage.addActor(ButGame3);
        stage.addActor(ButGame4);

    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(fon, 0, 0);
        if (timerforExit > 0.1)
            sb.draw(loading, 10, 25);
        sb.end();
        stage.draw();
    }

    @Override
    public void update(float dt) {
        if (a == 1)
            timerforExit += dt;
        if (timerforExit > 0.2)
            gam.set(new TeddyRoom(gam));
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
        fon.dispose();stage.dispose();
        loading.dispose();
    }
}
