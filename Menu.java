package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Menu extends State implements Screen {

	Texture Fon, Fon2;
	float timer = 0;
	int a = 0;

	BitmapFont font;
	Viewport viewport;
	Stage stage;

	public Menu(GameStateManager gam) {
		super(gam);

		viewport = new StretchViewport(480,800,camera);
		viewport.apply();
		font = new BitmapFont();
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);

		Fon = new Texture("prefon.png");
		Fon2 = new Texture("prefon2.png");

	}

	@Override
	protected void handleInput() {
		if (Gdx.input.justTouched()){
			a = 1;
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		camera.update();
		Gdx.gl.glClearColor(0.1f, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Fon, 0, 0);
		if (timer > 0.1)
			sb.draw(Fon2, 0, 0);
		sb.end();
	}

	@Override
	public void update(float dt) {
		handleInput();
		if (a == 1)
			timer += dt;
		if(timer > 2){
			gam.set(new TeddyRoom(gam));
		}
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
		Fon2.dispose();
	}
}