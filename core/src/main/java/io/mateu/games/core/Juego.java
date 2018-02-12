package io.mateu.games.core;

public interface Juego extends Controlador {

    void setRenderizador(Renderizador renderizador);

    void onStart() throws Exception;

    void actualizar(long delta);

    void dibujar();

    boolean isJugando();


    void setScreenX(double width);

    void setScreenY(double height);
}
