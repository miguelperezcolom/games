package io.mateu.games.core;

public interface Actor extends Objeto {

    int getX();
    int getY();

    void dibujar(Renderizador renderizador);

    void actualizar(long deltaTimeMs);

}
