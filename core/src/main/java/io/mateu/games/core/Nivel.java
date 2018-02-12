package io.mateu.games.core;

public interface Nivel {

    void onCreate();

    void onFinish();

    void actualizar(long deltaTime);

    void dibujar(Renderizador renderizador);
}
