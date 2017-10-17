package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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

public class Shop extends State implements Screen {

    Texture DutyFree, loading;
    float timerforExit = 0;
    int a = 0;
    BitmapFont font;
    Viewport viewport;
    Stage stage;
    Skin bSkin;
    TextButton ButBack, B1, B2, B3, B4;
    TextureAtlas bAtlas;

    public Shop(final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        DutyFree = new Texture("dutyfree.png");
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
        B1 = new TextButton("", style);
        B1.setPosition(5, 415);
        B1.setVisible(true);
        B1.setSize(470, 80);
        B2 = new TextButton("", style);
        B2.setPosition(5, 333);
        B2.setVisible(true);
        B2.setSize(470, 80);
        B3 = new TextButton("", style);
        B3.setPosition(5, 247);
        B3.setVisible(true);
        B3.setSize(470, 80);
        B4 = new TextButton("", style);
        B4.setPosition(5, 165);
        B4.setVisible(true);
        B4.setSize(470, 80);

        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { a = 1;}
        });
        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new ShopClothes(gam));}
        });
        B2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {gam.set(new ShopSunglasses(gam));}
        });
        B3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new ShopHats(gam));}
        });
        B4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {   gam.set(new ShopRoom(gam));}
        });

        stage.addActor(ButBack);
        stage.addActor(B1);
        stage.addActor(B2);
        stage.addActor(B3);
        stage.addActor(B4);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0.1f, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(DutyFree, 0, 0);
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
        DutyFree.dispose();stage.dispose();
        loading.dispose();
    }
}
