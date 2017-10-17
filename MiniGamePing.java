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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MiniGamePing extends State implements Screen {

    Texture Palkamy, Palkaenemy, ball, fon;
    Rectangle Rectmy, Rectenemy, Rectball;

    int myvelocity = 0;
    int enemyvelocity = 4;
    Vector2 velocityball, napravlenieball;

    BitmapFont font;
    Viewport viewport;
    Stage stage;

    BitmapFont bitmap;

    Music music;

    float timer;

    int mode = 0, playmode = 0;
    int myscore = 0, notmyscore = 0;

    Preferences MyPreference;
    String Points;

    public MiniGamePing (GameStateManager gam) {
        super(gam);
        viewport = new StretchViewport(480,800,camera);
        viewport.apply();
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        fon = new Texture("pole.png");
        Palkamy = new Texture("palka.png");
        Palkaenemy = new Texture("palka.png");
        ball = new Texture("pingball.png");
        Rectball = new Rectangle(220,400,ball.getWidth(),ball.getHeight());
        Rectmy = new Rectangle(180,50,Palkamy.getWidth(),Palkamy.getHeight());
        Rectenemy = new Rectangle(180,750,Palkaenemy.getWidth(),Palkaenemy.getHeight());
        velocityball = new Vector2(0,0);
        napravlenieball = new Vector2(0,0);

        bitmap = font = new BitmapFont(Gdx.files.internal("text.fnt"));

        music = Gdx.audio.newMusic(Gdx.files.internal("musicfaraway.mp3"));

        MyPreference = Gdx.app.getPreferences("MoneyStatus");
        Points = MyPreference.getString("Points", "0");;

        Gdx.input.setInputProcessor(new MyInputListener());
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
            if (mode == 0){
                mode = 1;
                myscore = 0;
                velocityball.x = 5;
                velocityball.y = -5;
            }
            if (mode == 1){
                if (screenX >= camera.position.x)
                    myvelocity = 5;
                if (screenX < camera.position.x)
                    myvelocity = -5;
            }
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            // TODO Auto-generated method stub
            myvelocity = 0;
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
        camera.update();

        music.setLooping(true);
        music.play();

        if (mode == 1) {

            timer += Gdx.graphics.getDeltaTime();

            Rectmy.x = Rectmy.x + myvelocity;

            if (Rectball.x > Rectenemy.x)
                Rectenemy.x = Rectenemy.x + enemyvelocity;
            if (Rectball.x < Rectenemy.x)
                Rectenemy.x = Rectenemy.x - enemyvelocity;

            if (timer > 10 && playmode == 0) {
                playmode = 1;
                if (velocityball.x > 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x -= 1;
                }
                if (velocityball.x > 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x -= 1;
                }
            }
            if (timer > 16 && playmode == 1) {
                playmode = 2;
                if (velocityball.x > 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                }
                if (velocityball.x < 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                }
                if (velocityball.x > 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                }
                if (velocityball.x < 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                }
            }
            if (timer > 22 && playmode == 2) {
                playmode = 3;
                if (velocityball.x > 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x -= 1;
                }
                if (velocityball.x > 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x -= 1;
                }
            }
            if (timer > 28 && playmode == 3) {
                playmode = 4;
                if (velocityball.x > 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                }
                if (velocityball.x < 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                }
                if (velocityball.x > 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                }
                if (velocityball.x < 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                }
            }
            if (timer > 35 && playmode == 4) {
                playmode = 5;
                if (velocityball.x > 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y > 0) {
                    velocityball.y += 1;
                    velocityball.x -= 1;
                }
                if (velocityball.x > 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x += 1;
                }
                if (velocityball.x < 0 && velocityball.y < 0) {
                    velocityball.y -= 1;
                    velocityball.x -= 1;
                }
            }

            if (myscore > 3)
                enemyvelocity = 5;
            if (myscore > 8)
                enemyvelocity = 6;
            if (myscore > 15)
                enemyvelocity = 7;
            if (myscore > 30)
                enemyvelocity = 8;
            if (myscore > 50)
                enemyvelocity = 9;

            if (Rectmy.x + 120 >= camera.position.x * 2)
                Rectmy.x = camera.position.x * 2 - Rectmy.getWidth();
            if (Rectmy.x <= 0)
                Rectmy.x = 0;
            if (Rectenemy.x + 120 >= camera.position.x * 2)
                Rectenemy.x = camera.position.x * 2 - Rectenemy.getWidth();
            if (Rectenemy.x <= 0)
                Rectenemy.x = 0;

            if (((Rectball.x + 30 > Rectmy.x + 20) && (Rectball.x < Rectmy.x + 100)) && (Rectball.y >= Rectmy.y) && (Rectball.y <= Rectmy.y + 30)){
                Rectball.y = Rectmy.y + 30 ;
                velocityball.y = -1 * velocityball.y;
            }
            if (((Rectball.x + 30 > Rectmy.x) && (Rectball.x + 30 < Rectmy.x + 20)) && (Rectball.y >= Rectmy.y) && (Rectball.y <= Rectmy.y + 30)){
                velocityball.y = -1 * velocityball.y;
                Rectball.x = Rectmy.x - 30 ;
                if (velocityball.x > 0)
                velocityball.x = -velocityball.x;
            }
            if (((Rectball.x > Rectmy.x + 100) && (Rectball.x < Rectmy.x + 120)) && (Rectball.y >= Rectmy.y) && (Rectball.y <= Rectmy.y + 30)){
                velocityball.y = -1 * velocityball.y;
                Rectball.x = Rectmy.x + 120 ;
                if (velocityball.x < 0)
                velocityball.x = -velocityball.x;
            }
            if (((Rectball.x + 30 > Rectenemy.x + 20) && (Rectball.x < Rectenemy.x + 120)) && (Rectball.y + 30 >= Rectenemy.y) && (Rectball.y <= Rectenemy.y + 30)){
                Rectball.y = Rectenemy.y - 30 ;
                velocityball.y = -1 * velocityball.y;
            }
            if (((Rectball.x + 30 > Rectenemy.x) && (Rectball.x + 30 < Rectenemy.x + 20)) && (Rectball.y >= Rectenemy.y) && (Rectball.y <= Rectenemy.y + 30)){
                velocityball.y = -1 * velocityball.y;
                Rectball.x = Rectenemy.x - 30 ;
                if (velocityball.x > 0)
                velocityball.x = -velocityball.x;
            }
            if (((Rectball.x > Rectenemy.x + 100) && (Rectball.x < Rectenemy.x + 120)) && (Rectball.y >= Rectenemy.y) && (Rectball.y <= Rectenemy.y + 30)){
                velocityball.y = -1 * velocityball.y;
                Rectball.x = Rectenemy.x + 120 ;
                if (velocityball.x < 0)
                velocityball.x = -velocityball.x;
            }

            if (Rectball.x + 30 >= camera.position.x * 2) {
                Rectball.x = camera.position.x * 2 - 30;
                velocityball.x = -1 * velocityball.x;
            }
            if (Rectball.x <= 0)
                velocityball.x = -1 * velocityball.x;

            if (Rectball.y >= camera.position.y * 2) {
                playmode = 0;
                timer = 0;
                velocityball.x = -5;
                velocityball.y = 5;
                Rectball.x = 240;
                Rectball.y = 400;
                myscore++;
            }
            if (Rectball.y <= -10) {
                playmode = 0;
                timer = 0;
                velocityball.x = 5;
                velocityball.y = -5;
                Rectball.x = 240;
                Rectball.y = 400;
                notmyscore++;
            }
            if (notmyscore == 5){
                MyPreference.putString("Points", Integer.toString(myscore));
                MyPreference.flush();
                gam.set(new MiniGamePingFinish(gam));
            }

            Rectball.x = Rectball.x + velocityball.x;
            Rectball.y = Rectball.y + velocityball.y;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(fon, 0, 0);
        bitmap.setColor(0, 0, 0, 1);
        if (mode == 0)
            bitmap.draw(sb, "Don't miss 5 balls", 80, 400);
        if (mode == 1) {
            bitmap.draw(sb, Integer.toString(myscore), 235, 100);
            bitmap.draw(sb, Integer.toString(notmyscore), 235, 700);
        }
        sb.draw(ball, Rectball.x, Rectball.y);
        sb.draw(Palkaenemy,Rectenemy.x, Rectenemy.y);
        sb.draw(Palkamy, Rectmy.x, Rectmy.y);
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
        fon.dispose();
        Palkamy.dispose();stage.dispose();
        Palkaenemy.dispose();
        ball.dispose();
        bitmap.dispose();
        music.dispose();
    }
}
