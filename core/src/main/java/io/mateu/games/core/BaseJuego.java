package io.mateu.games.core;

import java.util.ArrayList;
import java.util.List;

public class BaseJuego implements Juego {

    private Renderizador renderizador;

    private List<Nivel> niveles = new ArrayList<>();

    public BaseJuego(Renderizador renderizador) {
        this.renderizador = renderizador;
    }

    public void onStart() {

    }

    public void enDie() {

    }

    public void onEnd() {

    }

}
