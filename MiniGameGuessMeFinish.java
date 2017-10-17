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

public class MiniGameGuessMeFinish extends State implements Screen {

    Preferences MyPrefence;
    String MyMoney, AddMoney;
    int mymoney = 0;
    int score = 0;
    int addmoney = 0;

    Texture fon;

    BitmapFont founds, newmoney;

    BitmapFont font;
    Viewport viewport;
    Stage stage;
    Skin bSkin;
    TextButton B1, B2;
    TextureAtlas bAtlas;

    public MiniGameGuessMeFinish(final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        fon = new Texture("hidenseekroomfinish.png");

        MyPrefence = Gdx.app.getPreferences("MoneyStatus");
        MyMoney = MyPrefence.getString("Money" , "0");
        AddMoney = MyPrefence.getString("Points" , "0");

        mymoney = Integer.valueOf(MyMoney);
        score = Integer.valueOf(AddMoney);

        MyPrefence.putString("Points", "0");
        MyPrefence.flush();

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

        B2 = new TextButton("", back);
        B2.setPosition(305, 30);
        B2.setVisible(true);
        B2.setSize(80, 80);
        B1 = new TextButton("", restart);
        B1.setPosition(95, 30);
        B1.setVisible(true);
        B1.setSize(80, 80);

        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)  {
                gam.set(new MiniGameGuessMe(gam));

            }});
        B2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  gam.set(new TeddyPlayground(gam));}
        });

        stage.addActor(B2);
        stage.addActor(B1);

        founds = new BitmapFont(Gdx.files.internal("text.fnt"));
        newmoney = new BitmapFont();

        switch (score){
            case 1:
                addmoney = 1;
                break;
            case 2:
                addmoney = 2;
                break;
            case 3:
                addmoney = 3;
                break;
            case 4:
                addmoney = 5;
                break;
            case 5:
                addmoney = 7;
                break;
            case 6:
                addmoney = 10;
                break;
            case 7:
                addmoney = 13;
                break;
            case 8:
                addmoney = 16;
                break;
            case 9:
                addmoney = 20;
                break;
            case 10:
                addmoney = 24;
                break;
            case 11:
                addmoney = 28;
                break;
            case 12:
                addmoney = 30;
                break;
            case 13:
                addmoney = 35;
                break;
            case 14:
                addmoney = 40;
                break;
            case 15:
                addmoney = 45;
                break;
            case 16:
                addmoney = 46;
                break;
            case 17:
                addmoney = 50;
                break;

        }

        mymoney = mymoney + addmoney;
        MyPrefence.putString("Money", String.valueOf(mymoney));
        MyPrefence.flush();

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
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(fon, 0, 0);
        founds.setColor(0, 0, 0, 1);
        founds.draw(sb, " Level completed: " + Integer.toString(score), 55, 500);
        founds.setColor(0, 0, 0, 1);
        founds.draw(sb, " Earned hearts: " + Integer.toString(addmoney), 75, 400);
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
        newmoney.dispose();
        founds.dispose();
    }
}
