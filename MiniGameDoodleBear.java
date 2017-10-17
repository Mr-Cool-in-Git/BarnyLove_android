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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MiniGameDoodleBear extends State implements Screen {

    Texture DoodleTexture, DT2, Fon;
    Rectangle DoodleRectangle;
    Vector3 position , velocity;
    Vector3 touch;

    BitmapFont font;
    Viewport viewport;
    Stage stage;

    float points;
    int rememberpoints;
    BitmapFont Points;

    private static final int TUBE_SPACING = 250;
    private int TUBE_COUNT = 4;

    Preferences MyPreference;
    String Score;

    Music music;

    private Array<MiniGameDoodleBearSticks> stick;
//
    Texture bomb;
    Array<Rectangle> bombR;
    long lastDropTime = 0;
    Skin bSkin;
    TextButton ButBack, B1;
    TextureAtlas bAtlas;

//
    public MiniGameDoodleBear (GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
//
        bomb = new Texture("mine.png");
        bombR = new Array<Rectangle>();

        music = Gdx.audio.newMusic(Gdx.files.internal("musicalive.mp3"));
//
        position = new Vector3(240,300,0);
        velocity = new Vector3(0,30,0);
        touch = new Vector3();

        Points = new BitmapFont(Gdx.files.internal("text.fnt"));

        DoodleTexture = new Texture("doodlebear.png");
        DT2 = new Texture("doodlebear2.png");
        Fon = new Texture("sky.png");
        DoodleRectangle = new Rectangle(position.x, position.y,DoodleTexture.getWidth(), DoodleTexture.getHeight());

        stick = new Array<MiniGameDoodleBearSticks>();

        for ( int i = 0; i < TUBE_COUNT; i++) {
            stick.add(new MiniGameDoodleBearSticks(i * (TUBE_SPACING + 40)));
        }

        MyPreference = Gdx.app.getPreferences("MoneyStatus");
        Score = MyPreference.getString("Points", "0");

        Gdx.input.setInputProcessor(new MyInputListener());

    }

    private void spawnBomb(){
        Rectangle b = new Rectangle();
        b.x = MathUtils.random(0, 450);
        b.y = camera.position.y + MathUtils.random(70, 400);
        b.width = 30;
        b.height = 30;
        bombR.add(b);
    }

    class MyInputListener implements InputProcessor {


        @Override
        public boolean keyDown(int keycode) {
            switch(keycode) {
                case Input.Keys.UP :
                    break;
                case Input.Keys.DOWN:
                    break;
                case Input.Keys.LEFT:
                    break;
                case Input.Keys.RIGHT:
                    break;
                case Input.Keys.EQUALS:
                    break;
                case Input.Keys.MINUS:
                    break;
            }
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer,
                                 int button) {
            if (screenX >= camera.position.x)
                velocity.x = velocity.x + 14;
            if (screenX < camera.position.x)
                velocity.x = velocity.x - 14;

            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            // TODO Auto-generated method stub
            velocity.x = 0;
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return true;
        }

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        music.setLooping(true);
        music.play();

        lastDropTime += Gdx.graphics.getDeltaTime();

        if (velocity.y == -20)
        velocity.y = -20;
        else
        velocity.y = velocity.y - 1;

        if (DoodleRectangle.y > camera.position.y - 50)
        camera.position.y = camera.position.y + 10;

        for (int i = 0; i < stick.size; i++ ) {

            MiniGameDoodleBearSticks tube = stick.get(i);

                if (camera.position.y - (camera.viewportHeight / 2) > tube.getPosTopTube().y + tube.getTopTube().getWidth()) {
                    tube.reposition(tube.getPosTopTube().y + (TUBE_SPACING * TUBE_COUNT));
                }

            if (position.y < camera.position.y - 680) {
                MyPreference.putString("Points", Integer.toString(rememberpoints));
                MyPreference.flush();
                gam.set(new MiniGameDoodleBearFinish(gam));
            }

        }

        for (MiniGameDoodleBearSticks tube : stick) {

                if ((position.y <= tube.getBoundStick().y + 30 && position.y >= tube.getBoundStick().y + 10) && velocity.y < 0 && (position.x + 77 >= tube.getBoundStick().x && position.x <= 100 + tube.getBoundStick().x)) {
                    velocity.y = 25;

            }

        }

        position.y = velocity.y + position.y;
        position.x = velocity.x + position.x;
        DoodleRectangle.setPosition(position.x, position.y);
        points = position.y / 100;
        if (rememberpoints < points)
            rememberpoints = (int) points;

        if (position.x + 50 < 0)
            position.x = 480 + 50;
        if (position.x > 480 + 50)
            position.x = -50;

        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(Fon, 0, camera.position.y - (camera.viewportHeight / 2));
        for (MiniGameDoodleBearSticks tube : stick) {
             sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        }
        if (velocity.y > 3)
            sb.draw(DT2, DoodleRectangle.x, DoodleRectangle.y);
        if (velocity.y <= 3)
        sb.draw(DoodleTexture, DoodleRectangle.x, DoodleRectangle.y);
        Points.setColor(0,0,0,1);
        Points.draw(sb, Integer.toString(rememberpoints), camera.position.x - 230, camera.position.y + 370 );
       // for ( Rectangle b: bombR)
       // {
       //     sb.draw(bomb, b.x, b.y);
       // }
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
        DoodleTexture.dispose();
        for (MiniGameDoodleBearSticks tube : stick)
            tube.dispose();
        Points.dispose();
        music.dispose();
        System.out.println("Stick Disposed");
        //bomb.dispose();
    }
}
