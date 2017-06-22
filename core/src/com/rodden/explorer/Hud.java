package com.rodden.explorer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by David on 6/22/2017.
 */
public class Hud {
    public Stage stage;
    private Viewport port;
    private int score;
    private Label levelLabel;

    public Hud(final SpriteBatch sb) {
        port = new FitViewport(ExplorerMain.V_WIDTH, ExplorerMain.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(port, sb);

        final Table table = new Table();
        table.top();
        table.setFillParent(true);
        levelLabel = new Label("Level 1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(levelLabel);
        stage.addActor(table);
    }
}
