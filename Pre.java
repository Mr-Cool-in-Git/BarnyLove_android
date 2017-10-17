package nk.teddybear.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Pre extends State implements Screen {

	private float PreTime = 0, Alpha1 = 0;
	private Sprite PreFon1;

	private Texture prefon1t;
	Viewport viewport;
	Stage stage;

	public Pre(final GameStateManager gam){
		super(gam);

		viewport = new StretchViewport(480,800,camera);
		viewport.apply();

		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);

		prefon1t = new Texture("pre2.png");

		PreFon1 = new Sprite(prefon1t);
		PreFon1.setPosition(0, 0);
		PreFon1.setAlpha(0);

	}

	@Override
	protected void handleInput() {

	}


	@Override
	public void update(float dt) {
		PreTime += Gdx.graphics.getDeltaTime();
		if (Alpha1 < 0.9){
			Alpha1 += 0.005;
		}
		PreFon1.setAlpha(Alpha1);
		if (PreTime > 4){
			gam.set(new Menu(gam));
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		if(PreTime <= 4)
			PreFon1.draw(sb);
		sb.end();
		stage.draw();
	}

	@Override
	public void render(float delta) {

	}

	@Override
	public void show() {
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
		stage.dispose();
		prefon1t.dispose();
	}
}
