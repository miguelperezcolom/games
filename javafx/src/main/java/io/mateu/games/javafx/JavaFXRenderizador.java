package io.mateu.games.javafx;

import io.mateu.games.core.Juego;
import io.mateu.games.core.Renderizador;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class JavaFXRenderizador implements Renderizador {

    private final Canvas canvas;
    private final Juego juego;
    private final GraphicsContext gc;

    public JavaFXRenderizador(Canvas canvas, Juego juego) {
        this.canvas = canvas;
        this.juego = juego;

        juego.setScreenX(canvas.getWidth());
        juego.setScreenY(canvas.getHeight());

        gc = canvas.getGraphicsContext2D();
    }


    @Override
    public void dibujarFondo(int color) {

        gc.setFill(Color.color(0, 0, 1));
        gc.setStroke(Color.BLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    }
}
