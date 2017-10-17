package nk.teddybear.game;


import com.badlogic.gdx.Gdx;
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

public class ShopClothes extends State implements Screen {

    Texture fon, ClWithout, ClVest, butbuy, usebut, usedbut;

    int StatusBuyVest;
    int StatusUse = 0;
    BitmapFont price;
    BitmapFont cash;

    Preferences ClothesStatus;
    String NumberCloth;
    String BuyVest;

    int warned = 0;
    float timerwarned = 0;

    Preferences Money;
    String MoneyStatus;

    BitmapFont font;
    Viewport viewport;
    Stage stage;
    Skin bSkin;
    TextButton ButBack, B1, B2, B3, B4;
    TextureAtlas bAtlas;

    int MyCash;

    public ShopClothes(final GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        camera.setToOrtho(false, 480, 800);

        ClothesStatus = Gdx.app.getPreferences("ShopStatus");
        NumberCloth = ClothesStatus.getString("Clothes", "0");
        BuyVest = ClothesStatus.getString("BuyVest", "0");

        StatusBuyVest = Integer.valueOf(BuyVest);
        StatusUse = Integer.valueOf(NumberCloth);

        Money = Gdx.app.getPreferences("MoneyStatus");
        MoneyStatus = Money.getString("Money", "0");
        MyCash = Integer.valueOf(MoneyStatus);

        price = new BitmapFont(Gdx.files.internal("text.fnt"));
        cash = new BitmapFont(Gdx.files.internal("text.fnt"));
        butbuy = new Texture("butbuy.png");
        fon = new Texture("dutyfreeclothes.png");
        ClWithout = new Texture("without.png");
        ClVest = new Texture("vest.png");
        usebut = new Texture("usebut.png");
        usedbut = new Texture("usedbut.png");

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
        B2 = new TextButton("", style);
        B2.setPosition(250, 345);
        B2.setVisible(true);
        B2.setSize(160, 270);
        B1 = new TextButton("", style);
        B1.setPosition(50, 345);
        B1.setVisible(true);
        B1.setSize(160, 270);

        ButBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {gam.set(new Shop(gam));}
        });
        B1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {  if ((StatusBuyVest == 1) && (StatusUse == 1)){
                StatusUse = 0;
                ClothesStatus.putString("Clothes" , Integer.toString(StatusUse));
                ClothesStatus.flush();
            }}
        });
        B2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {if ((StatusBuyVest == 1) && (StatusUse == 0)){
                StatusUse = 1;
                ClothesStatus.putString("Clothes" , Integer.toString(StatusUse));
                ClothesStatus.flush();
            }
                if (StatusBuyVest == 0){
                    if (MyCash < 500){
                        warned = 1;
                    }
                    if (MyCash >= 500){
                        MyCash = MyCash - 500;
                        Money.putString("Money", Integer.toString(MyCash));
                        Money.flush();
                        MoneyStatus = Money.getString("Money", "0");
                        StatusBuyVest = 1;
                        ClothesStatus.putString("BuyVest", Integer.toString(StatusBuyVest));
                        ClothesStatus.flush();
                    }
                }}
        });

        stage.addActor(ButBack);
        stage.addActor(B1);
        stage.addActor(B2);

    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {

        camera.update();

        if (warned == 1){
            timerwarned += Gdx.graphics.getDeltaTime();
        }
        if (timerwarned > 2.2){
            warned = 0;
            timerwarned = 0;
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0.1f, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(fon, 0, 0);
        sb.draw(ClWithout, 50, 450);
        sb.draw(ClVest, 250, 450);
        if ((StatusBuyVest == 0) && (StatusUse == 0)) {
            sb.draw(butbuy, 255, 355);
            sb.draw(usedbut, 55, 355);
        }
        if ((StatusBuyVest == 1) && (StatusUse == 0)) {
            sb.draw(usebut, 255, 355);
            sb.draw(usedbut, 55, 355);
        }
        if ((StatusBuyVest == 1) && (StatusUse == 1)) {
            sb.draw(usedbut, 255, 355);
            sb.draw(usebut, 55, 355);
        }
        if (StatusBuyVest == 0) {
            price.setColor(0, 0, 0, 1);
            price.draw(sb, "Price: 500", 238, 330);
        }
        cash.setColor(0, 0, 0, 1);
        if (warned == 1)
            cash.draw(sb, "No enough money", 40, 50);
        if (warned == 0)
            cash.draw(sb, "My cash: " + MoneyStatus, 40, 50);
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
    public void resize(int width, int height) {stage.getViewport().update(width,height);

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
        ClVest.dispose();
        ClWithout.dispose();
        fon.dispose();stage.dispose();
        butbuy.dispose();
        price.dispose();
        usedbut.dispose();
        usebut.dispose();
        cash.dispose();
    }
}
