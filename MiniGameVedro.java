package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Iterator;

public class MiniGameVedro extends State implements Screen {

    Texture kaplya;
    Texture vedro;
    Sound dropSound;
    Music music;
    Rectangle bucket;
    Vector3 touchPos;
    Array<Rectangle> raindrops;
    long lastDropTime;
    int drops = 0;
    Texture fon;

    Viewport viewport;
    Stage stage;

    Preferences Point;
    String PointStatus;

    BitmapFont font;

    long a = 1500000000;


    public MiniGameVedro (GameStateManager gam) {
        super(gam);

        Point = Gdx.app.getPreferences("MoneyStatus");
        PointStatus = Point.getString("Points", "0");
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont();
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        Gdx.input.setInputProcessor(new MyInputListener());

        touchPos = new Vector3();

        fon = new Texture("sky.png");

        font = new BitmapFont(Gdx.files.internal("text.fnt"));

        kaplya = new Texture("kaplya.gif");
        vedro = new Texture("m3.png");

        dropSound = Gdx.audio.newSound(Gdx.files.internal("bulknulo.mp3"));

        music = Gdx.audio.newMusic(Gdx.files.internal("musictellme.mp3"));

        bucket = new Rectangle();
        bucket.x = 480/ 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;

        raindrops = new Array<Rectangle>();
        spawnRaindrop();

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
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            // TODO Auto-generated method stub
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

    }

    @Override
    public void render(SpriteBatch sb) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        music.setLooping(true);
        music.play();

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(fon, 0 , 0);
        sb.draw(vedro, bucket.x, bucket.y);
        font.setColor(1, 1, 1, 1);
        font.draw(sb, "Drop Collected: " + drops, 0 , 790);
        for ( Rectangle rain: raindrops)
        {
            sb.draw(kaplya, rain.x, rain.y);
        }
        sb.end();

        if(Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = (int) (touchPos.x - 64 / 2);
        }


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 + Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 + Gdx.graphics.getDeltaTime();

        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 480 - 64) bucket.x = 480 - 64;

        if (TimeUtils.nanoTime() - lastDropTime > a) {
            spawnRaindrop();
        }

        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            if (drops < 15) {
                raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 14) && (drops < 30)) {
                raindrop.y -= 250 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 29) && (drops < 50)) {
                raindrop.y -= 350 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 49) && (drops < 90)) {
                raindrop.y -= 450 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 89) && (drops < 200)) {
                raindrop.y -= 550 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 199) && (drops < 400)) {
                raindrop.y -= 600 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 399) && (drops < 9000)) {
                raindrop.y -= 633 * Gdx.graphics.getDeltaTime();
            }
            if ((drops > 10) && (TimeUtils.nanoTime() - lastDropTime > a/2)) {
                spawnRaindrop();
            }
            if ((drops > 20) && (TimeUtils.nanoTime() - lastDropTime > a/2.5)) {
                spawnRaindrop();
            }
            if ((drops > 30) && (TimeUtils.nanoTime() - lastDropTime > a/3)) {
                spawnRaindrop();
            }
            if ((drops > 50) && (TimeUtils.nanoTime() - lastDropTime > a/3.5)) {
                spawnRaindrop();
            }
            if ((drops > 70) && (TimeUtils.nanoTime() - lastDropTime > a/4)) {
                spawnRaindrop();
            }
            if ((drops > 100) && (TimeUtils.nanoTime() - lastDropTime > a/5)) {
                spawnRaindrop();
            }
            if ((drops > 200) && (TimeUtils.nanoTime() - lastDropTime > a/6)) {
                spawnRaindrop();
            }
            if ((drops > 300) && (TimeUtils.nanoTime() - lastDropTime > a/7)) {
                spawnRaindrop();
            }
            if ((drops > 500) && (TimeUtils.nanoTime() - lastDropTime > a/8)) {
                spawnRaindrop();
            }
            if ((drops > 700) && (TimeUtils.nanoTime() - lastDropTime > a/12)) {
                spawnRaindrop();
            }
            if (raindrop.y + 64 < 0) iter.remove();
            if (raindrop.overlaps(bucket))
            {
                drops++;
                dropSound.play();
                iter.remove();
            }
            if (raindrop.y < bucket.y){
                Point.putString("Points", String.valueOf(drops));
                Point.flush();
                gam.set(new MiniGameVedroFinish(gam));
            }
        }

    }

    private void spawnRaindrop(){
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 480 - 64);
        raindrop.y = 800;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
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
    public void dispose () {
        kaplya.dispose();
        vedro.dispose();
        dropSound.dispose();stage.dispose();
        music.dispose();
        fon.dispose();
    }

}
