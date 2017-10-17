package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class ShopRoom extends State implements Screen{

    Texture fon;
    TextureAtlas bAtlas;
    Viewport viewport;
    Stage stage;
    BitmapFont font;
    Skin bSkin;
    TextButton ButBack;

    public ShopRoom(final GameStateManager gam) {
        super(gam);
        camera.setToOrtho(false, 480, 800);
        fon = new Texture("dutyfreeroom.png");
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        bAtlas = new TextureAtlas("but.pack");
        bSkin = new Skin();
        bSkin.addRegions(bAtlas);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = bSkin.getDrawable("back");
        style.down = bSkin.getDrawable("back");
        style.font = font;

        ButBack = new TextButton("", style);
        ButBack.setPosition(375, 30);
        ButBack.setVisible(true);
        ButBack.setSize(80, 80);

        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { gam.set(new Shop(gam));}
        });

        stage.addActor(ButBack);
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {


    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0.1f, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(fon, 0, 0);
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
        fon.dispose();stage.dispose();
    }
}
