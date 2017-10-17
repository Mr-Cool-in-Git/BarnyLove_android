package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.dnd.DragGestureListener;
import java.util.Random;

public class TeddyRoom extends State implements Screen {

    Texture Fon, unl, warning;
    MenuState RightMenuState;

    BitmapFont font;
    Viewport viewport;
    Stage stage;

    TextureAtlas bAtlas;
    Skin bSkin;
    TextButton ButLeftChange, ButLeftTop, ButLeftMid, ButLeftLow, ButRoom, ButAdv, ButShop, KickLeft, KickRight, KickFace, KickChest;

    Random WaitingActions = new Random();
    Random Zvuk = new Random();
    int viborzvuka;
    int RandomForWaitingActions = 0;
    int UsingRandom = 0;

    // warning
    int ModeWarning = 0;

    // position Bear
    final int Px = 120, Py = 100;

    // for Touch Dragged
    int PosX;

    int BlockAllMoods = 0;

    // Seasons
    int MoodMode = 0;
    // 0 - default
    // 1 - green
    // 2 - pink
    int BearMode = 0;
    // 0 - default
    // 1 - anim zevota
    // 2 - anim looking
    // 3 - anim mahat
    // 4 -  active obida
    // 5 -  active smile
    // 6 -  active arrr
    // 7 -  active ball
    // 8 -  active rocket
    // 9 -  active yoyo
    // 10 - active heart
    // 11 - active loved
    // 12 - active flower
    // 15 - active kicked
    // 16 - active kickedright
    // 17 - active kickedright
    // 18 - active stomach
    float timer = 0;  // for DefaultMode
    float timeranim = 0;  // for BearAnimation
    int obidapoint = 0;

    // Memory for Teddy's money
    Preferences Money;
    String MoneyStatus;
    int money;

    // Music

    // Sounds
    Sound looking, zev, mahat, ball, loved, kicked, tuk, obida, smile, arr1, arr2, rocket, bam;
    int usesound = 0;

    // Atlas
    Atlas atlas;
    AtlasC atlasC;
    AtlasS atlasS;
    AtlasV atlasV;
    AtlasCS atlasCS;
    AtlasCV atlasCV;
    AtlasSV atlasSV;
    AtlasCSV atlasCSV;

    float timepassed = 0;

    Preferences ClothesStatus;
    String NumberCloth;
    String NumberGlasses;
    String NumberHat;

    Texture heartcounter;

    int StatusUseClothes, StatusUseGlasses, StatusUseHat;

