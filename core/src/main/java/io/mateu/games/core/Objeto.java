package io.mateu.games.core;

public interface Objeto {
    void actualizar(long deltaTime);

    void dibujar(Renderizador renderizador);
}
