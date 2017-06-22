package com.rodden.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by David on 6/22/2017.
 */
public class PlayScreen implements Screen {
    private final ExplorerMain game;
    private final OrthographicCamera camera;
    private Viewport port;
    private final Hud hud;
    private final TmxMapLoader loader;
    private final TiledMap map;
    private final OrthogonalTiledMapRenderer renderer;

    public PlayScreen(final ExplorerMain game) {
        this.game = game;
        camera = new OrthographicCamera();
        port = new FitViewport(ExplorerMain.V_WIDTH, ExplorerMain.V_HEIGHT, camera);
        hud = new Hud(game.batch);
        loader = new TmxMapLoader();
        map = loader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        renderer.render();
        hud.stage.draw();
    }

    public void update(final float delta) {
        handleInput(delta);
        camera.update();
        renderer.setView(camera);
    }

    private void handleInput(final float delta) {
        if (Gdx.input.isTouched())
            camera.position.x += 100 * delta;
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
