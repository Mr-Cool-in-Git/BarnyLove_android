package nk.teddybear.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Start extends ApplicationAdapter {

    private GameStateManager gam;
    private SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        gam = new GameStateManager();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        gam.push(new Pre(gam));
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gam.update(Gdx.graphics.getDeltaTime());
        gam.render(batch);
    }

}

