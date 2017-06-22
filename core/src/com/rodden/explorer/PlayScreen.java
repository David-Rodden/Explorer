package com.rodden.explorer;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by David on 6/22/2017.
 */
public class PlayScreen implements Screen {
    private final ExplorerMain game;
    private final OrthographicCamera camera;
    private Viewport port;

    public PlayScreen(final ExplorerMain game) {
        this.game = game;
        camera = new OrthographicCamera();
        port = new FitViewport(800, 400);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
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

    }
}