    public TeddyRoom(final GameStateManager gam) {
        super(gam);

        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        heartcounter = new Texture("heartscounter.png");

        ClothesStatus = Gdx.app.getPreferences("ShopStatus");
        NumberCloth = ClothesStatus.getString("Clothes", "0");
        NumberGlasses = ClothesStatus.getString("Glasses", "0");
        NumberHat = ClothesStatus.getString("Hat", "0");

        StatusUseClothes = Integer.valueOf(NumberCloth);
        StatusUseGlasses = Integer.valueOf(NumberGlasses);
        StatusUseHat = Integer.valueOf(NumberHat);

        Money = Gdx.app.getPreferences("MoneyStatus");
        MoneyStatus = Money.getString("Money", "0");
        money = Integer.parseInt(MoneyStatus);

        looking = Gdx.audio.newSound(Gdx.files.internal("looking.mp3"));
        zev = Gdx.audio.newSound(Gdx.files.internal("zevota.mp3"));
        mahat = Gdx.audio.newSound(Gdx.files.internal("mahat.mp3"));
        ball = Gdx.audio.newSound(Gdx.files.internal("ball.mp3"));
        loved = Gdx.audio.newSound(Gdx.files.internal("loved.mp3"));
        kicked = Gdx.audio.newSound(Gdx.files.internal("kicked.mp3"));
        tuk = Gdx.audio.newSound(Gdx.files.internal("tuk.mp3"));
        obida = Gdx.audio.newSound(Gdx.files.internal("obida.mp3"));
        smile = Gdx.audio.newSound(Gdx.files.internal("smile.mp3"));
        arr1 = Gdx.audio.newSound(Gdx.files.internal("arr1.mp3"));
        arr2 = Gdx.audio.newSound(Gdx.files.internal("arr2.mp3"));
        rocket = Gdx.audio.newSound(Gdx.files.internal("rocket.mp3"));
        bam = Gdx.audio.newSound(Gdx.files.internal("bam.mp3"));

        if ((StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            atlas = new Atlas();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            atlasV = new AtlasV();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            atlasS = new AtlasS();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            atlasSV = new AtlasSV();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            atlasC = new AtlasC();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            atlasCV = new AtlasCV();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            atlasCS = new AtlasCS();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            atlasCSV = new AtlasCSV();
        Fon = new Texture("teddyroom2.png");
        unl = new Texture("unl.png");
        warning = new Texture("adv.png");
        RightMenuState = new MenuState(380, 500);

        bAtlas = new TextureAtlas("but.pack");
        bSkin = new Skin();
        bSkin.addRegions(bAtlas);

        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.up = bSkin.getDrawable("playbut");
        style1.down = bSkin.getDrawable("playbut");
        style1.font = font;
        TextButton.TextButtonStyle kicks = new TextButton.TextButtonStyle();
        kicks.up = bSkin.getDrawable("kick");
        kicks.down = bSkin.getDrawable("kick");
        kicks.font = font;
        TextButton.TextButtonStyle b1 = new TextButton.TextButtonStyle();
        b1.up = bSkin.getDrawable("bear1");
        b1.down = bSkin.getDrawable("bear1");
        b1.font = font;
        TextButton.TextButtonStyle b2 = new TextButton.TextButtonStyle();
        b2.up = bSkin.getDrawable("bear2");
        b2.down = bSkin.getDrawable("bear2");
        b2.font = font;
        TextButton.TextButtonStyle b3 = new TextButton.TextButtonStyle();
        b3.up = bSkin.getDrawable("bear3");
        b3.down = bSkin.getDrawable("bear3");
        b3.font = font;

        ButRoom = new TextButton("", b1);
        ButRoom.setPosition(405, 680);
        ButRoom.setVisible(true);
        ButRoom.setSize(50, 70);
        ButAdv = new TextButton("", b3);
        ButAdv.setPosition(395, 600);
        ButAdv.setVisible(true);
        ButAdv.setSize(70, 70);
        ButShop = new TextButton("", b2);
        ButShop.setPosition(399, 520);
        ButShop.setVisible(true);
        ButShop.setSize(60, 70);

        ButLeftChange = new TextButton("", style1);
        ButLeftChange.setPosition(0, 700);
        ButLeftChange.setVisible(true);
        ButLeftChange.setSize(100, 100);
        ButLeftTop = new TextButton("", style1);
        ButLeftTop.setPosition(17, 600);
        ButLeftTop.setVisible(true);
        ButLeftTop.setSize(70, 70);
        ButLeftMid = new TextButton("", style1);
        ButLeftMid.setPosition(17, 500);
        ButLeftMid.setVisible(true);
        ButLeftMid.setSize(70, 70);
        ButLeftLow = new TextButton("", style1);
        ButLeftLow.setPosition(17, 400);
        ButLeftLow.setVisible(true);
        ButLeftLow.setSize(70, 70);

        KickLeft = new TextButton("", style1);
        KickLeft.setPosition(80, 250);
        KickLeft.setVisible(false);
        KickLeft.setSize(70, 70);
        KickFace = new TextButton("", style1);
        KickFace.setPosition(150, 230);
        KickFace.setVisible(false);
        KickFace.setSize(120, 120);
        KickRight = new TextButton("", style1);
        KickRight.setPosition(260, 250);
        KickRight.setVisible(false);
        KickRight.setSize(70, 70);
        KickChest = new TextButton("", style1);
        KickChest.setPosition(150, 110);
        KickChest.setVisible(false);
        KickChest.setSize(110, 110);

        ButRoom.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {gam.set(new TeddyPlayground(gam));
            }
        });
        ButAdv.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ModeWarning = 1;
            }
        });
        ButShop.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {gam.set(new Shop(gam));
            }
        });

        ButLeftChange.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (MoodMode == 3) {
                MoodMode = 0;
                    KickChest.setVisible(false);
                    KickFace.setVisible(false);
                    KickLeft.setVisible(false);
                    KickRight.setVisible(false);
                    ButLeftTop.setVisible(true);
                    ButLeftMid.setVisible(true);
                    ButLeftLow.setVisible(true);
            } else {
                MoodMode++;
                    if (MoodMode == 3) {
                        KickChest.setVisible(true);
                        KickFace.setVisible(true);
                        KickLeft.setVisible(true);
                        KickRight.setVisible(true);
                        ButLeftTop.setVisible(false);
                        ButLeftMid.setVisible(false);
                        ButLeftLow.setVisible(false);
                    }
            }
            }
        });
        ButLeftTop.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (MoodMode) {
                    case 0:
                        if (BlockAllMoods == 0) {
                            BearMode = 4;
                            timeranim = 0;
                            usesound = 0;
                            KickChest.setVisible(false);
                            KickFace.setVisible(false);
                            KickLeft.setVisible(false);
                            KickRight.setVisible(false);
                        }
                        break;
                    case 1:
                        if (BlockAllMoods == 0) {
                            BearMode = 7;
                            timeranim = 0;
                            usesound = 0;
                            KickChest.setVisible(false);
                            KickFace.setVisible(false);
                            KickLeft.setVisible(false);
                            KickRight.setVisible(false);
                        }
                        break;
                    case 2:
                        if (BlockAllMoods == 0) {
                            BearMode = 10;
                            usesound = 0;
                            timeranim = 0;
                            KickChest.setVisible(false);
                            KickFace.setVisible(false);
                            KickLeft.setVisible(false);
                            KickRight.setVisible(false);
                        }
                }
            }
        });
        ButLeftMid.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (MoodMode) {
                    case 0:
                        if (BlockAllMoods == 0) {
                            BearMode = 5;
                            timeranim = 0;
                            usesound = 0;
                        }
                        break;
                    case 1:
                        BearMode = 8;
                        timeranim = 0;
                        usesound = 0;
                        BlockAllMoods = 1;
                        break;
                    case 2:
                        if (BlockAllMoods == 0) {
                            BearMode = 11;
                            timeranim = 0;
                            usesound = 0;
                        }
                        break;
                }
            }
        });
        ButLeftLow.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                switch (MoodMode) {
                    case 0:
                        if (BlockAllMoods == 0) {
                            BearMode = 6;
                            timeranim = 0;
                            usesound = 0;
                        }
                        break;
                    case 1:
                        if (BlockAllMoods == 0) {
                            BearMode = 9;
                            timeranim = 0;
                            usesound = 0;
                        }
                        break;
                    case 2:
                        if (BlockAllMoods == 0) {
                            BearMode = 12;
                            timeranim = 0;
                            usesound = 0;
                        }
                        break;
                }
            }
        });

        KickLeft.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (BlockAllMoods == 0) {
                    BearMode = 17;
                    timeranim = 0;
                    usesound = 0;
                    obidapoint++;
                }
            }
        });
        KickFace.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (BlockAllMoods == 0) {
                    BearMode = 15;
                    timeranim = 0;
                    usesound = 0;
                    obidapoint++;
                }
            }
        });
        KickRight.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (BlockAllMoods == 0) {
                    BearMode = 16;
                    timeranim = 0;
                    usesound = 0;
                    obidapoint++;
                }
            }
        });
        KickChest.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (BlockAllMoods == 0) {
                    BearMode = 18;
                    timeranim = 0;
                    usesound = 0;
                    obidapoint++;
                }
            }
        });

        Gdx.input.setCatchBackKey(true);

        stage.addActor(ButRoom);
        stage.addActor(ButAdv);
        stage.addActor(ButShop);

        stage.addActor(ButLeftChange);
        stage.addActor(ButLeftTop);
        stage.addActor(ButLeftMid);
        stage.addActor(ButLeftLow);

        stage.addActor(KickLeft);
        stage.addActor(KickFace);
        stage.addActor(KickRight);
        stage.addActor(KickChest);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        if(Gdx.input.isTouched()){
           if( ModeWarning == 1)
               ModeWarning = 0;
        }

        boolean backPressed = Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.BACK);
        if (backPressed){
            gam.set(new Menu(gam));
        }

        if(obidapoint > 40){
            BlockAllMoods = 1;
            BearMode = 4;
            obidapoint = 0;
        }
        if (BearMode == 0)
            timepassed += Gdx.graphics.getDeltaTime();
        if (BearMode == 4){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                obida.play();
                usesound = 1;
            }
            if (timeranim > 2.5f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
                BlockAllMoods = 0;
            }
        }
        if (BearMode == 5){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                smile.stop();
                smile.play();
                usesound = 1;
            }
            if (timeranim > 2.5f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 6){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                arr1.stop();
                arr2.stop();
                viborzvuka = Zvuk.nextInt(2);
                switch (viborzvuka) {
                    case 0:
                        arr1.play();
                        break;
                    case 1:
                        arr2.play();
                        break;
                }
                usesound = 1;
            }
            if (timeranim > 2.5f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 7){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                ball.stop();
                ball.play();
                usesound = 1;
            }
            if (timeranim > 26/9f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 8){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                rocket.stop();
                rocket.play();
                usesound = 1;
             }
            if (timeranim > 60/8f){
                BlockAllMoods = 0;
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 9){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                usesound = 1;
            }
            if (timeranim > 3f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 10){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                tuk.stop();
                tuk.play();
                usesound = 1;
            }
            if (timeranim > 10/3f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 11){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                loved.stop();
                loved.play();
                usesound = 1;
            }
            if (timeranim > 2f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 12){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                smile.stop();
                smile.play();
                usesound = 1;
            }
            if (timeranim > 24/12f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 15){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                kicked.stop();
                kicked.play();
                usesound = 1;
            }
            if (timeranim > 15/20f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if ((BearMode == 16) || (BearMode == 17)){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                kicked.stop();
                kicked.play();
                bam.stop();
                bam.play();
                usesound = 1;
            }
            if (timeranim > 1f){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        if (BearMode == 18){
            timer = 0;
            timeranim += Gdx.graphics.getDeltaTime();
            if (usesound == 0) {
                kicked.stop();
                kicked.play();
                usesound = 1;
            }
            if (timeranim > 0.8){
                BearMode = 0;
                timeranim = 0;
                usesound = 0;
            }
        }
        timer += Gdx.graphics.getDeltaTime();
        if (UsingRandom == 0)
        RandomForWaitingActions = WaitingActions.nextInt(3) + 1;
        if (timer > 20) {
            UsingRandom = 1;
            BearMode = RandomForWaitingActions;
            timeranim += Gdx.graphics.getDeltaTime();
            switch (BearMode) {
                case 1:
                    if (usesound == 0) {
                        zev.stop();
                        zev.play();
                        usesound = 1;
                    }
                    if (timeranim >= 1.5f) {
                        timer = 0;
                        BearMode = 0;
                        timeranim = 0;
                        UsingRandom = 0;
                        usesound = 0;
                    }
                    break;
                case 2:
                    if (usesound == 0) {
                        looking.stop();
                        looking.play();
                        usesound = 1;
                    }
                    if (timeranim > 3f) {
                        timer = 0;
                        BearMode = 0;
                        timeranim = 0;
                        UsingRandom = 0;
                        usesound = 0;
                    }
                    break;
                case 3:
                    if (usesound == 0) {
                        mahat.stop();
                        mahat.play();
                        usesound = 1;
                    }
                    if (timeranim > 49/50f) {
                        timer = 0;
                        BearMode = 0;
                        timeranim = 0;
                        UsingRandom = 0;
                        usesound = 0;
                    }
                    break;
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {

        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(Fon, 0, 0);
        sb.draw(heartcounter,0,0);
        sb.draw(RightMenuState.fonrightstate(), RightMenuState.getPositionRightState().x,RightMenuState.getPositionRightState().y);

        switch (MoodMode) {
            case 0:
                sb.draw(RightMenuState.getModeMood(), 0, 700);
                sb.draw(RightMenuState.getButtonClick1(), 15, 600);
                sb.draw(RightMenuState.getButtonClick2(), 15, 500);
                sb.draw(RightMenuState.getButtonClick3(), 15, 400);
                break;
            case 1:
                sb.draw(RightMenuState.getModeMoodFriendly(), 0, 700);
                sb.draw(RightMenuState.getButtonClickF1(), 15, 600);
                sb.draw(RightMenuState.getButtonClickF2(), 15, 500);
                sb.draw(RightMenuState.getButtonClickF3(), 15, 400);
                break;
            case 2:
                sb.draw(RightMenuState.getModeMoodRomantic(), 0, 700);
                sb.draw(RightMenuState.getButtonClickR1(), 15, 600);
                sb.draw(RightMenuState.getButtonClickR2(), 15, 500);
                sb.draw(RightMenuState.getButtonClickR3(), 15, 400);
                break;
            case 3:
                sb.draw(RightMenuState.getModeMoodBoxing(), 0, 700);
                break;
        }

        font.draw(sb, String.valueOf(money), 150, 50);
        font.draw(sb, "Good game:)", 257, 40);


        sb.end();
        stage.draw();
        sb.begin();
        sb.draw(unl, RightMenuState.getPositionRightState().x + 27, RightMenuState.getPositionRightState().y + 115);
        if (ModeWarning == 1)
            sb.draw(warning, 0, 0);
        if((BearMode == 0) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion) atlas.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimD().getKeyFrame(timepassed, true), Px, Py );
        if((BearMode == 0) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimD().getKeyFrame(timepassed, true), Px, Py );

        if((BearMode == 1) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimZev().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimZevV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimZevS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimZevSV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimZevC().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimZevCV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimZevCS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 1) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimZevCSV().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 2) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimLooking().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 2) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimLookingV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 2) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimLookingS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 2) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimLookingSV().getKeyFrame(timeranim, true),Px, Py );
        if((BearMode == 2) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimLookingC().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 2) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimLookingCV().getKeyFrame(timeranim, true),Px, Py );
        if((BearMode == 2) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimLookingCS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 2) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimLookingCSV().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 3) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimMahat().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimMahatV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimMahatS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimMahatSV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimMahatC().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimMahatCV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimMahatCS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 3) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimMahatCSV().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 4) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlas.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasV.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasS.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasSV.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlasC.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasCV.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasCS.getBearObida(), Px, Py );
        if((BearMode == 4) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasCSV.getBearObida(), Px, Py );

        if((BearMode == 5) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlas.getBearSmile(), Px, Py );
        if((BearMode == 5) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasV.getBearSmile(), Px, Py );
        if((BearMode == 5) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasS.getBearSmile(), Px, Py );
        if((BearMode == 5) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasSV.getBearSmile(), Px, Py );
        if((BearMode == 5) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlasC.getBearSmile(), Px, Py );
        if((BearMode == 5) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasCV.getBearSmile(), Px, Py);
        if((BearMode == 5) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasCS.getBearSmile(), Px, Py );
        if ((BearMode == 5) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasCSV.getBearSmile(), Px, Py );

        if((BearMode == 6) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );
        if((BearMode == 6) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimArr().getKeyFrame(timeranim, true), Px - 20, Py );

        if((BearMode == 7) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimBall().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimBallV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimBallS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimBallSV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimBallC().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimBallCV().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimBallCS().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 7) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimBallCSV().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 8) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimRocket().getKeyFrame(timeranim, true),Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimRocket().getKeyFrame(timeranim, true),Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );
        if((BearMode == 8) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimRocket().getKeyFrame(timeranim, true), Px - 50, Py );

        if((BearMode == 9) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimYo().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 9) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimYo().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 10) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 10) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimHeart().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 11) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlas.getBearLoved(),Px, Py );
        if((BearMode == 11) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasV.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasS.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasSV.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw(atlasC.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw(atlasCV.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw(atlasCS.getBearLoved(), Px, Py );
        if((BearMode == 11) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw(atlasCSV.getBearLoved(), Px, Py );

        if((BearMode == 12) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 12) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimFlower().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 15) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimKick().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 15) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimKick().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 16) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 16) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimKickR().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 17) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 17) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimKickL().getKeyFrame(timeranim, true), Px, Py );

        if((BearMode == 18) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlas.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasV.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasS.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasSV.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasC.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCV.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
            sb.draw((TextureRegion)atlasCS.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        if((BearMode == 18) && (StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
            sb.draw((TextureRegion)atlasCSV.getAnimSto().getKeyFrame(timeranim, true), Px, Py );
        sb.end();
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
        Fon.dispose();stage.dispose();
        RightMenuState.dispose();
        unl.dispose();
        warning.dispose();
        looking.dispose();
        mahat.dispose();
        zev.dispose();
        loved.dispose();
        tuk.dispose();
        bam.dispose();
        heartcounter.dispose();
        smile.dispose();
        arr1.dispose();
        arr2.dispose();
        ball.dispose();
        kicked.dispose();
        rocket.dispose();
        obida.dispose();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
        atlas.dispose();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 0))
        atlasC.dispose();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
        atlasS.dispose();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
        atlasV.dispose();
        if ((StatusUseHat == 0) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
        atlasSV.dispose();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 0) && (StatusUseClothes == 1))
        atlasCV.dispose();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 0))
        atlasCS.dispose();
        if ((StatusUseHat == 1) && (StatusUseGlasses == 1) && (StatusUseClothes == 1))
        atlasCSV.dispose();
    }
}
