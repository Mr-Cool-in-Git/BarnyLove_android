package nk.teddybear.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

import java.util.Random;

public class MiniGameGuessMe extends State implements Screen {

    int level = 1;
    int LifesState = 3;
    int vstuplenie = 1;
    int counter = 2;
    int waiting = 0;
    int MyChoice;
    int Mishka;
    int ClickX, ClickY;
    int LifeBear;

    Music music;
    // Выбор отображения
    int YesTexture = 0;
    int NoTexture = 0;
    int LifeTexture = 0;

    //База данных
    Preferences MyPreference;
    String Score;
    BitmapFont font;
    Viewport viewport;
    Stage stage;
    Skin bSkin;
    TextButton B1, B2, B3, B4, B5, B6;
    TextureAtlas bAtlas;

    // время перезарядки
    float timer = 0;

    Random Rand = new Random();

    Texture Fon, buttonright, buttonwrong, life, buttonlock, replika, buttonlife;
    BitmapFont LevelState;

    public MiniGameGuessMe (final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        MyPreference = Gdx.app.getPreferences("MoneyStatus");
        Score = MyPreference.getString("Points", "0");

        LevelState = new BitmapFont();
        Fon = new Texture("hidenseekroom.png");
        buttonright = new Texture("goodchoice.png");
        buttonwrong = new Texture("wrongchoice.png");
        buttonlock = new Texture("lockedchoice.png");
        replika = new Texture("hidenseekprolog.png");
        buttonlife = new Texture("lifechoice.png");
        life = new Texture("lifes.png");

        music = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));

        bAtlas = new TextureAtlas("but.pack");
        bSkin = new Skin();
        bSkin.addRegions(bAtlas);

        TextButton.TextButtonStyle back = new TextButton.TextButtonStyle();
        back.up = bSkin.getDrawable("playbut");
        back.down = bSkin.getDrawable("playbut");
        back.font = font;

        B1 = new TextButton("", back);
        B1.setPosition(43, 434);
        B1.setVisible(true);
        B1.setSize(100, 180);
        B2 = new TextButton("", back);
        B2.setPosition(192, 434);
        B2.setVisible(true);
        B2.setSize(100, 180);
        B3 = new TextButton("", back);
        B3.setPosition(348, 434);
        B3.setVisible(true);
        B3.setSize(100, 180);
        B4 = new TextButton("", back);
        B4.setPosition(43, 235);
        B4.setVisible(true);
        B4.setSize(100, 180);
        B5 = new TextButton("", back);
        B5.setPosition(194, 235);
        B5.setVisible(true);
        B5.setSize(100, 180);
        B6 = new TextButton("", back);
        B6.setPosition(348, 235);
        B6.setVisible(true);
        B6.setSize(100, 180);

        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (vstuplenie == 0&& waiting == 0) {
                    MyChoice = 1;
                    LOL();
                }
            }
        });
        B2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {if (vstuplenie == 0 && waiting == 0) {
                MyChoice = 2;
                LOL();
            }}
        });
        B3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { if (vstuplenie == 0&& waiting == 0) {
                MyChoice = 3;
                LOL();
            } }
        });
        B4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { if (vstuplenie == 0&& waiting == 0) {
                MyChoice = 4;
                LOL();
            }  }
        });
        B5.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { if (vstuplenie == 0&& waiting == 0) {
                MyChoice = 5;
                LOL();
            } }
        });
        B6.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) { if (vstuplenie == 0&& waiting == 0) {
                MyChoice = 6;
                LOL();
            } }
        });


        stage.addActor(B1);
        stage.addActor(B2);
        stage.addActor(B3);
        stage.addActor(B4);
        stage.addActor(B5);
        stage.addActor(B6);
    }

    private void LOL(){
        switch (level){
            case 1:
                if ((MyChoice <= 2) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    if (MyChoice == Mishka) {
                        YesTexture = MyChoice;
                        level++;
                    } else {
                        NoTexture = MyChoice;
                        LifesState -= 1;
                    }
                }
                break;
            case 2:
                if ((MyChoice <= 2) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    if (MyChoice == Mishka) {
                        YesTexture = MyChoice;
                        level++;
                        counter++;
                    } else {
                        NoTexture = MyChoice;
                        LifesState -= 1;
                    }
                }
                break;
            case 3:
                if ((MyChoice <= 3) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 4:
                if ((MyChoice <= 3) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                            counter++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 5:
                if ((MyChoice <= 4) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                            counter++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 6:
                if ((MyChoice <= 5) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++) {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear) {
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                            counter++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 7:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;

                        }
                    }
                }
                break;
            case 8:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 9:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 10:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 11:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 12:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 13:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 14:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 15:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 16:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
            case 17:
                if ((MyChoice <= 6) && (MyChoice != 0)) {
                    Mishka = Rand.nextInt(counter) + 1;
                    LifeBear = Rand.nextInt(counter) + 1;
                    for (int i = 0; Mishka == LifeBear; i++)
                    {
                        LifeBear = Rand.nextInt(counter) + 1;
                    }
                    if (MyChoice == LifeBear){
                        if (LifesState < 3)
                            LifesState++;
                        LifeTexture = MyChoice;
                    } else {
                        if (MyChoice == Mishka) {
                            YesTexture = MyChoice;
                            level++;
                        } else {
                            NoTexture = MyChoice;
                            LifesState -= 1;
                        }
                    }
                }
                break;
        }
        MyChoice = 0;
        if (LifesState == 0){
            MyPreference.putString("Points", String.valueOf(level));
            MyPreference.flush();
            gam.set(new MiniGameGuessMeFinish(gam));
        }
        waiting = 1;
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {

        if(Gdx.input.isTouched()){
            if (vstuplenie == 2) vstuplenie = 0;
            if (vstuplenie == 1) vstuplenie = 2;
        }

        music.setLooping(true);
        music.play();

        camera.update();
        if (waiting == 1){
            timer += Gdx.graphics.getDeltaTime();
        }
        if (timer > 1.2){
            waiting = 0;
            NoTexture = 0;
            YesTexture = 0;
            LifeTexture = 0;
            timer = 0;
        }
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(Fon, 0, 0);
        if (vstuplenie == 1)
        sb.draw(replika, 185, 660);
        if (vstuplenie == 0) {
            // жизни
            if (LifesState >= 1)
                sb.draw(life, 75, 50);
            if (LifesState >= 2)
                sb.draw(life, 187, 50);
            if (LifesState == 3)
                sb.draw(life, 299, 50);

            // отображение правильного выбора
            if (YesTexture == 1)
                sb.draw(buttonright, 55, 507);
            if (YesTexture == 2)
                sb.draw(buttonright, 206, 507);
            if (YesTexture == 3)
                sb.draw(buttonright, 360, 507);
            if (YesTexture == 4)
                sb.draw(buttonright, 55, 307);
            if (YesTexture == 5)
                sb.draw(buttonright, 206, 307);
            if (YesTexture == 6)
                sb.draw(buttonright, 360, 307);

            // отображение неправильного выбора
            if (NoTexture == 1)
                sb.draw(buttonwrong, 55, 507);
            if (NoTexture == 2)
                sb.draw(buttonwrong, 206, 507);
            if (NoTexture == 3)
                sb.draw(buttonwrong, 360, 507);
            if (NoTexture == 4)
                sb.draw(buttonwrong, 55, 307);
            if (NoTexture == 5)
                sb.draw(buttonwrong, 206, 307);
            if (NoTexture == 6)
                sb.draw(buttonwrong, 360, 307);

            // отображение неправильного выбора
            if (LifeTexture == 1)
                sb.draw(buttonlife, 55, 507);
            if (LifeTexture == 2)
                sb.draw(buttonlife, 206, 507);
            if (LifeTexture == 3)
                sb.draw(buttonlife, 360, 507);
            if (LifeTexture == 4)
                sb.draw(buttonlife, 55, 307);
            if (LifeTexture == 5)
                sb.draw(buttonlife, 206, 307);
            if (LifeTexture == 6)
                sb.draw(buttonlife, 360, 307);

            // кнопки
            if (level < 3)
            sb.draw(buttonlock, 360, 507); // 3
            if (level < 5)
            sb.draw(buttonlock, 55, 307); // 4
            if (level < 6)
            sb.draw(buttonlock, 206, 307); // 5
            if (level < 7)
            sb.draw(buttonlock, 360, 307); // 6

            // фонты
            LevelState.setColor(0, 0, 0, 1);
            LevelState.draw(sb, Integer.toString(level), 370, 733);
        }
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
        Fon.dispose();
        life.dispose();stage.dispose();
        buttonlock.dispose();
        buttonwrong.dispose();
        buttonright.dispose();
        buttonlife.dispose();
        life.dispose();
        LevelState.dispose();
        music.dispose();
    }
}
