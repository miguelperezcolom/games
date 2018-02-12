package io.mateu.games.galaxywars;

import io.mateu.games.core.BaseJuego;
import io.mateu.games.core.BaseNivel;
import io.mateu.games.core.Juego;
import io.mateu.games.core.Renderizador;

public class GalaxyWarsGame extends BaseJuego implements Juego {

    public GalaxyWarsGame() {
        super();
        getNiveles().add(new BaseNivel());
    }

}
